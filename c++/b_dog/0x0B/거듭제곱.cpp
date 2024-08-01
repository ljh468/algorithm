#include<iostream>
using namespace std;

// a^b mod m
// 1. a를 b번 곱하고 m을 나눈 나머지를 구하는 방법
int func1(int a, int b, int m) {
  int val = 1;
  while(b--) {
    val *= a;
  }
  return val % m;
}

// 1-1. int overflow를 보완
using ll = long long;
ll func11(ll a, ll b, ll m) {
  ll val = 1;
  while(b--) {
    val = val * a % m;
  }
  return val;
}

int main(void) {
  int a, b, m;
  
  // 6^100 mod 5 = 1 BUT int overflow로 인해 0이 나온다.
  cout << "6^100 mod 5 = 1 - (int overflow 발생):\n";
  a = 6, b = 100, m = 5;
  cout << "곱하기 방식 : " << func1(a, b, m) << '\n';
  cout << '\n';
  
  cout << "6^100 mod 5 = 1 - (int overflow 보완):\n";
  a = 6, b = 100, m = 5;
  cout << "곱하기 보완 : " << func11(a, b, m) << '\n';
  cout << '\n';
}