#include <bits/stdc++.h>
using namespace std;

// 야매 연결리스트
const int MX = 1000005;
int dat[MX], pre[MX], nxt[MX];
int unused = 1;

// addr는 해당원소의 주소(번지)를 의미
void insert(int addr, int num) {
  // 새로운 원소 생성
  dat[unused] = num;
  // 새 원소의 pre값에 삽입할 위치의 이전 노드의 주소를 대입
  pre[unused] = addr;
  // 새 원소의 nxt값에 삽입할 위치의 다음 노드의 주소를 대입
  nxt[unused] = nxt[addr];
  // 다음 위치의 pre에 추가할 노드의 주소를 대입 (연결된 다음 노드가 있다면)
  if(nxt[addr] != -1) {
    pre[nxt[addr]] = unused;
  }
  // 이전 위치의 nxt를 새 원소의 주소로 대입
  nxt[addr] = unused;
  // unused 1 증가
  unused++;
};

void erase(int addr) {
  // 이전 위치의 nxt를 삭제할 위치의 nxt로 변경
  nxt[pre[addr]] = nxt[addr];
  // 다음 위치의 pre를 삭제할 위치의 pre로 변경 (연결된 다음 노드가 있다면)
  if(nxt[addr] != -1) {
    pre[nxt[addr]] = pre[addr]; 
  }
};

// 연결된 모든 리스트 출력
void traverse() {
  int current = nxt[0];
  while(current != -1) {
    cout << dat[current] << ' ';
    current = nxt[current];
  }
  cout << "\n\n";
};

void insert_test() {
  cout << "****** insert_test *****\n";
  insert(0, 10); // 10(address=1)
  traverse();
  insert(0, 30); // 30(address=2) 10
  traverse();
  insert(2, 40); // 30 40(address=3) 10
  traverse();
  insert(1, 20); // 30 40 10 20(address=4)
  traverse();
  insert(4, 70); // 30 40 10 20 70(address=5)
  traverse();
};

void erase_test() {
  cout << "****** erase_test *****\n";
  erase(1); // 30 40 20 70
  traverse();
  erase(2); // 40 20 70
  traverse();
  erase(4); // 40 70
  traverse();
  erase(5); // 40
  traverse();
};

int main() {
  fill(pre, pre + MX, -1);
  fill(nxt, nxt + MX, -1);
  insert_test();
  traverse();
  
  erase_test();
  traverse();
  return 0;
}