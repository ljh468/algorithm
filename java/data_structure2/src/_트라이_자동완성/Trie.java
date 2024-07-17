package _트라이_자동완성;

import java.util.*;

public class Trie {

  private TrieNode root;

  public Trie() {
    this.root = new TrieNode();
  }

  public TrieNode getRoot() {
    return root;
  }

  public void setRoot(TrieNode root) {
    this.root = root;
  }

  public void insert(String word) {
    TrieNode currentNode = root;

    // 단어를 한글자씩 순회
    for (char ch : word.toCharArray()) {
      // 현재노드의 해시테이블에 ch 키가 없으면 새로운 노드 생성
      // 해당 노드(ch)로 이동
      currentNode = currentNode.getChildren()
                               .computeIfAbsent(ch, k -> new TrieNode());
    }
    // 단어의 끝을 나타내는 *(애스터리스크)가 존재하지 않으면 추가
    currentNode.getChildren().putIfAbsent('*', new TrieNode());
  }

  public TrieNode search(String word, boolean isCounting) {
    TrieNode currentNode = this.root;

    for (char ch : word.toCharArray()) {
      // 현재노드의 해시테이블에 해당단어의 key가 존재하면 해당 노드로 이동
      currentNode = currentNode.getChildren().get(ch);
      // 찾는 단어가 없으면 함수 종료
      if (currentNode == null) {
        return null;
      }
    }

    // 검색된 단어의 빈도수를 1증가 (단어의 끝을 나타내는 *의 count를 증가)
    if (isCounting) {
      TrieNode endNode = currentNode.getChildren().get('*');
      if (endNode != null) {
        endNode.setCount(endNode.getCount() + 1);
      }
    }
    // 단어를 찾으면 마지막 노드를 리턴
    return currentNode;
  }

  // 완전한 단어를 모두 조회하는 getAllWords 메서드
  public List<WordData> getAllWords(TrieNode startNode,
                                    String word,
                                    List<WordData> words) {
    // startNode가 없으면 루트노드로 설정, 있다면 startNode부터 순회(재귀호출시 수행됨)
    TrieNode currentNode = (startNode != null) ? startNode : this.root;

    for (Map.Entry<Character, TrieNode> entry : currentNode.getChildren().entrySet()) {
      char key = entry.getKey();
      TrieNode childNode = entry.getValue();

      // *(에스터리스크)를 키값으로 가지면 단어의 완성이므로 words 배열에 완전한 단어 추가
      if (key == '*') {
        words.add(new WordData(word, childNode.getCount())); // 빈도수도 같이 저장
      }
      // 단어가 완성되지 않았으므로 재귀호출 (startNode를 childNode로 설정)
      else {
        this.getAllWords(childNode, word + key, words);
      }
    }

    return words;
  }

  // 자동완성된 단어를 추천하는 autoComplete 메서드
  public List<WordData> autoComplete(String word) {
    TrieNode currentNode = search(word, false);
    if (currentNode == null) {
      return null;
    }
    return getAllWords(currentNode, word, new ArrayList<>());
  }

  /**
   * 검색 빈도가 높은 순서대로 추천해주는 autoCompleteByCount 메서드
   * - 사용자가 검색할 때마다 검색빈도를 하나씩 올려주고, 최대힙을 이용해서 더 많이 검색된 단어를 먼저 추천하는 방식
   */
  public List<WordData> autoCompleteByCount(String word) {
    // 자동완성된 단어들을 검색
    List<WordData> words = autoComplete(word);
    if (words == null) {
      return Collections.emptyList();
    }
    // PriorityQueue는 기본값이 최소힙, 큰 값을 우선으로 정렬하려면 음수로 변경 (최대힙으로 설정)
    PriorityQueue<WordData> heap = new PriorityQueue<>(Comparator.comparingInt(WordData::getPriority)
                                                                 .reversed());
    heap.addAll(words); // 최대힙에 단어를 추가

    // 힙에서 데이터를 꺼내면서 힙정렬 수행
    List<WordData> sortedBySearchCount = new ArrayList<>();
    while (!heap.isEmpty()) {
      sortedBySearchCount.add(heap.poll()); // heap.poll은 비어있으면 null을 반환
    }
    // 검색 횟수가 많은 순서대로 저장된 List를 리턴
    return sortedBySearchCount;
  }

  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("고등어");
    trie.insert("김치");
    trie.insert("김치찜");
    trie.insert("김치찌개");

    System.out.println("==== 두부 검색 ====");
    System.out.println(trie.search("두부", false));
    System.out.println("==== 김치 검색 ====");
    System.out.println(trie.search("김치", false));

    System.out.println("==== 모든 단어 검색 ====");
    System.out.println(trie.getAllWords(null, "", new ArrayList<>()));

    System.out.println("==== '김' 검색 ====");
    System.out.println(trie.autoComplete("김"));

    System.out.println("==== 여러 단어들 검색 수행 ====");
    trie.search("김치찌개", true);
    trie.search("김치찌개", true);
    trie.search("김치", true);
    trie.search("김치", true);
    trie.search("김치", true);
    trie.search("김치", true);
    trie.search("김치", true);
    trie.search("김치", true);
    trie.search("김치", true);
    trie.search("김치", true);
    trie.search("김치", true);
    trie.search("김치찜", true);

    List<WordData> results = trie.autoCompleteByCount("김치");
    for (WordData wd : results) {
      System.out.println(wd);
    }

  }

}