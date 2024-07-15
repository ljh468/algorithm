#include <bits/stdc++.h>
using namespace std;

void printVector(const vector<int>& vec) {
  for (int val : vec) {
    cout << val << " ";
  }
  cout << "\n";
}

int main() {
  vector<int> v1(3, 5); // {5, 5, 5}
  cout << v1.size() << '\n'; // 3
  v1.push_back(7); // {5, 5, 5, 7}
  printVector(v1);
  
  vector<int> v2(2); // {0, 0}
  v2.insert(v2.begin() + 1, 3); // {0, 3, 0}
  printVector(v2);
  
  vector<int> v3 = {1, 2, 3, 4}; // {1, 2, 3, 4}
  v3.erase(v3.begin() + 2); // {1, 2, 4}
  printVector(v3);
  
  vector<int> v4; // {}
  v4 = v3; // deepcopy - {1, 2, 4}
  printVector(v4);
  
  v4.pop_back(); // {1, 2}
  printVector(v4);
  
  v4.clear(); // {}
  printVector(v4);
  return 0;
} 