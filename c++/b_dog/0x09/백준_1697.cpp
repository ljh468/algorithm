#include<iostream>
#include<queue>
using namespace std;

int n, k;
int dist[100004];

int main(void) {
  ios::sync_with_stdio(0), cin.tie(0);
  cin >> n >> k;
  // -1로 배열을 초기화
  fill(dist, dist + 100004, -1);
  
  queue<int> Q;
  Q.push(n);
  dist[n] = 0; // 수빈이의 현재위치 0으로 초기화
  
  // 동생의 위치를 찾을때까지 반복
  while(dist[k] == -1) {
    int cur = Q.front(); Q.pop();
    for(int nxt : {cur - 1, cur + 1, 2 * cur}) {
      // 범위 밖은 무시
      if(nxt < 0 || nxt > 100004) continue;
      // 이미 방문했다면 무시
      if(dist[nxt] != -1) continue;
      // 이동 시간 계산
      dist[nxt] = dist[cur] + 1;
      Q.push(nxt);
    }
  }
  
  cout << dist[k];
}