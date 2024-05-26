#include<bits/stdc++.h>
using namespace std;

/**
 * 한번 입었던 옷들의 조합을 절대 다시 입지 않는다.
 * 예를 들어 오늘 해빈이가 안경, 코트, 상의, 신발을 입었다면,
 * 다음날은 바지를 추가로 입거나 안경대신 렌즈를 착용하거나 해야한다
 * - 각 테스트 케이스의 첫째 줄에는 해빈이가 가진 의상의 수 n(0 ≤ n ≤ 30)이 주어진다.
 * - 다음 n개에는 해빈이가 가진 의상의 이름과 의상의 종류가 공백으로 구분되어 주어진다.
 * - 같은 종류의 의상은 하나만 입을 수 있다.
 * 
 * - 해빈이가 알몸이 아닌 상태로 의상을 입을 수 있는 경우를 출력
 * 
 * 아이디어 : 
 * 입력, 출력으로 문제 해석이 안되는데?
 * 첫째줄 n은 2세트를 의미?
 * n, -> string 입력값 받음?
 * 경우의 수를 구하는 문제 (n * m0
 * - 경우의 수는 곱하기
 */

// T 테스트케이스마다 map이 초기화되어야 함, 전역변수 선언 주의
int main() {
    int t;
    cin >> t;
    while(t--) {
        map<string, int> clothes;
        int n;
        cin >> n; // 의상의 수 입력
        for(int i = 0; i < n; i++) {
            string name, type;
            cin >> name >> type; // 의상 이름과 종류 입력
            clothes[type]++; // 종류별 의상 수 증가
        }

        // 경우의 수는 곱하기
        int result = 1;
        for(pair<string, int> p : clothes) {
            result *= (p.second + 1); // 각 종류별로 의상 수 + 아무것도 입지 않은 수(1)
        }
        result -= 1; // 알몸인 경우 제외
        cout << result << "\n";
    }
    return 0;
}