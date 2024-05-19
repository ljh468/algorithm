#include<bits/stdc++.h>
using namespace std;

void go(vector<vector<int>> &v){
    v[0][0] = 100;
};
void go2(vector<vector<int>> &v){
    v[0][0] = 100;
};
void go3(vector<int> v[10]){
    v[0][0] = 100;
};
void go4(int a[][3]){
a   [2][2] = 100;
};
void go5(int a[3][3]){
    a[2][2] = 1000;
};

int main() {
    //////////////////////////////////////////////////////////////////////
    /**
     * 2차원 배열 수정하기
     */
    //////////////////////////////////////////////////////////////////////
    
    // 1. vector에 vector를 추가한 2차원배열 (초기화 되지 않음)
    cout << "첫번째 2차원배열" << "\n";
    vector<vector<int>> v;
    for(auto i : v) {
        for(auto j : i) {
            cout << j << " ";
        }
        cout << "\n";
    }
    cout << "\n";cout << "\n";

    // 2. vector 10개 배열에 vector 10배열을 0으로 초기화한 2차원배열 (0으로 초기화됨)
    cout << "두번째 2차원배열" << "\n";
    vector<vector<int>> v2(10, vector<int>(10, 0));
    for(auto i : v2) {
        for(auto j : i) {
            cout << j << " ";
        }
        cout << "\n";
    }
    cout << "\n";cout << "\n";

    // 3. vector 10개 배열을 할당 (공간만 할당, 빈공간으로 초기화됨)
    cout << "세번째 2차원배열" << "\n";
    vector<int> v3[10];
    for(auto i : v3) {
        for(auto j : i) {
            cout << j << " ";
        }
        cout << "\n";
    }
    cout << "\n";cout << "\n";

    vector<int> temp;
    temp.push_back(0);
    v.push_back(temp);
    v3[0].push_back(0);
    go(v); go2(v2); go3(v3);
    // 100 : 100 : 100
    cout << v[0][0] << " : " << v2[0][0] << " : " << v3[0][0] << '\n';

    // 2차원 배열 수정 (초기화 되어 있어야 수정이 가능)
    int a[3][3] = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
    go4(a); cout << a[2][2] << '\n';
    go5(a); cout << a[2][2] << '\n';

    return 0;
}