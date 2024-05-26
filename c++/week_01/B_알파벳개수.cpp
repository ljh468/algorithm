#include<bits/stdc++.h>
using namespace std;

/**
 * 알파벳 소문자로만 이루어진 단어 S가 주어진다.
 * 각 알파벳이 단어에 몇 개가 포함되어 있는지 구하는 프로그램을 작성
 * -> 단어에 포함되어 있는 a의 개수, b의 개수, …, z의 개수를 공백으로 구분해서 출력
 * 
 * 아이디어 :
 * a부터 z까지 맵을 추가하여, 갯수를 세면 될것
 * couting star는 맵 또는 배열을 이용하라.
 * 문자열 기반이면 맵
 * 숫자 기반이면 배열
 */

// 입력:
// baekjoon
// 출력:
// 1 1 0 0 1 0 0 0 0 1 1 0 0 1 2 0 0 0 0 0 0 0 0 0 0 0

string str; // 전역변수는 "" 빈문자열로 초기화됨
int arr[26]; // 전역변수는 0으로 초기화됨
int main() {
    // A : 65, a : 97
    // char a = 'a';
    // cout << (int)a << "\n"; // 97

    cin >> str;
    for(int i = 0; i < str.size(); i++) {
        arr[str[i] - 97]++;
    }
    for(int a : arr) {
        cout << a << " ";
    }
    return 0;
}