package _해시테이블;

import java.util.Iterator;
import java.util.LinkedList;

public class HashTable {

  private static final int INITIAL_CAPACITY = 10;

  private final LinkedList<HashData>[] table;

  public LinkedList<HashData>[] getTable() {
    return table;
  }

  public HashTable() {
    this.table = new LinkedList[INITIAL_CAPACITY];
    for (int i = 0; i < INITIAL_CAPACITY; i++) {
      table[i] = new LinkedList<>();
    }
  }

  // getHash(number) - 간단한 해시함수 (key 값에 10을 나눈 나머지)
  private Integer getHash(int key) {
    return key % 10;
  }

  // set(key, value) - 데이터 삽입
  public void set(int key, String value) {
    int index = getHash(key);
    LinkedList<HashData> bucket = table[index];

    for (HashData hashData : bucket) {
      if (hashData.getKey() == key) {
        hashData.setValue(value);
        return;
      }
    }
    bucket.add(new HashData(key, value));
  }

  // get() - 데이터 읽기
  public String get(int key) {
    int index = getHash(key);
    LinkedList<HashData> bucket = table[index];

    for (HashData hashData : bucket) {
      if (hashData.getKey() == key) {
        return hashData.getValue();
      }
    }
    return null;
  }

  // remove() 데이터 삭제
  public void remove(int key) {
    int index = getHash(key);
    LinkedList<HashData> bucket = table[index];

    Iterator<HashData> iterator = bucket.iterator();
    while (iterator.hasNext()) {
      HashData data = iterator.next();
      if (data.getKey() == key) {
        iterator.remove();  // Iterator를 사용하여 안전하게 삭제
        break;
      }
    }
  }

  public static void main(String[] args) {
    HashTable hashTable = new HashTable();
    hashTable.set(1, "이운재");
    hashTable.set(4, "최진철");
    hashTable.set(20, "홍명보");
    hashTable.set(6, "유상철");
    hashTable.set(22, "송종국");
    hashTable.set(21, "박지성");
    hashTable.set(5, "김남일");
    hashTable.set(10, "이영표");
    hashTable.set(8, "최태욱");
    hashTable.set(9, "설기현");
    hashTable.set(14, "이천수");

    System.out.println("hashTable.get(1) = " + hashTable.get(1));
    System.out.println("등번호 1번 선수 제거");
    hashTable.remove(1);
    System.out.println("hashTable.get(1) = " + hashTable.get(1));
    System.out.println("hashTable.get(21) = " + hashTable.get(21));

    System.out.println("모든 해시테이블 출력");
    LinkedList<HashData>[] table = hashTable.getTable();
    for (int i = 0; i < 10; i++) {
      LinkedList<HashData> hashData = table[i];
      for (HashData data : hashData) {
        System.out.println("index: " + i + " data: " + data);
      }
    }
  }

}
