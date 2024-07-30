#include <iostream>
using namespace std;

struct Node {
    char left;
    char right;
};

// 전위 순회: 루트 -> 왼쪽 -> 오른쪽
void preorder(Node tree[], char node) {
    if (node == '.') return;
    cout << node;  // 루트 노드 출력
    preorder(tree, tree[node - 'A'].left);  // 왼쪽 서브트리 탐색
    preorder(tree, tree[node - 'A'].right); // 오른쪽 서브트리 탐색
}

// 중위 순회: 왼쪽 -> 루트 -> 오른쪽
void inorder(Node tree[], char node) {
    if (node == '.') return;
    inorder(tree, tree[node - 'A'].left);   // 왼쪽 서브트리 탐색
    cout << node;  // 루트 노드 출력
    inorder(tree, tree[node - 'A'].right);  // 오른쪽 서브트리 탐색
}

// 후위 순회: 왼쪽 -> 오른쪽 -> 루트
void postorder(Node tree[], char node) {
    if (node == '.') return;
    postorder(tree, tree[node - 'A'].left); // 왼쪽 서브트리 탐색
    postorder(tree, tree[node - 'A'].right);// 오른쪽 서브트리 탐색
    cout << node;  // 루트 노드 출력
}

int main() {
    int N;
    cin >> N;

    Node tree[26];  // 최대 26개의 노드 (A-Z)

    for (int i = 0; i < N; ++i) {
        char parent, left, right;
        cin >> parent >> left >> right;
        tree[parent - 'A'] = {left, right};
    }

    // 전위 순회 결과 출력
    preorder(tree, 'A');
    cout << "\n";

    // 중위 순회 결과 출력
    inorder(tree, 'A');
    cout << "\n";

    // 후위 순회 결과 출력
    postorder(tree, 'A');
    cout << "\n";

    return 0;
}