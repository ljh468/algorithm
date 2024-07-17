package _트라이_자동완성;

// 완성된 단어들을 빈도도 같이 저장해주기 위한 객체
public class WordData {

  private String word;

  private int count;

  private int priority;

  public WordData(String word, int count) {
    this.word = word;
    this.count = count;
    this.priority = count;
  }

  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public int getPriority() {
    return priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  @Override
  public String toString() {
    return "WordData{" +
        "word='" + word + '\'' +
        ", count=" + count +
        ", priority=" + priority +
        '}';
  }

}
