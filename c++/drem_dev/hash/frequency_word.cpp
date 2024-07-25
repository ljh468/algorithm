#include<iostream>
#include<unordered_map>
#include<map>
#include<string>
using namespace std;

int main() {
  // 문자열 내 각 문자의 빈도를 저장할 unordered_map
  unordered_map<char, int> frequency;
  
  // 문자열을 순서대로 정렬하려면 map
  // map<char, int> frequency;
  
  string str = "hello world";
  // 각 문재의 빈도 저장
  for(char ch : str) {
    frequency[ch]++;
  }
  
  // 각 문자의 빈도 출력
  for(const pair<const char, int>& pair : frequency) {
    cout << pair.first << ": " << pair.second << '\n';
  }
  return 0;
}
