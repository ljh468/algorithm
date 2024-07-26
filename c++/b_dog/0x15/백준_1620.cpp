#include<iostream>
#include<algorithm>
#include<unordered_map>
using namespace std;

unordered_map<string, int> s2i;
string i2s[100005];

int main() {
  ios::sync_with_stdio(0), cin.tie(0);
  int n, m;
  cin >> n >> m;
  
  // 폰켓몬 저장
  for(int i = 1; i <= n; i++) {
    cin >> i2s[i];
    s2i[i2s[i]] = i;
  }
  
  while(m--) {
    string input;
    cin >> input;
    if(isdigit(input[0])) {
      cout << i2s[stoi(input)] << '\n';
    } else {
      cout << s2i[input] << '\n';
    }
  }
  
  return 0;
}