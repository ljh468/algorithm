#include <bits/stdc++.h>
using namespace std;

bool cmp(pair<int, int> a, pair<int, int> b)
{
    return a.first < b.first;
}

int main()
{
    // //////////////////////////////////////////////////////////////////////
    // /**
    //  * set
    //  * 셋(set)은 고유한 요소만을 저장하는 컨테이너
    //  * 중복을 허용하지 않고 {key, value} 형태가 아니어도 되며 pair or int형을 넣을 수 있음
    //  * 중복된 값은 제거되며 map과 같이 자동 정렬이 됨, 메서드는 map과 같음
    //  */
    // //////////////////////////////////////////////////////////////////////
    // set<pair<string, int>> st;
    // st.insert({"test", 1});
    // st.insert({"test", 1});
    // st.insert({"test", 1});
    // st.insert({"test", 1});
    // cout << st.size() << "\n";

    // set<int> st2;
    // st2.insert(2);
    // st2.insert(1);
    // st2.insert(2);
    // for(int i : st2){
    //     cout << i << "\n";
    // }

    //////////////////////////////////////////////////////////////////////
    /**
     * set과 unique중에 어떤 것을 써야할까?
     *
     * unique를 통해 중복된 요소를 제거할 수 있음
     * - unique()와 erase()를 사용하면 중복된 배열 vector를 기반으로 재사용하는 장점이 있음
     *
     * set을 통해서도 중복된 요소를 제거할 수 있음
     * - 1. 중복된 배열 vector 생성됨
     * - 2. set을 사용해서 중복제거
     * - 3. 다시 새로운 vector를 만들어 요소를 집어넣음
     * -> 새로운 vector와 set 2개의 자료구조가 "더" 만들어지게 됨
     *
     * 결론 - set을 사용해도 되고, unique와 erase를 사용해도 됨
     */
    //////////////////////////////////////////////////////////////////////
    // /**
    //  * 테스팅 코드
    //  *
    // void A(){
    //     vector<int> v;
    //     int n = 1e5;
    //     for(int i = 1; i < n; i++){
    //         v.push_back(i);
    //         v.push_back(n - i);
    //     }
    //     sort(v.begin(), v.end());
    //     v.erase(unique(v.begin(), v.end()), v.end());
    // }

    // void B(){
    //     vector<int> v;
    //     int n = 1e5;
    //     for(int i = 1; i < n; i++){
    //         v.push_back(i);
    //         v.push_back(n - i);
    //     }
    //     set<int> st;
    //     for(int i : v){
    //         st.insert(i);
    //     }
    //     vector<int> nv;
    //     for(int i : st){
    //         nv.push_back(i);
    //     }
    // }

    // void test_latency(size_t iteration){
    //     PROFILE_START("A");
    //     A();
    //     PROFILE_STOP("A");
    //     PROFILE_START("B");
    //     B();
    //     PROFILE_STOP("B");
    // }

    // int main() {
    //     const size_t warmups = 1000;
    //     const size_t tests = 100;
    //     PROFILE_RUN_ALL(warmups, tests,
    //     test_latency(__loop);
    //     );
    //     return 0;
    // }
    //  */

    // //////////////////////////////////////////////////////////////////////
    // /**
    //  * multiset
    //  * multiset은 중복되는 요소도 집어넣을 수 있는 자료구조
    //  * kay, value 형태일 필요없이 자동으로 정렬됨, 메서드는 map과 동일
    //  */
    // //////////////////////////////////////////////////////////////////////
    // multiset<int> s;
    // for(int i = 5; i >= 1; i--){
    //     s.insert(i);
    //     s.insert(i);
    // }
    // for(int i : s){
    //     cout << i << " ";
    // }
    // cout << "\n";

    // //////////////////////////////////////////////////////////////////////
    // /**
    //  * stack
    //  * - 스택은 가장 마지막으로 들어간 데이터가 가장 첫번째로 나오는 LIFO(last in first out) 자료구조
    //  * - 재귀적인 함수, 알고리즘에 사용되며 웹브라우저 방문기록 등에 쓰임
    //  * - 삽입 & 삭제에 O(1), 탐색에 O(n)
    //  *
    //  * - 스택은 주로 문자열 폭발, 아름다운 괄호만들기, 짝찾기 키워드를 기반으로 이루어진 문제에서 쓰일 수 있음
    //  * - 또한, "교차하지 않고" 라는 문장이 나오면 스택을 사용해야 하는게 아닐까?를 염두해둬야 함
    //  *
    //  * push(value)
    //  * - 해당 value를 스택에 추가함
    //  *
    //  * pop()
    //  * - 가장 마지막에 추가한 요소를 지움
    //  *
    //  * top()
    //  * - 가장 마지막에 있는 요소를 참조함
    //  *
    //  * size()
    //  * - 스택의 크기
    //  */
    // //////////////////////////////////////////////////////////////////////
    // stack<string> stk;
    // ios_base::sync_with_stdio(false);
    // cin.tie(NULL); cout.tie(NULL);
    // stk.push("엄");
    // stk.push("준");
    // stk.push("식");
    // stk.push("화");
    // stk.push("이");
    // stk.push("팅");
    // while(stk.size()){
    //     cout << stk.top() << "\n";
    //     stk.pop();
    // }

    // //////////////////////////////////////////////////////////////////////
    // /**
    //  * queue
    //  * - 큐는 먼저 넣은 데이터가 먼저 나오는 FIFO(first in first out) 자료구조
    //  * - 삽입 & 삭제에 O(1), 탐색에 O(n)
    //  *
    //  * push(value)
    //  * - value를 큐에 추가함
    //  *
    //  * pop()
    //  * - 가장 앞에 있는 요소를 제거
    //  *
    //  * size()
    //  * - 큐의 크기를 반환
    //  *
    //  * front()
    //  * - 가장 앞에 있는 요소를 참조
    //  */
    // //////////////////////////////////////////////////////////////////////
    // queue<int> q;
    // for(int i = 1; i <= 10; i++){
    //     q.push(i);
    // }
    // while(q.size()){
    //     cout << q.front() << " ";
    //     q.pop();
    // }

    //////////////////////////////////////////////////////////////////////
    /**
     * deque
     * - 앞뒤로 삽입, 삭제, 참조가 모두가능한 큐 자료구조
     * 
     * push_back(value)
     * - value를 맨뒤(오른쪽)에 추가함
     * 
     * push_fron(value)
     * - value를 맨앞(왼쪽)에 추가함
     * 
     * pop_back();
     * - 맨뒤에 있는 요소를 제거함 (반환값이 없음)
     * 
     * pop_fron();
     * - 맨앞에 있는 요소를 제거함 (반환값이 없음)
     * 
     * front()
     * - 맨앞의 요소를 반환함
     * 
     * back()
     * - 맨뒤의 요소를 반환함
     * 
     * size()
     * - 사이즈를 반환함
     * 
     * empty()
     * - 비어있는지 여부를 반환함 (비어있으면 true:1, 비어있지 않으면 false:0)
     * 
     * clear()
     * - 모든 요소를 제거함
     * 
     */
    //////////////////////////////////////////////////////////////////////
    deque<int> dq;
    dq.push_front(1);
    dq.push_back(2);
    dq.push_back(3);
    for(int i : dq){
        cout << i << " ";
    }
    cout << "\n";

    cout << dq.front() << "\n";
    cout << dq.back() << "\n";
    cout << dq.size() << "\n";

    dq.pop_front();
    cout << dq.size() << "\n";

    // 참(true: 1)과 거짓(false: 0)
    cout << dq.empty() << "\n";
    dq.clear();
    cout << dq.empty() << "\n";
    return 0;
}