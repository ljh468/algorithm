#include <iostream>
using namespace std;
using ll = long long;

// 재귀함수 활용
ll POW(int a, int b, int c) {
  // 기저조건
  if (b == 1) {
    return a % c;
  }
  
  // a ^ b/2 mod c
  ll val = POW(a, b / 2, c);
  val = val * val % c;
  
  // b가 짝수이면 반환
  if (b % 2 == 0) {
    return val;
  }
  
  // b가 홀수이면 a를 한번 더 곱해서 반환
  return val * a % c;
}

// A, B, C는 모두 2,147,483,647 이하의 자연수
// a^b -> a를 b번 곱하는 방식은 시간초과가 발생함
int main(void) {
  ios::sync_with_stdio(0), cin.tie(0);
  ll a, b, c;
  cin >> a >> b >> c;
  cout << POW(a, b, c);
}