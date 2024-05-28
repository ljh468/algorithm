#include<bits/stdc++.h>
using namespace std;

/**
 * DFS (깊이 우선 탐색)
 * - 수도 코드 -
 * DFS(u, adj)
 *  u.visited = true
 *  for each v ∈ adj[u]
 *      if v.visited == false
 *          DFS(v, adj)
 */
const int n = 6; 
vector<int> adj[n];
int visited[n];

void dfs(int u){
    visited[u] = 1;
    cout << u << "\n";
    for(int v : adj[u]){
        if(visited[v] == 0){
            dfs(v);
        }
    }   
    cout << u << "로부터 시작된 함수가 종료되었습니다.\n";
    return; 
}

int main() {
    adj[1].push_back(2);
    adj[1].push_back(3); 
    adj[2].push_back(4);  
    adj[4].push_back(2);  
    adj[2].push_back(5);   
    dfs(1);

    /**
     * DFS 구현방법1 : 돌다리를 두들겨보다.
     * 
     * void dfs(int here){
     *  visited[1] = 1;
     *  for(int there : adj[here]){
     *      if(visited[there]) continue;
     *      dfs(there);
     *  }
     * }
     * 
     * DFS 구현방법2 : 못 먹어도 GO
     * - 일단 방문되어있던 안되어있던 무조건 dfs를 호출하고
     * - 해당 함수에서 만약에 방문되어있다면 return 해 함수를 종료시키는 방법
     * 
     * void dfs(int here){
     *  if(visited[here]) return;
     *  visited[here] = 1;
     *  for(int there : adj[here]){
     *      dfs(there);
     *  }
     */
    return 0;
}