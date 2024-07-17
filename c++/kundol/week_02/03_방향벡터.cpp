#include<bits/stdc++.h>
using namespace std;

const int n = 3;
int a[n][n];
int visited[n][n];

int y3 = 0, x3 = 0;
int dy3[] = {-1, 0, 1, 0};
int dx3[] = {0, 1, 0, -1};

void go(int y, int x);
/*
입력값 :
1 0 1
1 0 1
0 1 1

출력값 :
0 : 0
1 : 0
*/
int main() {
    /**
     * Q1.
     * {0, 0}좌표에서 dy, dx를 만들어 4방향(위, 오른쪽, 아래, 왼쪽)을 탐색하며 좌표를 출력하시오.
     */
    int y = 0, x = 0;

    int dy[4] = {-1, 0, 1, 0};
    int dx[] = {0, 1, 0, -1};
    cout << "4방향 벡터\n";
    for(int i = 0; i < 4; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];
        cout << ny << " : " << nx << "\n";
    }

    /**
     * ​Q2.
     * {0, 0}좌표에서 dy, dx를 만들어 8방향(위, 오른쪽, 아래, 왼쪽 및 대각선방향포함)을 탐색하며 좌표를 출력하시오.
     */
    int y2 = 0, x2 = 0;
    int dy2[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    int dx2[] = {0, 1, 1, 1, 0, -1, -1, -1};
    cout << "8방향 벡터\n"; 
    for(int i = 0; i < 8; i++) {
        int ny2 = y2 + dy2[i];
        int nx2 = x2 + dx2[i];
        cout << ny2 << " :: " << nx2 << "\n";
    }
    cout << "\n";

    /**
     * Q. 3 * 3 맵을 입력받아야 함. 이 맵은 1과 0으로 이루어져있고 {0, 0}은 무조건 1임을 보장한다.
     * {0, 0}부터 4방향을 기준으로 한칸씩 탐색해나가며 방문한 정점은 다시 방문하지 않으며 방문하는 좌표를 출력하는 코드.
     * 0은 갈 수 없는 지역. 1은 갈 수 있는 지역을 구현하시오.
    */
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> a[i][j];
        }
    }
    go(0, 0);
    return 0;
}

void go(int y, int x) {
    visited[y][x] = 1;
    cout << y << " : " << x << "\n";
    for(int i = 0; i < 4; i++){
        int ny = y + dy3[i]; 
        int nx = x + dx3[i];
        // 맵을 넘어가면 안됨 (좌표를 담은 배열을 참조할 수 없음)
        if(ny < 0 || ny >= n || nx < 0 || nx >= n) {
            continue;
        }
        // 방문할 수 없음
        if(a[ny][nx] == 0) {
            continue;
        }
        // 방문한 곳 임
        if(visited[ny][nx]) {
            continue;
        }
        go(ny, nx);
    }
    return;
}