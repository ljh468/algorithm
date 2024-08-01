#include<iostream>
using namespace std;

// 1부터 N까지 출력
void func1 (int n) {
  if (n == 0) return;
  cout << n << ' ';
  func1(n - 1);
}

// 1부터 N까지 합
int prefixSum (int n) {
  if(n == 0) return 0;
  return n + prefixSum(n - 1);
}

int fibo(int n) {
  if (n <= 1) return 1;
  return fibo(n - 1) + fibo (n - 2);
}


int main(void) {
  func1(10);
  cout << '\n';
  
  cout << "prefixSum(10): " << prefixSum(10) << '\n';
  cout << "fibonacci(5): " << fibo(5) << '\n';
} 