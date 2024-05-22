#include<bits/stdc++.h>
using namespace std;

//////////////////////////////////////////////////////////////////////
/**
 * permutation (순열)
 * - permutation이란 순서가 정해진 임의의 집합을 다른 순서로 섞는 연산을 말함
 * - 1, 2, 3 이렇게 있을 때 1, 3, 2 이런식으로 다른 순서로 섞는 연산이 순열
 * - n개의 집합 중 n개를 고르는 순열의 개수는 n!이라는 특징을 가짐
 * - ex: 자연수(1, 2, 3) -> 123,132, 213, 231, 312, 321 이렇게 6개
 * 
 * - 순열 공식 : nPr = n! / (n-r)!
 * - 만약 3개중 3개를 뽑는다면? 3! / (3 - 3)!
 * - 만약 3개중 1개를 뽑는다면? 3! / (3 - 1)!
 * 
 * - 예를 들어 서로다른 색깔을 가진 3개의 공에 대해 3개를 "순서와 관계있이" 뽑는 경우의 수는 어떻게 될까?
 * - 정답은 6개 !!
 */
//////////////////////////////////////////////////////////////////////
void printV(vector<int> &v) {
    for(int i = 0; i < v.size(); i++) {
        cout << v[i] << " ";
    }
    cout << "\n";
};

void print(int *a, int r) {
    for(int i = 0; i < r; i++) {
        cout << a[i] << " ";
    }
    cout << "\n";
};

void makePermutation(int *a, int n, int r, int depth) {
    if(r == depth) {
        print(a, r);
        return;
    }
    for(int i = depth; i < n; i++){
        cout << i << " : " << depth << "를 바꾼다!\n";
        swap(a[i], a[depth]);
        makePermutation(a, n, r, depth + 1);
        cout << i << " : " << depth << "를 다시 바꾼다!\n";
        swap(a[i], a[depth]);
    }
}


int main() {
    //////////////////////////////////////////////////////////////////////
    /**
     * permutation 메서드로 만드는 순열
     * - naxt_permutation(first, end) -> 오름차순 정렬이 되어 있어야함
     * next_permutation()은 새로운 순열이 이전 순열보다 사전순으로 큰 경우 true를 반환
     * 그러다가 마지막 순열에 도달하고 범위가 첫 번째 순열로 재설정된 경우 false를 반환하는 함수
     * 
     * - prev_permutation(first, end) -> 내림차순 정렬이 되어 있어야함
     * 
     * 예시 코드 :
     * do {
     *  printV(v);
     * } while(next_permutation(v.begin(), v.end()));
     * 
     * 
     * do {
     *  printV(v);
     * } while(prev_permutation(v.begin(), v.end()));
     */
    //////////////////////////////////////////////////////////////////////
    // int a[3] = {1, 2, 3};
    // vector<int> v;

    // // 1, 2, 3 오름차순 정렬하여 순열을 뽑음
    // for(int i = 0; i < 3; i++) {
    //     v.push_back(a[i]);
    // }
    // do {
    //     printV(v);
    // } while(next_permutation(v.begin(), v.end()));

    // cout << "=============================" << "\n"; v.clear();

    // // 3, 2, 1 내림차순 정렬하여 순열을 뽑음
    // for(int i = 2; i >= 0; i--) {
    //     v.push_back(a[i]);
    // }
    // do {
    //     printV(v);
    // } while(prev_permutation(v.begin(), v.end()));

    // int b[] = {1, 2, 3};
    // bool flag = 1;
    // do {
    //     flag = next_permutation(b, b + 3);
    //     cout << "flag " << flag << "\n";
    //     for(int i : b) {
    //         cout << i << " ";
    //     }
    //     cout << "\n";
    // } while(flag);

    //////////////////////////////////////////////////////////////////////
    /**
     * 재귀함수로 만드는 순열
     * - swap으로 자리를 바꿔주고 다시 원복하는 트리 형태를 이용 (도식화 해보자)
     */
    //////////////////////////////////////////////////////////////////////
    int a[3] = {1, 2, 3};
    int n = 3; int r = 3;
    makePermutation(a, n, r, 0);
    return 0;
}


