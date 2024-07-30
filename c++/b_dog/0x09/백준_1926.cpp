#include <iostream>
#include <queue>
using namespace std;

int paper[502][502];
bool vis[502][502];

int n, m;
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

/**
 * 1. 상하좌우로 연결된 그림의 크기 알아내기
 * 2. 도화지에 있는 모든 그림 찾아내기
 */
int main() {
  ios::sync_with_stdio(0), cin.tie(0);

  // 도화지 초기화
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      cin >> paper[i][j];
    }
  }

  int mx = 0; // 그림중 가장 넓은 값
  int num = 0; // 그림의 수
  
  // 페이퍼 순회
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      // 해당 칸이 색칠이 안된 부분(0)이거나 이미 (i, j)를 방문했을 경우 넘어감 (시작점 X)
      if(paper[i][j] == 0 || vis[i][j]) continue;
      
      // 그림의 수 증가
      num++;
      
      // (i,j)는 새로운 그림에 속해있는 시작점
      queue<pair<int, int>> Q;
      vis[i][j] = 1;
      Q.push({i, j}); // 시작점 방문했다고 기록
      
      int area = 0; // 그림의 넓이
      while (!Q.empty()) {
        area++; // 큐에 있는 원소를 하나 뺄 때 마다 넓이가 1 증가
        pair<int, int> cur = Q.front();
        Q.pop();
        
        // 상하좌우를 살펴봄
        for (int dir = 0; dir < 4; dir++) {
          int nx = dx[dir] + cur.first;
          int ny = dy[dir] + cur.second;
          
          if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
            continue;
          }
          
          if(vis[nx][ny] || paper[nx][ny] != 1) {
            continue;
          }
          
          // 방문을 기록하고, 큐에 저장
          vis[nx][ny] = 1;
          Q.push({nx, ny});
        }
      }
      
      // 현재 순회하는 그림의 넓이가 이전 mx(최대 넓이)보다 넓으면 mx 변경
      mx = max(mx, area);
    }
  }
  
  cout << num << '\n' << mx;
  return 0;
}