#include <bits/stdc++.h>
using namespace std;

int main(void) {
  list<int> L = {1, 2}; // 1 2
  list<int>::iterator t = L.begin(); // t는 1을 가리키는 중
  
  // t가 가리키는 값 = 1을 출력
  cout << "L.begin(): " << *L.begin() << '\n';
  cout << "t: "<< *t << '\n';

  // 맨 위에 삽입
  L.push_front(10); // 10 1 2

  // 맨 뒤에 삽입
  L.push_back(5);  // 10 1 2 5

  // t가 가리키는 곳 앞에 6을 삽입
  L.insert(t, 6);  // 10 6 1 2 5
  
  cout << "L.begin(): " << *L.begin() << '\n';
  cout << "t: "<< *t << '\n';
  
  cout << "t 한칸 오른쪽 이동" << '\n';
  advance(t, 1); // t를 한칸 오른쪽 이동
  cout << "t: "<< *t << '\n'; // t: 2
  
  // t가 가리키는 값(2)을 제거, 그 다음 원소인 5의 위치를 반환
  // 10 6 1 5 (t가 가리키는 값은 5)
  cout << "t가 가리키는 값(2)을 제거" << "\n";
  t = L.erase(t);
  
  cout << "t: " << *t << '\n';  // 5

  // 리스트 출력 1
  for (auto i : L) {
    cout << i << ' ';
  }
  cout << '\n';

  // 리스트 출력 2
  for (list<int>::iterator it = L.begin(); it != L.end(); it++) {
    cout << *it << ' ';
  }
  
  return 0;
}