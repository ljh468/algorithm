#include<bits/stdc++.h>
using namespace std;

/**
 * 문제 분석 : 
 * 뛰어난 수학적 직관력을 가지고 있던 백설공주는,
 * 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.
 * 
 * 아이디어 :
 * 7명의 난쟁이의 합이 100을 찾아야함, 순서는 상관없으니 조합으로 풀면 될 것 같은데?
 * 조합은 재귀를 이용해야하는데, 좀 헷갈리지만 그림그려가면서 시도해보자!
 * 그리고 조합식에서 합이 100이 되는 계산을 넣어야 할듯?
 */

// // 1. 사용할 변수 선언
// int dwarfs[9];
// vector<int> resultDwarfs;
// bool sevenDwarfsCombi(int start, vector<int>& resultDwarfs) {
// 	// 조합된 난쟁이의 수가 7명이면, 합을 계산하고 확인
//     if (resultDwarfs.size() == 7) {
//         int sum = 0;
//         for (int height : resultDwarfs) {
//             sum += height;
//         }
//         // 선택된 7명의 난쟁이들의 합이 100이면 true 반환
//         return sum == 100;
//     }

//     for (int i = start + 1; i < 9; i++) {
//         resultDwarfs.push_back(dwarfs[i]);
//         // 합이 100인 난쟁이를 찾으면 재귀 종료
//         if (sevenDwarfsCombi(i, resultDwarfs)) {
//             return true;
//         }
//         resultDwarfs.pop_back();
//     }

//     return false;
// }

// /**
//  * 일곱 난쟁이의 키의 합이 100이 됨을 기억
//  * 7명의 합이 100이고, 순서는 상관없으니 조합을 사용할 수 있음
//  */
// int main() {
//     // 2. 9개의 입력을 받고
//     for(int i = 0; i < 9; i++){
//         cin >> dwarfs[i]; 
//     }

//     // 3. 조합을 이용하여 7명의 난쟁이를 찾는다
//     sevenDwarfsCombi(-1, resultDwarfs);

//     // 4. 선택된 7명의 난쟁이들의 키를 오름차순으로 정렬한다
//     sort(resultDwarfs.begin(), resultDwarfs.end());
    
//     // 5. 결과 출력
//     for (int i = 0; i < 7; ++i) {
//         cout << resultDwarfs[i] << endl;
//     }
//     return 0;
// }

// // 1. 순열 풀이
// int main() {
//     int a[9];
//     ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
//     for(int i = 0; i < 9; i++) {
//         cin >> a[i];
//     }
//     sort(a, a + 9);
//     do {
//         for(int i : a) {
//             cout << i << " ";
//         }
//         cout << "\n";

//         int sum = 0;
//         for(int i = 0; i < 7; i++) {
//             sum += a[i];
//         }
//         if(sum == 100) {
//             break;
//         }

//     } while(next_permutation(a, a + 9));
//     for(int i = 0; i < 7; i++) {
//         cout << a[i] << "\n";
//     }
//     return 0;
// }

// 2. 조합 풀이 (비정상적인 2명을 뽑는 방법)
vector<int> v;
int sum = 0;
int input;
void combi() {
    for(int i = 0; i < 9; i++) {
        for(int j = i + 1; j < 9; j++) {
            if(sum - v[i] - v[j] == 100) {
                v.erase(v.begin() + i);
                v.erase(v.begin() + j);
                return;
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    for(int i = 0; i < 9; i++) {
        cin >> input;
        v.push_back(input);
        sum += input;
    }
    combi();
    sort(v.begin(), v.end());
    for(int i : v) {
        cout << i << " ";
    }
    return 0;
}

// // 3. 재귀함수 풀이
// int a[9];
// int n = 9, r = 7;
// void solve() {
//     int sum = 0;
//     for(int i = 0; i < r; i++) {
//         sum += a[i];
//     }
//     if(sum == 100) {
//         sort(a, a + 7); // 7번째 전까지 정렬
//         for(int i = 0; i < r; i++) {
//             cout << a[i] << " ";
//         }
//         exit(0);
//     }
// }

// void print() {
//     for(int i = 0; i < r; i++) {
//         cout << a[i] << " ";
//     }
//     cout << "\n";
// }

// void makePermutation(int n, int r, int depth) {
//     if(r == depth) {
//         solve();
//         return;
//     }
//     for(int i = depth; i < n; i++) {
//         swap(a[i], a[depth]);
//         makePermutation(n, r, depth + 1);
//         swap(a[i], a[depth]);
//     }
//     return;
// }

// int main() {
//     for(int i = 0; i < n; i++) {
//         cin >> a[i];
//     }
//     makePermutation(n, r, 0);
//     return 0;
// }