package _해시테이블;

public class HashData {

  private int key;

  private String value;

  public HashData(int key, String value) {
    this.key = key;
    this.value = value;
  }

  public int getKey() {
    return key;
  }

  public String getValue() {
    return value;
  }

  public void setKey(int key) {
    this.key = key;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "HashData{" +
        "key=" + key +
        ", value=" + value +
        '}';
  }
}
