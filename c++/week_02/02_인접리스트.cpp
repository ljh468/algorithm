#include<bits/stdc++.h>
using namespace std;

const int V = 4;
vector<int> adj[V];

const int ten = 10;
vector<int> adjc[ten];  
int visited[ten];

void go(int idx);
int main() {
    // 0 -> 1, 2, 3
    adj[0].push_back(1);
    adj[0].push_back(2);
    adj[0].push_back(3);

    // 1 -> 0, 2
    adj[1].push_back(0);
    adj[1].push_back(2);

    // 2 -> 0, 1
    adj[2].push_back(0);
    adj[2].push_back(1);

    // 3 -> 0
    adj[3].push_back(0);


    for(int i = 0; i < 4; i++) {
        cout << i << " :: ";
        for(int there : adj[i]) {
            cout << there << " ";
        }
        cout << "\n";
    }
    // 이렇게도 할 수 있다.
    for(int i = 0; i < 4; i++){
        cout << i << " :: ";
        for(int j = 0; j < adj[i].size(); j++){
            cout << adj[i][j] << " ";
        } 
        cout << '\n'; 
    }

    /**
     * 1번.
     * 정점은 0번 부터 9번까지 10개의 노드가 있다.
     * 1 - 2 /  1 - 3 / 3 - 4 라는 경로가 있다. (1번과 2번, 1번과 3번, 3번과 4번은 연결되어있다.) 
     * 이를 인접리스트로 표현한다면?
     */
    adjc[1].push_back(2);
    adjc[2].push_back(1);

    adjc[1].push_back(3);
    adjc[3].push_back(1);

    adjc[3].push_back(4);
    adjc[4].push_back(3);


    /**
     * 2번.
     * 0번부터 방문안한 노드를 찾고 해당 노드부터 방문
     * 연결된 노드를 이어서 방문해서 출력하는 재귀함수를 만들고 싶다면 어떻게 해야할까?
     * 또한, 정점을 방문하고 다시 방문하지 않게 만드려면 어떻게 해야할까? 
     */
    for(int i = 0; i < V; i++){
        // 간선이 존재하고 and 방문하지 않았다면?
        if(adjc[i].size() && visited[i] == 0) {
            cout << "go(" << i << ")\n";
            go(i);
        }
    }
    return 0;
}

void go(int idx) {
    cout << idx << "\n";
    visited[idx] = 1;
    for(int there : adjc[idx]) {
        if(visited[there]){
            continue;
        }
        go(there);
    }
    return;
}