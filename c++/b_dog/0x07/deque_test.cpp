#include <deque>
#include <iostream>
using namespace std;

const int MX = 1000005;

// 배열의 크기는 2배로 가져감 (MX * 2 + 1)
int dat[2 * MX + 1];

// deque은 양쪽에서 데이터가 나올 수 있어서, 양쪽으로 확장해야함
// 시작점을 배열의 중간지점으로 하면 됨
int head = MX, tail = MX;

void push_front(int x) { dat[--head] = x; }

void push_back(int x) { dat[tail++] = x; }

void pop_front() { head++; }

void pop_back() { tail--; }

int front() { return dat[head]; }

int back() { return dat[tail - 1]; }

void test() {
  push_back(30);            // 30
  cout << front() << '\n';  // 30
  cout << back() << '\n';   // 30
  
  push_front(25);           // 25 30
  push_back(12);            // 25 30 12
  cout << back() << '\n';   // 12
  
  push_back(62);            // 25 30 12 62
  pop_front();              // 30 12 62
  cout << front() << '\n';  // 30
  
  pop_front();              // 12 62
  cout << back() << '\n';   // 62
}

int main() {
  test();
  return 0;
}