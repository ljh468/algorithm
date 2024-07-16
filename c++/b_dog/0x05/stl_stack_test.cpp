#include<iostream>
#include<stack>
using namespace std;

int main() {
  stack<int> stack;
  stack.push(10);
  stack.push(20);
  stack.push(30);
  // 10, 20, 30
  
  cout << stack.size() << '\n'; // 3
  
  if(stack.empty()) {
    cout << "stack is empty\n";
  } else {
    cout << "stack is not empty\n";
  }
  
  stack.pop();
  // 남아 있는 스택 : 10, 20
  cout << stack.top() << '\n'; // 20
  
  stack.pop();
  // 남아 있는 스택 : 10
  cout << stack.top() << '\n'; // 10
  
  stack.pop();
  // empty
  if(stack.empty()) {
    cout << "stack is empty\n";
  }
  
  cout << stack.top() << '\n';
  // runtime error 발생 (스택 언더플로우)
  // 그뒤로 stack을 사용할 수 없음 (고장남)
  return 0;
}