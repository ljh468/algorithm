#include<bits/stdc++.h>
using namespace std;

/**
 * 누가 선발인지 기억하기 쉽게 하기 위해 성의 첫 글자가 같은 선수 5명을 선발하려고 한다.
 * 만약, 성의 첫 글자가 같은 선수가 5명보다 적다면, 상근이는 내일 있을 친선 경기를 기권하려고 한다.
 * 다섯 명을 선발할 수 없는 경우에는 "PREDAJA" (따옴표 없이)를 출력해야 함
 * 선발할 수 있는 경우에는 가능한 성의 첫 글자를 사전순으로 공백없이 모두 출력해야 함
 * 
 * 아이디어 :
 * 입력받을 선수의 수 n의 범위는 (1 ≤ n ≤ 150), 첫글자가 같은 선수 5명을 찾아야함.
 * 조합으로 풀 수 있나? 조합으로 어떻게 풀지 모르겠음
 * 맵을 만들어서 카운팅해도 될꺼 같은데? 일단 맵으로 풀어보자.
 */


// 1. 사용할 변수 선언
int n;
map<char, int> firstNameCountMap;
string fullName;
vector<char> result;

int main() {
    // 2. 먼저 선수 몇명인지 입력받음
    cin >> n;

    // 3. 선수들의 성을 입력받아 첫 글자를 카운트
    for (int i = 0; i < n; ++i) {
        cin >> fullName;
        char firstLetter = fullName[0];
        firstNameCountMap[firstLetter]++;
    }

    /**
     * Q. 5명이면 정답을 실패함, 문제가 5명을 선발한다고 했는데, 5명 이상인가봄
     * if (entry.second == 5)
     */
    // 4. 5명 이상인 엔트리를 벡터에 저장
    for (pair<char, int> entry : firstNameCountMap) {
        if (entry.second >= 5) {
            result.push_back(entry.first);
        }
    }

    // 5. 사전순으로 오름차순 정렬
    sort(result.begin(), result.end());

    // 6-1. 결과가 없으면 "PREDAJA" 출력
    if (result.empty()) {
        cout << "PREDAJA" << "\n";
        return 0;
    }
    // 6-2. 첫글자가 5명 인 선수 첫글자만 결과로 출력
    for (char c : result) {
            cout << c;
    }
    cout << "\n";
    return 0;
}