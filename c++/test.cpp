#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

vector<int> v;
int main() {
  // 예시 벡터 생성 (정렬되지 않은 상태)
  vector<int> v1 = {3, 1, 2, 3, 2, 4, 1, 5, 3};

  // 중복 요소 재배치 (정렬되지 않은 상태에서)
  auto last1 = unique(v1.begin(), v1.end());

  // 결과 출력 (정렬되지 않은 상태에서 unique 사용 후)
  cout << "정렬되지 않은 상태에서 unique 사용 후:\n";
  for (auto it = v1.begin(); it != last1; ++it) {
    cout << *it << " ";
  }
  cout << endl;

  // 벡터를 정렬된 상태로 만들기
  vector<int> v2 = {3, 1, 2, 3, 2, 4, 1, 5, 3};
  sort(v2.begin(), v2.end());
  cout << "정렬된 상태:\n";
  for (int num : v2) {
    cout << num << " ";
  }
  cout << endl;

  // 중복 요소 재배치 (정렬된 상태에서)
  auto last2 = unique(v2.begin(), v2.end());

  cout << "정렬된 상태에서 unique 사용:\n";
  for (int num : v2) {
    cout << num << " ";
  }
  cout << endl;
  
  // 새로운 끝 부분까지 벡터를 잘라내기
  v2.erase(last2, v2.end());

  // 결과 출력 (정렬된 상태에서 unique 사용 후)
  cout << "재배치 후 erase 사용:\n";
  for (int num : v2) {
    cout << num << " ";
  }
  cout << endl;

  return 0;
}