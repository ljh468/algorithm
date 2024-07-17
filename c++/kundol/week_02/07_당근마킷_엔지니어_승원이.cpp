#include<bits/stdc++.h>
using namespace std;

/**
 * 승원이는 당근을 좋아해서 당근마킷에 엔지니어로 취업했다.
 * 당근을 매우좋아하기 때문에 차도 당근차를 샀다.
 * 이 당근차는 한칸 움직일 때마다 당근을 내뿜으면서 간다.
 * 즉, "한칸" 움직일 때 "당근한개"가 소모된다는 것이다.
 * 승원이는 오늘도 아침 9시에 일어나 당근마킷으로 출근하고자 한다.
 * 승원이는 최단거리로 당근마킷으로 향한다고 할 때 당근몇개를 소모해야 당근마킷에 갈 수 있는지 알아보자.
 * 이 때 승원이는 육지로만 갈 수 있으며 바다로는 못간다. 맵의 1은 육지며 0은 바다를 가리킨다.
 * 승원이는 상하좌우로만 갈 수 있다. 
 * 
 * 맵의 세로길이 N과 가로길이 M 이 주어지고 이어서 N * M의 맵이 주어진다.
 * 그 다음 줄에 승원이의 위치(y, x)와 당근마킷의 위치(y, x)가 주어진다.
 * 이 때 승원이의 시작위치(y, x)에서 "당근한개"가 이미 소모된 상태로 본다.
 * 
 * 범위 :
 * 1 <= N <= 100
 * 1 <= M <= 100
 * 
 * 해설 : 가중치가 같은 그래프 내의 최단거리알고리즘" 문제
 * 한칸씩 이동할 때마다 당근 한개를 쓰기 때문에  가중치가 같은 그래프이며
 * BFS를 통해 최단거리 배열을 만들어서 풀수 있음
 */

/*
입력값 :
5 5
0 0
4 4
1 0 1 0 1
1 1 1 0 1
0 0 1 1 1
0 0 1 1 1
0 0 1 1 1
*/

/*
출력값 :
9
*/

const int max_n = 104;
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
int n, m, y, x, sy, sx, ey, ex;
int a[max_n][max_n], visited[max_n][max_n];

int main(){ 
    // 입력값을 받음
    cin >> n >> m;
    cin >> sy >> sx;
    cin >> ey >> ex;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
        	cin >> a[i][j];
        }
    }

    queue<pair<int, int>> q;
    visited[sy][sx] = 1;
    q.push({sy, sx});
    while(q.size()){
        tie(y, x) = q.front();
        q.pop(); 
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i]; 
            int nx = x + dx[i]; 
            if(ny < 0 || ny >= n || nx < 0 || nx >= m || a[ny][nx] == 0) {
                continue;
            }
            if(visited[ny][nx]) {
                continue;
            }
            visited[ny][nx] = visited[y][x] + 1; 
            q.push({ny, nx}); 
        } 
    }
    cout << visited[ey][ex] << "\n"; 
    // 최단거리 디버깅 
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
        	cout << visited[i][j] << ' '; 
        }
        cout << '\n';
    } 
    return 0;
}