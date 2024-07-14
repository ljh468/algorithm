#include <bits/stdc++.h>
using namespace std;

/**
 * 주어진 길이 N의 int 배열 arr에서 합이 100인 서로 다른 위치의 두 원소가
 * 존재하면 1을, 존재하지 않는다면 0을 반환하는 함수 finc2(int arr[], int N)을
 * 작성하라. arr의 각 수는 0 이상 100이하이고 N은 1000이하이다.
 *
 * 입력 배열을 돌면서 100이 되는데 필요한 수가 존재하는지 확인
 */

int func2(int arr[], int n) {
  int occur[101] = {};
  for (int i = 0; i < n; i++) {
    // 100이 되는데 필요한 수가 배열에 마킹되어 있는지 확인
    if (occur[100 - arr[i]] == 1) {
      return 1;
    }
    occur[arr[i]] = 1;  // 배열에 마킹
  }
  return 0;
};

int main() {
  int arr[5] = {1, 23, 53, 77, 60};
  int result = func2(arr, 5);
  cout << "result: " << result;
  return 0;
}