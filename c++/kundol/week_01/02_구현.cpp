#include<bits/stdc++.h>
using namespace std;

/**
 * string dopa = "umzunsik";
 * Q1. 앞에서부터 3개의 문자열을 출력하라.
 * Q2. 해당 문자열을 거꾸로 해서 출력하라.
 * Q3. 해당 문자열 끝에 "umzunsik"이란 문자열을 추가하라.
 */
int main() {
    string dopa = "abcde";
    cout << dopa << "\n";

    cout << dopa.substr(0, 3) << "\n";

    reverse(dopa.begin(), dopa.end());
    cout << dopa << "\n";

    dopa += " umzunsik";
    cout << dopa << "\n";
    return 0;
}