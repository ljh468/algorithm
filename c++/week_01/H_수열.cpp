#include <bits/stdc++.h>
using namespace std;

/**
 * 수열이 주어졌을 때, 연속적인 며칠 동안의 온도의 합이 가장 큰 값을 알아보고자 한다.
 * 첫째 줄에는 두 개의 정수 N과 K가 한 개의 공백을 사이에 두고 순서대로 주어진다.
 * - 첫 번째 정수 N은 온도를 측정한 전체 날짜의 수이다. N은 2 이상 100,000 이하이다.
 * - 두 번째 정수 K는 합을 구하기 위한 연속적인 날짜의 수이다.
 * 
 * 아이디어 : 
 * for문으로 풀면? O(n^2), 너무 오래걸림
 * 슬라이딩 윈도우라는 개념이 있음
 * m만큼의 네모칸을 만드는 방식인데 요걸로 풀어보자!!
 */

// int solution(int n, int k, vector<int> v) {
//     int maxTemper = 0, sum = 0;
//     // 4. m만큼 슬라이딩 윈도우를 만듬 (초기화)
//     for(int i = 0; i < k; i++) {
//         sum += v[i];
//     }
//     maxTemper = sum;

//     // 5. i는 index 2부터 n까지 순회
//     for(int i = k; i < n; i++) {
//         // 새로 추가되는 값은 더하고, 맨 앞에 있는 값은 뺀다
//         sum += (v[i] - v[i-k]);
//         // sum, answer값 중에 큰값을 저장
//         maxTemper = max(sum, maxTemper);
//     }
//     return maxTemper;
// }

// int main () {
//     // 1. 필요한 변수 선언
//     vector<int> temperArr;
//     int n, k;
//     int input;

//     cin >> n >> k;
//     // 2. n만큼 입력을 받아서 temperArr에 추가
//     for(int i = 0; i < n; i++) {
//         cin >> input;
//         temperArr.push_back(input);
//     }
    
//     // 3. 함수 호출
//     int answer = solution(n, k, temperArr);
//     cout << answer << "\n";
//     return 0;
// }

// 누적합 (prefix sum) 풀이
int n, k, temp;
int psum[100001];
int ret = -10000004;
int main() {
    cin >> n >> k;
    for(int i = 1; i <= n; i++) {
        cin >> temp;
        psum[i] = psum[i - 1] + temp;
    }
    for(int i = k; i <= n; i++) {
        ret = max(ret, psum[i] - psum[i - k]);
    }
    cout << ret << "\n";
    return 0;
}