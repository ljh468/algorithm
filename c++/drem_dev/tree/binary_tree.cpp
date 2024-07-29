#include <iostream>
using namespace std;

// Node 구조체 정의
struct Node {
    int data;      // 노드에 저장된 데이터
    Node* left;    // 왼쪽 자식 노드
    Node* right;   // 오른쪽 자식 노드

    // 생성자
    Node(int value) : data(value), left(nullptr), right(nullptr) {}
};

// 이진 탐색 트리 클래스 정의
class BinaryTree {
public:
    Node* root; // 트리의 루트 노드

    BinaryTree() : root(nullptr) {} // 기본 생성자

    // 새로운 노드를 이진 탐색 트리에 삽입하는 함수
    Node* insert(Node* node, int data) {
        if (node == nullptr) {
            return new Node(data);  // 노드가 비어 있으면 새로운 노드 반환
        }

        if (data < node->data) {
            node->left = insert(node->left, data);  // 왼쪽 서브트리에 삽입
        } else {
            node->right = insert(node->right, data);  // 오른쪽 서브트리에 삽입
        }

        return node;
    }

    // 이진 탐색 트리에서 특정 값을 찾는 함수
    Node* search(Node* node, int data) {
        if (node == nullptr || node->data == data) {
            return node;  // 노드가 비어있거나 값을 찾으면 반환
        }

        if (data < node->data) {
            return search(node->left, data);  // 왼쪽 서브트리에서 검색
        } else {
            return search(node->right, data);  // 오른쪽 서브트리에서 검색
        }
    }

    // 전위 순회: 루트 -> 왼쪽 서브트리 -> 오른쪽 서브트리
    void printPreorder(Node* node) {
        if (node == nullptr) return;
        cout << node->data << " ";
        printPreorder(node->left);
        printPreorder(node->right);
    }

    // 중위 순회: 왼쪽 서브트리 -> 루트 -> 오른쪽 서브트리
    void printInorder(Node* node) {
        if (node == nullptr) return;
        printInorder(node->left);
        cout << node->data << " ";
        printInorder(node->right);
    }

    // 후위 순회: 왼쪽 서브트리 -> 오른쪽 서브트리 -> 루트
    void printPostorder(Node* node) {
        if (node == nullptr) return;
        printPostorder(node->left);
        printPostorder(node->right);
        cout << node->data << " ";
    }

    // 삽입 함수의 편리한 래퍼
    void insert(int data) {
        root = insert(root, data);
    }

    // 검색 함수의 편리한 래퍼
    Node* search(int data) {
        return search(root, data);
    }
};

int main() {
    // 이진 탐색 트리 객체 생성
    BinaryTree tree;

    // 노드 삽입
    tree.insert(3);
    tree.insert(4);
    tree.insert(2);
    tree.insert(8);
    tree.insert(9);

    // 트리 순회 및 출력
    cout << "이진 탐색 트리의 중위 순회 출력: ";
    tree.printInorder(tree.root);  // 중위 순회 호출
    cout << endl;
    // 출력: 2 3 4 8 9

    cout << "이진 탐색 트리의 전위 순회 출력: ";
    tree.printPreorder(tree.root);  // 전위 순회 호출
    cout << endl;
    // 출력: 3 2 4 8 9

    cout << "이진 탐색 트리의 후위 순회 출력: ";
    tree.printPostorder(tree.root);  // 후위 순회 호출
    cout << endl;
    // 출력: 2 9 8 4 3

    // 특정 값 검색
    int valueToSearch = 4;
    Node* result = tree.search(valueToSearch);
    if (result != nullptr) {
        cout << valueToSearch << "를 찾았습니다: " << result->data << endl;
    } else {
        cout << valueToSearch << "를 찾을 수 없습니다." << endl;
    }

    valueToSearch = 5;
    result = tree.search(valueToSearch);
    if (result != nullptr) {
        cout << valueToSearch << "를 찾았습니다: " << result->data << endl;
    } else {
        cout << valueToSearch << "를 찾을 수 없습니다." << endl;
    }

    return 0;
}
