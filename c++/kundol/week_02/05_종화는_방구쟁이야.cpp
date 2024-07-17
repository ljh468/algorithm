#include<bits/stdc++.h>
using namespace std;

/**
 * 종화는 방구를 낄 때 "이러다... 다 죽어!!" 를 외치며 방구를 뀌는데 이렇게 방귀를 뀌었을 때
 * 방귀는 상하좌우 네방향으로 뻗어나가며 종화와 연결된 "육지"는 모두 다 오염된다. "바다"로는 방구가 갈 수 없다.
 * 맵이 주어졌을 때 종화가 "이러다... 다 죽어!!"를 "최소한" 몇 번외쳐야 모든 육지를 오염시킬 수 있는지 말해보자.
 * 1은 육지며 0은 바다, 이러다... 다 죽어!!"를 몇 번 외쳐야하는지 출력
 * 범위 :
 * 1 <= N <= 100
 * 1 <= M <= 100
 * 
 * 해설 : 연결된 컴포넌트(connected component)를 찾는 문제
 */

/*
입력값 :
5 5
1 0 1 0 1
1 1 0 0 1
0 0 0 1 1
0 0 0 1 1
0 1 0 0 0
*/

/*
출력값 :
4
*/

int n, m, ret, ny, nx;
int a[104][104], visited[104][104];
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};

void dfs(int y, int x){
    visited[y][x] = 1;
    cout << y << " : " << x << "\n";
    for(int i = 0; i < 4; i++){
        ny = y + dy[i];
        nx = x + dx[i];
        if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
        if(a[ny][nx] == 1 && !visited[ny][nx]){
            dfs(ny, nx);
        }
    }
    return;
}

int main() {
    // 입력을 받음
    cin >> n >> m;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            cin >> a[i][j];
        }
    }

	for(int i = 0; i < n; i++){
    	for(int j = 0; j < m; j++){
    		if(a[i][j] == 1 && !visited[i][j]){
                cout << i << " : " << j << " dfs가 시작됩니다.\n";
                ret++;
                dfs(i, j);
			} 
		}
	}
	cout << ret << '\n';
    return 0;
}