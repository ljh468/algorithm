#include<bits/stdc++.h>
using namespace std;

struct Point{
    int y, x;
    Point(int y, int x) : y(y), x(x){}
    Point(){y = -1; x = -1; }
    bool operator < (const Point & a) const{
        return x > a.x;
    }
};

struct Point2{
    int y, x;
    Point2(int y, int x) : y(y), x(x){}
    Point2(){y = -1; x = -1; }
    bool operator < (const Point2 & a) const{
        return x < a.x;
    }
};

struct Point3{
    int y, x;
};

struct cmp{
    bool operator()(Point3 a, Point3 b){
        return a.x < b.x;
    }
};

// call by value (값에 의한 호출)
int add(int a, int b){
    a += 10;
    cout << a << '\n';
    return a + b;
};

// call by value (값에 의한 호출)
vector<int> go(vector<int> v){
    v[0] = 100;
    return v;
};

// call by reference (참조에 의한 호출)
int add2(int &a, int &b){
    a += 10;
    cout << a << '\n';
    return a + b;
};

// call by reference (참조에 의한 호출)
vector<int> go2(vector<int> &v){
    v[0] = 100;
    return v;
};

int main(){
    // //////////////////////////////////////////////////////////////////////
    // /**
    //  * priority queue (우선순위 큐)
    //  * - 우선 순위 큐(priority queue)는 각 요소에 어떠한 우선순위가 추가로 부여되어 있는 컨테이너
    //  * - 우선순위 큐에서 우선순위가 높은 요소는 우선순위가 낮은 요소보다 먼저 제공
    //  * 
    //  * 이진트리로 구현된 최소힙 또는 최대힙이 있으며 삽입, 삭제, 탐색, 수정에 대해 O(logN)의 시간복잡도를 가짐
    //  * Min Heap -> 루트 노드에 최소값이 있으면 항상 작은 값만 반환함 (오름차순으로 반환)
    //  * Max Heap -> 루트 노드에 최대값이 있으면 항상 큰 값만 반환함 (내림차순으로 반환)
    //  * 
    //  * int형 우선순위큐
    //  * - greater<타입> 을 써서 오름차순, less<타입>을 써서 내림차순
    //  * - 기본값은 내림차순이라 단순하게 priority_queue<타입>을 쓰면 해당 타입에 대한 내림차순으로 설정됨
    //  */
    // //////////////////////////////////////////////////////////////////////
    
    // /**
    //  * ########################## 주의 ##########################
    //  * sort는 less<int> 가 오름차순임, 기본값도 오름차순
    //  * priority_queue는 less<int> 내림차순이고, 기본값도 내림차순임
    //  * #########################################################
    //  */
    // priority_queue<int, vector<int>, greater<int>> pq; // 오름차순
    // priority_queue<int> pq2; // 내림차순
    // priority_queue<int, vector<int>, less<int>> pq3; // 내림차순
    // for(int i = 5; i >= 1; i--){
    //     pq.push(i);
    //     pq2.push(i);
    //     pq3.push(i);
    // }
    // while(pq.size()) {
    //     cout << pq.top() << " : " << pq2.top() << " : " << pq3.top() << "\n";
    //     pq.pop(); pq2.pop(); pq3.pop();
    // }

    // //////////////////////////////////////////////////////////////////////
    // /**
    //  * 구조체를 담은 우선순위큐
    //  * 
    //  * - operator x > a.x; 이면 내림차순으로 정렬될 것처럼 보임 (큰게 왼쪽으로 가니까)
    //  * - 그러나, 오름차순으로 정렬되는 것을 볼 수 있음
    //  * struct Point {
    //  *  int y, x;
    //  *  Point(int y, int x) : y(y), x(x) {}
    //  *  Point() {y = -1; x = -1;}
    //  *  bool operator < (const Point &a) const {
    //  *      return x > a.x;
    //  *  }
    //  * }
    //  * 
    //  * 우선순위큐에 커스텀 정렬을 넣을 때 반대로 넣어야 하는 특징이 있음
    //  * struct Point2 {
    //  *  int y, x;
    //  *  Point2(int y, int x) : y(y), x(x) {}
    //  *  Point2() {y = -1; x = -1;}
    //  *  bool operator < (const Point2 &a) const {
    //  *      return x < a.x;
    //  *  }
    //  * }
    //  * 
    //  */
    // //////////////////////////////////////////////////////////////////////
    // priority_queue<Point> pq;
    // pq.push({1, 1});
    // pq.push({2, 2});
    // pq.push({3, 3});
    // pq.push({4, 4});
    // pq.push({5, 5});
    // pq.push({6, 6});
    // cout << pq.top().x << "\n"; // 1 (operator : return x > a.x; -> 오름차순 정렬됨)

    // priority_queue<Point2> pq2;
    // pq2.push({1, 1});
    // pq2.push({2, 2});
    // pq2.push({3, 3});
    // pq2.push({4, 4});
    // pq2.push({5, 5});
    // pq2.push({6, 6});
    // cout << pq2.top().x << "\n"; // 6 (operator : return x < a.x; -> 내림차순 정렬됨)

    // priority_queue<Point3, vector<Point3>, cmp> pq3;
    // pq3.push({1, 1});
    // pq3.push({2, 2});
    // pq3.push({3, 3});
    // pq3.push({4, 4});
    // pq3.push({5, 5});
    // pq3.push({6, 6});
    // cout << pq3.top().x << "\n"; // 6 (operator : return x < a.x; -> 내림차순 정렬됨)

    // //////////////////////////////////////////////////////////////////////
    // /**
    //  * operator() - 함수 호출 연산자
    //  * 객체를 함수처럼 호출할 수 있게 해주는 연산자 오버로딩의 예임
    //  * 이 연산자를 클래스나 구조체 내에 오버로딩함으로써,
    //  * 해당 타입의 객체에 대한 "호출 가능한 객체(callable object)" 또는 "함수 객체(function object)"를 만들 수 있음
    //  * 
    //  * class ClassName {
    //  *  public:
    //  *      반환형 operator()(매개변수 목록) {
    //  *          // 구현
    //  *      }
    //  * }
    //  * - 반환형은 함수 호출 시 반환되는 데이터 타입
    //  * - 매개변수목록은 함수가 받아들일 매개변수들의 목록
    //  * 
    //  * 1. 함수 객체
    //  * - Adder 클래스는 operator()를 오버로딩하여 두 정수를 받아 그합을 반환
    //  * - adder 객체는 마치 함수처럼 호출될 수 있으면 adder(3, 4)는 7을 반환함
    //  * 
    //  * class Adder {
    //  *  public:
    //  *  int operator()(int a, int b) {
    //  *      return a + b;
    //  *  }
    //  * };
    //  * 
    //  * int main() {
    //  *  Adder adder;
    //  *  cout << adder(3, 4); // 7을 출력
    //  *  return 0;
    //  * }
    //  * 
    //  * 2. 우선순위큐의 비교연산자
    //  * - cmp는 int 타입의 두 요소를 비교하여 첫 번째 요소가 두 번째 요소보다 큰 경우 true를 반환
    //  * - cmp함수 객체는 최소 힙(min heap) 구조의 우선 순위 큐를 만드는 데 사용
    //  * 
    //  * struct cmp {
    //  *  bool operator()(const int& a, const int& b) {
    //  *      return a > b; // 최소 힙 구조 (오름차순)
    //  *  }
    //  * };
    //  * 
    //  * priority_queue<int, vector<int>, cmp> pq;
    //  * 
    //  */
    // //////////////////////////////////////////////////////////////////////

    // //////////////////////////////////////////////////////////////////////
    // /**
    //  * 값에 의한 호출과 참조에 의함 호출
    //  * 
    //  * call by value (값에 의한 호출)
    //  * - 매개변수로 전달되는 변수를 모두 함수 내부에서 복사해서 함수를 실행하는 방법
    //  * - 함수 내부에서 전체 복사가 일어나고, 실제 변수와는 다른 주소에 할당되기 때문에,
    //  * - 매개변수로 전달된 복사본이 변경되더라도 원본값은 변경되지 않음
    //  * 예시 코드 :
    //  * int add(int a, int b) {
    //  *  a += 10;
    //  *  cout << a << "\n";
    //  *  return a + b;
    //  * }
    //  * 
    //  * call by value (값에 의한 호출)
    //  * - 매개변수로 전달되는 변수를 모두 함수 내부에서 복사해서 함수를 실행하는 방법
    //  * - 함수 내부에서 전체 복사가 일어나고, 실제 변수와는 다른 주소에 할당되기 때문에,
    //  * - 매개변수로 전달된 복사본이 변경되더라도 원본값은 변경되지 않음
    //  * 예시 코드 :
    //  * int add(int a, int b) {
    //  *  a += 10;
    //  *  cout << a << "\n";
    //  *  return a + b;
    //  * }
    //  * 
    //  * vector<int> go(vector<int> v){
    //  *  v[0] = 100;
    //  *  return v;
    //  * }
    //  * 
    //  * call by reference (참조에 의한 호출)
    //  * - 변수의 주소값을 매개변수로 함수에 전달하는 방법
    //  * - 함수 내부에서 해당 매개변수를 변경하게 되면 실제 원본변수에도 반영이 됨
    //  * 예시 코드 :
    //  * int add2(int &a, int b){
    //  *  a += 10;
    //  *  cout << a << '\n';
    //  *  return a + b;
    //  * }
    //  * 
    //  * vector<int> go2(vector<int> &v){
    //  *  v[0] = 100;
    //  *  return v;
    //  * }
    //  */
    // //////////////////////////////////////////////////////////////////////
    
    // // call by value (값에 의한 호출)
    // // a에 10을 더해주는 add 메서드 (값에 의한 호출)
    // int a = 1;
    // int b = 2;
    // int sum1 = add(a, b);
    // cout << sum1 << "\n"; // 13
    // cout << a << "\n";   // 1

    // // v[0] 첫번째 벡터에 100을 넣는 go 메서드 (값에 의한 호출)
    // vector<int> v1(3, 0);
    // vector<int> v2 = go(v1);
    // for(int i : v1) {
    //     cout << i << " "; // 0 0 0
    // }
    // cout << "\n";
    // for(int i : v2) {
    //     cout << i << " "; // 100 0 0
    // }
    // cout << "\n"; cout << "\n";

    // // call by reference (참조에 의한 호출)
    // // a에 10을 더해주는 add 메서드 (참조에 의한 호출)
    // int c = 1;
    // int d = 2;
    // int sum2 = add2(c, d);
    // cout << sum2 << "\n"; // 13
    // cout << c << "\n";   // 11

    // // v[0] 첫번째 벡터에 100을 넣는 go 메서드 (참조에 의한 호출)
    // vector<int> v3(3, 0);
    // vector<int> v4 = go2(v3);
    // for(int i : v3) {
    //     cout << i << " "; // 100 0 0
    // }
    // cout << "\n";
    // for(int i : v4) {
    //     cout << i << " "; // 100 0 0
    // }
    // cout << "\n"; cout << "\n";

    //////////////////////////////////////////////////////////////////////
    /**
     * 값에 의한 호출로 넘겨야 할 때
     * - primitive한 타입, 예를 들어 double, int 등은 “값에 의한 호출”로 넘기는게 좋음
     * - 복사가 일어나지만 간단하기 때문에 복사에 대한 코스트가 크지 않음 (CPU 시간, 메모리)
     * - 오히려 함수 내부에서 직접적으로 참조할 수 있기 때문에 더 빠름
     * 
     * 참조에 의한 호출로 넘겨야 할 때
     * - reference한 타입 중 복잡한 struct나 많은 요소를 가진 배열은
     * - 메모리를 많이 차지 하기때문에 참조로써 매개변수를 넘기는 게 좋음
     * - 참조없이 전달하게 될 경우 전체 복사를 해야 하는 코스크가 크기 때문 (CPU 시간, 메모리)
     */
    //////////////////////////////////////////////////////////////////////
    return 0;
}