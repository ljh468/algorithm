package _셋;

import _해시테이블.HashData;
import _해시테이블.HashTable;

import java.util.LinkedList;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class HashSet {

  private final HashTable hashTable = new HashTable();

  // add(data) - 데이터 삽입
  void add(int data) {
    if (isNull(hashTable.get(data))) {
      hashTable.set(data, "-1");
    }
  }

  // isContain(data) - 데이터 체크
  boolean isContain(int data) {
    return nonNull(hashTable.get(data));
  }

  // remove(data) - 데이터 제거
  void remove(int date) {
    hashTable.remove(date);
  }

  // clear() - 셋 비우기
  void clear() {
    LinkedList<HashData>[] table = hashTable.getTable();
    for (LinkedList<HashData> bucket : table) {
      bucket.clear();
    }
  }

  // isEmpty() - 셋이 비었는지 체크
  boolean isEmpty() {
    LinkedList<HashData>[] table = hashTable.getTable();
    for (LinkedList<HashData> bucket : table) {
      if (!bucket.isEmpty()) {
        return false;
      }
    }
    return true;
  }

  // printAll() - 모든 데이터 출력
  void printAll() {
    LinkedList<HashData>[] table = hashTable.getTable();
    for (int i = 0; i < table.length; i++) {
      LinkedList<HashData> bucket = table[i];
      if(!bucket.isEmpty()) {
        for (HashData data : bucket) {
          System.out.println("index: " + i + " data: " + data);
        }
      }
    }
  }

  public static void main(String[] args) {
    HashSet hashSet = new HashSet();
    System.out.println("isEmpty: " + hashSet.isEmpty());
    System.out.println("==== 데이터 삽입 ====");
    hashSet.add(1);
    hashSet.add(1);
    hashSet.add(123);
    hashSet.add(512);
    hashSet.printAll();
    System.out.println("isEmpty: " + hashSet.isEmpty());

    System.out.println("==== 데이터 체크1 ====");
    System.out.println("isContain: " + hashSet.isContain(1));

    System.out.println("==== 데이터1 제거 ====");
    hashSet.remove(1);
    hashSet.printAll();
    System.out.println("isEmpty: " + hashSet.isEmpty());

    System.out.println("==== 데이터 체크2 ====");
    System.out.println("isContain: " + hashSet.isContain(1));

    System.out.println("==== clear ====");
    hashSet.clear();
    hashSet.printAll();
    System.out.println("isEmpty: " + hashSet.isEmpty());
  }
  
}
