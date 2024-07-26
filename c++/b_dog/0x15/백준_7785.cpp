#include<iostream>
#include<unordered_set>
#include<string>
#include<vector>
#include<algorithm>
using namespace std;

int main () {
  ios::sync_with_stdio(0), cin.tie(0);
  unordered_set<string> enters;
  int n;
  cin >> n;
  
  while(n--) {
    string name;
    string e;
    cin >> name >> e;
    if(e == "enter") {
      enters.insert(name);
    } else {
      enters.erase(name);
    }
  }
  vector<string> result(enters.begin(), enters.end());
  sort(result.begin(), result.end(), greater<string>());
  
  for(const string& enter : result) {
    cout << enter << '\n';
  }
  
  return 0;
}