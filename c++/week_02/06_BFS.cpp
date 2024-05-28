#include<bits/stdc++.h>
using namespace std;

/**
 * BFS (너비 우선 탐색)
 * 
 * - 방문처리만 하는 방법
 * - 수도 코드 -
 * BFS(G, u)
 *  u.visited = true
 *  q.push(u)
 *  while(q.size())
 *      u = q.front()
 *      q.pop()
 *      for each v ∈ G.Adj[u]
 *          if v.visited == false
 *              v.visited = true
 *              q.push()
 * 
 * - "최단거리 배열"을 방문하면서 만들어주는 방법
 * - 수도 코드 -
 * BFS(G, u)
 *  u.visited = 1
 *  q.push(u);
 *  while(q.size())
 *      u = q.front()
 *      q.pop()
 *      for each v ∈ G.Adj[u]
 *          if v.visited == false
 *              v.visited = u.visited + 1
 *              q.push()
 * 
 * ** 참고로 가중치가 다른 그래프 내에서 최단거리 알고리즘은 다익스트라, 벨만포드 등을 써야함.
 */

vector<int> adj[100];
int visited[100]; 
int nodeList[] = {10, 12, 14, 16, 18, 20, 22, 24};

void bfs(int here) {
    queue<int> q;
    visited[here] = 1;
    q.push(here);
    while(q.size()) {
        int here = q.front();
        q.pop();
        for(int there : adj[here]) {
            if(visited[there]) {
                continue;
            }
            // 이전 노드에서 + 1
            visited[there] = visited[here] + 1;
            q.push(there);
        }
    }
}

int main() {
    adj[10].push_back(12);
    adj[10].push_back(14);
    adj[10].push_back(16);
    
    adj[12].push_back(18);
    adj[12].push_back(20);


    adj[20].push_back(22);
    adj[20].push_back(24);
    bfs(10);
    for(int i : nodeList){
        cout << i << " : " << visited[i] << '\n';
    }
    cout << "10번으로부터 24번까지 최단거리는 : " << visited[24] - 1 << '\n';
    return 0;
}