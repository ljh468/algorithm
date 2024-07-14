#include <bits/stdc++.h>
using namespace std;

int freq[26];
int main() {
  ios::sync_with_stdio(0), cin.tie(0);
  string s;
  cin >> s;
  
  // 무난한 방법
  for(char a = 'a'; a <= 'z'; a++) {
    int cnt = 0;
    for(char c : s) {
      if(a == c) {
        cnt++;
      }
    }
    cout << cnt << ' ';
  }
  
  // 배열에 저장하는 방법
  for(char c : s) {
    // 대문자A 아스키 : 65
    // 소문자 a 아스키코드: 97
    // 입력된 문자는 소문자이므로 a를 빼주면 해당 문자를 표시하는 배열에 접근할 수 있음
    // ex: c = 'a'일때 'a'(97) - 'a'(97) = 0
    // freq[0]++;
    freq[c - 'a']++;
  }
  for(int i = 0; i < 26; i++) { // 인덱스 0 ~ 25까지
    cout << freq[i] << ' ';
  }
  cout << "\n";
  return 0;
}