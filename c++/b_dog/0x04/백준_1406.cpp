#include <iostream>
#include <list>
#include <string>
using namespace std;

// N이 100,000까지 들어올 수 있기때문에 vector로 풀수 없다. O(NlogN) - 100만
// 이내로 풀어야 함

void P(list<char>::iterator& cursor, list<char>& text_list) {
  char add;
  cin >> add;
  text_list.insert(cursor, add);
}

void L(list<char>::iterator& cursor, list<char>& text_list) {
  if (cursor != text_list.begin()) {
    cursor--;
  }
}

void D(list<char>::iterator& cursor, list<char>& text_list) {
  if (cursor != text_list.end()) {
    cursor++;
  }
}

void B(list<char>::iterator& cursor, list<char>& text_list) {
  if (cursor != text_list.begin()) {
    cursor--;
    cursor = text_list.erase(cursor);
  }
}

int main() {
  ios::sync_with_stdio(0), cin.tie(0);
  string init;
  cin >> init;

  list<char> text_list;
  for (char c : init) {
    text_list.push_back(c);  // a b c d
  }

  // 커서 초기화
  list<char>::iterator cursor = text_list.end();

  int m;
  cin >> m;
  while (m--) {
    char op;
    cin >> op;
    switch (op) {
      case 'P':
        P(cursor, text_list);
        break;
      case 'L':
        L(cursor, text_list);
        break;
      case 'D':
        D(cursor, text_list);
        break;
      case 'B':
        B(cursor, text_list);
        break;
    }
  }

  for (char c : text_list) {
    cout << c;
  }
  return 0;
}