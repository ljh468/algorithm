#include<bits/stdc++.h>
using namespace std;

/**
 * 후위순회 (postorder traversal)
 * - 후위순회는 자식들 노드를 방문하고 자신의 노드를 방문하는 것을 말함
 * 
 * 전위순회 (preorder traversal)
 * - 전위순회는 먼저 자신의 노드를 방문하고 그 다음 노드들을 방문하는 것을 말함 (DFS)
 * 
 * 중위순회 (inorder traversal)
 * - 중위순회(inorder traversal)는 왼쪽 노드를 먼저 방문
 * - 그다음의 자신의 노드를 방문하고 그 다음 오른쪽 노드를 방문하는 것을 말함
 * - "안에 넣다."
 * 
 * 레벨순회(level traversal)
 * - BFS를 생각하면 됨
 */
vector<int> adj[1004];
int visited[1004];

// 후위순회
void postOrder(int here) {
  	if(visited[here] == 0){
  		if(adj[here].size() == 1){
            postOrder(adj[here][0]);
        }
  		if(adj[here].size() == 2){
  			postOrder(adj[here][0]);
  			postOrder(adj[here][1]);
		}
  		visited[here] = 1;
  		cout << here << ' ';
	} 
};

// 전위순회
void preOrder(int here) {
  	if(visited[here] == 0){
  		visited[here] = 1;
  		cout << here << ' ';
  		if(adj[here].size() == 1){
            preOrder(adj[here][0]);
        }
  		if(adj[here].size() == 2){
  			preOrder(adj[here][0]);
  			preOrder(adj[here][1]);
		}
	}
};

// 중위순회
void inOrder(int here) {	
	if(visited[here] == 0){ 
  		if(adj[here].size() == 1){ 
  			inOrder(adj[here][0]); 
	  		visited[here] = 1; 
	  		cout << here << ' ';
		} else if(adj[here].size() == 2){
  			inOrder(adj[here][0]);
            visited[here] = 1;
	  		cout << here << ' ';
			inOrder(adj[here][1]);
		} else{
	  		visited[here] = 1;
	  		cout << here << ' ';
		}
	}
};

// 레벨 순회
void levelOrder(int here){
    queue<int> q;
    visited[here] = 1;
    q.push(here);
    while(q.size()) {
        int here = q.front();
        q.pop();
        cout << here << ' ';
        for(int there : adj[here]) {
            if(visited[there]){
                continue;
            }
            visited[there]= visited[here] + 1;
            q.push(there);
        }
    }
}

int main() {
    adj[1].push_back(2);
	adj[1].push_back(3);
	adj[2].push_back(4);
	adj[2].push_back(5);
	int root = 1;
    cout << "트리순회 : postOrder \n";
    postOrder(root); 
    memset(visited, 0, sizeof(visited));

    cout << "\n트리순회 : preOrder \n";
    preOrder(root);
    memset(visited, 0, sizeof(visited));

    cout << "\n트리순회 : inOrder \n";
    inOrder(root);
    memset(visited, 0, sizeof(visited));

    cout << "\n레벨순회 : levelOrder \n";
    levelOrder(root);
    memset(visited, 0, sizeof(visited));
    return 0;
}