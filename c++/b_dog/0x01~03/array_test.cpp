#include <bits/stdc++.h>
using namespace std;

void insert(int idx, int num, int arr[], int& len) {
  // 1. 추가할 index부터 끝까지 한칸씩 뒤로 미룬다.
  for (int i = len; i > idx; i--) {
    arr[i] = arr[i - 1];
  }
  // 2. 추가할 index에 값을 추가한다.
  arr[idx] = num;
  len++;
}

void erase(int idx, int arr[], int& len) {
  // 1. 삭제할 index부터 끝까지 한 칸씩 앞으로 당긴다.
  for (int i = idx; i < len; i++) {
    arr[i] = arr[i + 1];
  }
  // 2. 배열의 길이를 감소시킨다.
  len--;
}

void printArr(int arr[], int& len) {
  for (int i = 0; i < len; i++) {
    cout << arr[i] << " ";
  }
  cout << "\n\n";
}

int main() {
  int len = 9;
  int a[10] = {1, 2, 4, 5, 6, 7, 8, 9, 10};
  cout << "원본 배열: " << '\n';
  printArr(a, len);

  cout << "3{index(2)} 추가: " << '\n';
  insert(2, 3, a, len);
  printArr(a, len);

  cout << "4{index(3)} 제거: " << '\n';
  erase(3, a, len);
  printArr(a, len);

  // 사용팁 - 배열 초기화 방법
  int aa[21];
  int bb[21][21];

  // 1. for
  for (int i = 0; i < 21; i++) {
    aa[i] = 0;
  }

  for (int i = 0; i < 21; i++) {
    for (int j = 0; j < 21; j++) {
      bb[i][j] = 0;
    }
  }

  // 2. fill
  int len2 = 21;
  fill(aa, aa + len2, 0);
  printArr(aa, len2);

  // 2-1. fill을 활용한 2차원 배열 초기화
  for (int i = 0; i < len2; i++) {
    fill(bb[i], bb[i] + len2, 0);
  }

  // 2차원 배열 출력
  for (const auto& row : bb) { // "for (int(&row)[21] : bb) {" 도 가능
    for (int val : row) {
      cout << val << " ";
    }
    cout << "\n";
  }
  cout << "\n";

  return 0;
}