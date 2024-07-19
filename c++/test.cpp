#include <iostream>
#include <stdexcept>
#include <vector>
using namespace std;

template <typename T>
class Stack {
 private:
  // 스택은 동적배열(vector)로 구현 할 수 있음
  vector<T> elements;

 public:
  void push(const T& element) { elements.push_back(element); }

  void pop() {
    if (elements.empty()) {
      throw out_of_range("Stack<>::pop(): empty stack");
    }
    elements.pop_back();
  }

  T top() const {
    if (elements.empty()) {
      throw out_of_range("Stack<>::top(): empty stack");
    }
    return elements.back();
  }

  bool isEmpty() const { return elements.empty(); }
};

int main() {
  Stack<int> stack;
  stack.push(10);
  stack.push(20);
  stack.push(30);

  while (!stack.isEmpty()) {
    cout << stack.top() << " ";
    stack.pop();
  }

  return 0;
}