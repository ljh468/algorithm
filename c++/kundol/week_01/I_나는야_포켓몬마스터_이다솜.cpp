#include <bits/stdc++.h>
using namespace std;

/**
 * 네가 현재 가지고 있는 포켓몬 도감에서 포켓몬의 이름을 보면 포켓몬의 번호를 말하거나,
 * 포켓몬의 번호를 보면 포켓몬의 이름을 말하는 연습을 하도록 하여라.
 * 
 * 첫째 줄에는 도감에 수록되어 있는 포켓몬의 개수 N이랑 내가 맞춰야 하는 문제의 개수 M이 주어져.
 * N과 M은 1보다 크거나 같고, 100,000보다 작거나 같은 자연수
 * 포켓몬의 이름은 모두 영어로만 이루어져있고, 또, 음... 첫 글자만 대문자이고, 나머지 문자는 소문자
 * 아참! 일부 포켓몬은 마지막 문자만 대문자일 수도 있어
 * 포켓몬 이름의 최대 길이는 20, 최소 길이는 2
 * 
 */


int main () {
    ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

    int n, m;
    cin >> n >> m;

    map<int, string> map1;
    map<string, int> map2;
    string s;
    // 1. 맵 자료구조에 저장
    // key값을 int로 가지는 map1
    // key값을 string으로 가지는 map2
    for(int i = 0; i < n; i++) {
        cin >> s;
        map1[i + 1] = s;
        map2[s] = i + 1;
    }

    // 2. m만큼 입력을 받음 (숫자일수도? 문자일수도?)
    string input;
    for(int i = 0; i < m; i++) {
        cin >> input;
        int digit = atoi(input.c_str());
        // 문자형식이면 map2에서 찾음
        if(digit == 0) {
            cout << map2[input] << "\n";
        }
        // 숫자형식이면 map1에서 찾음
        else {
            cout << map1[digit] << "\n";
        }
    }
    return 0;
}