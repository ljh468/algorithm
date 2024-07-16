#include <algorithm>
#include <iostream>
using namespace std;

const int MX = 1000005;
int dat[MX];
int pos = 0;

void push(int x) { dat[pos++] = x; };

void pop() { pos--; };

int top() { return dat[pos - 1]; };

void test() {
  push(5);
  push(4);
  push(3);
  // 5, 4, 3

  cout << top() << '\n';  // 3

  pop();  // 3 제거
  pop();  // 4 제거

  cout << top() << '\n';  // 5

  push(10);
  push(12);
  // 5, 10, 12

  cout << top() << '\n';  // 12

  pop();  // 12 제거

  cout << top() << '\n';  // 10
}

int main() { test(); }