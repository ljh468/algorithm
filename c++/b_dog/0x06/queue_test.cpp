#include <iostream>
using namespace std;

const int MX = 1000005;
int dat[MX];
int head = 0, tail = 0;

/**
 * 배열로 구현한 큐는 head와 tail이 계속 커지는 구조이므로 배열의 크기만큼만
 * 사용할 수 있음 쓸모없는 공간을 다시 사용할 수 있도록 원형 큐로 구현하면
 * 낭비없이 사용할 수 있음
 */
void push(int x) {
  cout << "push: " << x << '\n';
  dat[tail] = x;
  // tail 증가
  if (++tail == MX) {
    head = 0;
  }
}

void pop() {
  cout << "pop: " << dat[head] << '\n';
  // head 증가
  if (++head == MX) {
    head = 0;
  }
}

int front() { return dat[head]; }

int back() { return dat[tail - 1]; }

void printAll() {
  int cnt = head;
  cout << "printAll: [";
  while (cnt != tail) {
    cout << dat[cnt];
    cnt++;
    if (cnt != tail) {
      cout << ", ";
    }
  }
  cout << "]\n";
}

void test() {
  push(10);
  push(20);
  push(30);
  printAll();
  cout << "front: " << front() << '\n';  // 10
  cout << "back: " << back() << '\n';   // 30

  pop();
  pop();
  printAll();

  push(15);
  push(25);
  printAll();
  cout << "front: " << front() << '\n';  // 30
  cout << "back: " << back() << '\n';   // 25
}

int main(void) { test(); }