#include<iostream>
#include<string>
#include<queue>
using namespace std;

int main() {
  queue<int> que;
  que.push(10); // 10
  que.push(20); // 20
  que.push(30); // 30
  
  // 10 20 30
  cout << que.size() << '\n'; // 3
  
  if(que.empty()) {
    cout << "queue is empty\n";
  } else {
    cout << "queue is not empty\n";
  }
  
  que.pop();
  cout << "front: " << que.front() << '\n'; // 20
  cout << "back: " << que.back() << '\n'; // 30
  // 20 30
  
  que.push(40);
  // 20 30 40
  
  que.pop();
  // 30 40
  cout << "front: " << que.front() << '\n'; // 30
  cout << "back: " << que.back() << '\n'; // 40
  
  return 0;
}