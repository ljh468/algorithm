#include<bits/stdc++.h>
using namespace std;

bool cmp(pair<int, int> a, pair<int, int> b){
        return a.first > b.first;
}

bool intcmp(int a, int b){
    return a < b;
}

int main(){
    // //////////////////////////////////////////////////////////////////////
    // /**
    //  * fill()
    //  * fill()은 배열을 초기화 할 때 쓰임
    //  * - fill()은 0, 1, 100등 모든 숫자값으로 초기화 가능
    //  * - void fill(ForwardIterator first, ForwardIterator last, const T& val);
    //  * - [first,last)까지 val로 초기화합니다.
    //  * - 시작값은 포함하고, 끝값은 포함하지 않고 초기화
    //  */
    // //////////////////////////////////////////////////////////////////////
    // int a[10];
    // int b[10][10];
    // fill(&a[0], &a[10], 100); // a[0] 메모리 주소값부터 a[10] 메모리 주소값까지 100을 할당
    // for(int i = 0; i < 10; i++){
    //     cout << a[i] << " ";
    // }
    // cout << '\n';
    // fill(&b[0][0], &b[9][10], 2);
    // for(int i = 0; i < 10; i++){
    //     for(int j = 0; j < 10; j++){
    //         cout << b[i][j] << " ";
    //     }
    //     cout << '\n';
    // }
    // cout << '\n';

    // // 배열의 이름 기반으로 초기화 (배열의 이름은 첫번째 메모리주소값을 나타냄)
    // int c[10];
    // int d[10][10];
    // fill(c, c + 10, 100);
    // for(int i = 0; i < 10; i++){
    //     cout << c[i] << " ";
    // }
    // cout << '\n';

    // fill(&d[0][0], &d[0][0] + 10 * 10, 2);
    // for(int i = 0; i < 10; i++){
    //     for(int j = 0; j < 10; j++){
    //         cout << d[i][j] << " ";
    //     }
    //     cout << '\n';
    // }
    // cout << '\n';

    // // Q. 왜 fill()로 전체 초기화를 해야할까?
    // // 행 단위로 순차적으로 초기화가 일어나기때문에 전체 초기화를 하는게 좋음
    // int f[10][10];
    // cin.tie(NULL); cout.tie(NULL);
    // fill(&f[0][0], &f[0][0] + 8 * 8, 4);
    // for(int i = 0; i < 10; i++){
    //     for(int j = 0; j < 10; j++){
    //         cout << f[i][j] << " ";
    //     }
    //     cout << '\n';
    // }

    // //////////////////////////////////////////////////////////////////////
    // /**
    //  * memset()
    //  * - memset()은 바이트단위로 초기화 하며 0, -1, char형의 하나의 문자(a, b, c)등으로 초기화할 때 사용
    //  * - memset()은 -1, 0으로만 초기화 가능 (더 빠름)
    //  * - void *memset(void *ptr, int value, size_t num);
    //  * - 그러나 0, -1 이외의 숫자는 절대 이 memset()으로 초기화 못하니 주의
    //  */
    // //////////////////////////////////////////////////////////////////////
    // const int max_n = 1004;
    // int a[max_n];
    // int a2[max_n][max_n];

    // memset(a, -1, sizeof(a));
    // memset(a2, 0, sizeof(a2));
    // for(int i = 0; i < 10; i++){
    //     cout << a[i] << " ";
    // }
    // cout << '\n';

    // for(int i = 0; i < 10; i++){
    //     for(int j = 0; j < 10; j++){
    //         cout << a2[i][j] << " ";
    //     }
    //     cout << '\n';
    // }
    // cout << '\n';

    // char aa[max_n];
    // memset(aa, 'a', sizeof(a));
    // for(int i = 0; i < 10; i++){
    //     cout << aa[i] << ' '; // a a a ...
    // }
    // cout << '\n';

    // // 쓰지 말아야 할 초기화 방법 {0, }
    // // 0으로 초기화가 되지 않음 -> 되도록 fill(), memset()을 권장
    // int cnt = 0;
    // int c[5] = {0, };
    // while(++cnt != 10){
    //     for(int i = 0; i < 5; i++){
    //         c[i] = i;
    //     }
    //     c[5] = {0, };
    //     for(int i : c){
    //         cout << i << ' ';
    //     }
    // }

    // //////////////////////////////////////////////////////////////////////
    // /**
    //  * memcpy()와 copy()
    //  * 어떤 변수에 깊은 복사를 할때 memcpy()와 copy()를 사용
    //  * memcpy()는 Array끼리 복사할 때 사용하고 copy()는 Array, vector에 모두 쓰임
    //  */
    // //////////////////////////////////////////////////////////////////////

    // //////////////////////////////////////////////////////////////////////
    // /**
    //  * memcpy()
    //  * - 어떤 변수의 실제 값을 특정 메모리주소에 복사할 때 사용
    //  * - void *memcpy(void *destination, const void *source, size_t num);
    //  * - 값 복사 (deep copy)라서 원본은 변하지 않음
    //  * - 주의해야할 점은 memcpy()는 vector에서는 깊은 복사가 되지 않음
    //  */
    // //////////////////////////////////////////////////////////////////////
    // int v[3] = {1, 2, 3};
    // int ret[3];
    // memcpy(ret, v, sizeof(v));
    // cout << ret[1] << '\n';
    // ret[1] = 100;
    // cout << ret[1] << '\n';
    // cout << v[1] << '\n';

    // // 원본 배열 a를 수정하여 출력하는 로직
    // int a[5], temp[5];
    // for(int i = 0; i < 5; i++){
    //     a[i] = i;
    // }
    // memcpy(temp, a, sizeof(a));
    // for(int i : temp){
    //     cout << i << ' ';
    // }
    // cout << '\n';

    // // a[4]를 1000으로 변경
    // a[4] = 1000;
    // for(int i : a){
    //     cout << i << ' ';
    // }
    // cout << '\n';

    // // 그 다음 다시 temp를 기반으로 원본배열에 깊은 복사
    // memcpy(a, temp, sizeof(temp));
    // for(int i : a){
    //     cout << i << ' ';
    // }
    // cout << "\n";

    // // vector - memcpy()
    // vector<int> vv {1, 2, 3}; // 직접 초기화
    // vector<int> rett(3); // 초기 크기 지정 초기화 - 기본값 0
    // memcpy(&rett, &vv, 3*sizeof(int));
    // cout << rett[1] << "\n";
    // cout << vv[1] << "\n";
    // rett[1] = 100;

    // cout << rett[1] << "\n";
    // cout << vv[1] << "\n";

    // // 객체들이 겹치거나 만약 단순 복사 가능하지 않은 경우
    // // is_trivial를 통해 해당 타입이 TriviallyCopyable한지 확인할 수 있는데 vector는 그렇지 않는 것을 볼 수 있음
    // // memcpy()는 Array에서만 동작함
    // if(is_trivial<vector<int>>()){
    //     cout << "Hello Jaehoon!!\n";
    // }

    // // UB 발생하능
    // // int u[8];
    // // memcpy(&u[1], u, sizeof(int) * 7);

    // //////////////////////////////////////////////////////////////////////
    // /**
    //  * copy()
    //  * - memcpy()와 똑같은 동작을 하는 함수 (vector, Array 모두 사용 가능)
    //  * - copy(InputIterator first, InputIterator last, OutputIterator result);
    //  * - vector()는 복사하는 vector와 복사당하는 vector의 크기를 맞춰주는 것이 중요
    //  * - Array v의 크기가 5라면 copy(v, v + 5, ret) 이런식의 코드가 생김
    //  */
    // //////////////////////////////////////////////////////////////////////
    // vector<int> v {1, 2, 3};
    // vector<int> retv(3);
    // copy(v.begin(), v.end(), retv.begin());
    // cout << retv[1] << "\n"; // 2
    // retv[1] = 100;
    // cout << retv[1] << "\n"; // 100
    // cout << v[1] << "\n"; // 2

    // const int n = 3;
    // int r[n] = {1, 2, 3};
    // int retr[n];
    // copy(r, r + n, retr);
    // cout << retr[1] << "\n"; // 2
    
    // retr[1] = 100;
    // cout << retr[1] << "\n"; // 100
    // cout << r[1] << "\n"; // 2

    // int vr[] = {1, 2, 3}; // 원본 배열
    // int retvr[3]; // 결과를 저장할 배열
    // copy(vr, vr + 3, retvr); // v 배열의 내용을 ret 배열로 복사
    // cout << retvr[1] << "\n"; // 복사된 배열의 두 번째 원소 출력
    // retvr[1] = 100; // ret 배열의 두 번째 원소를 100으로 변경
    // cout << retvr[1] << "\n"; // 변경된 원소 출력
    // cout << vr[1] << "\n"; // 원본 배열의 두 번째 원소 출력하여 변경되지 않았음을 확인

    // //////////////////////////////////////////////////////////////////////
    // /**
    //  * sort()는 배열 등 컨테이너들의 요소를 정렬하는 함수
    //  * array나 vector를 정렬할 때 쓰이며 O(nlogn)의 시간복잡도를 가짐
    //  * - sort(first, last, *커스텀비교함수) [first,last) - first는 포함, last는 포함하지 않음
    //  * - 커스텀비교함수를 넣지 않으면 기본적으로 오름차순
    //  * - greater<타입>()를 넣어 내림차순으로 변경할 수 있음
    //  */
    // //////////////////////////////////////////////////////////////////////
    // vector<int> a;
    // int b[5];
    // for(int i = 5; i >= 1; i--){
    //     b[i - 1] = i;
    // }
    // for(int i = 5; i >= 1; i--){
    //     a.push_back(i);
    // }
    
    // // 기본은 오름차순
    // sort(b, b + 5);
    // sort(a.begin(), a.end());
    // for(int i : b){
    //     cout << i << " ";
    // }
    // cout << "\n";
    // for(int i : a){
    //     cout << i << " ";
    // }
    // cout << "\n";

    // // 커스텀 비교 함수 추가
    // sort(b, b + 5, less<int>());
    // sort(a.begin(), a.end(), less<int>());
    // for(int i : b){
    //     cout << i << ' ';
    // }
    // cout << "\n";
    // for(int i : a){
    //     cout << i << ' ';
    // }
    // cout << "\n";

    // // 내림차순
    // sort(b, b + 5, greater<int>());
    // sort(a.begin(), a.end(), greater<int>());
    // for(int i : b){
    //     cout << i << ' ';
    // }
    // cout << '\n';
    // for(int i : a){
    //     cout << i << ' '; 
    // }

    // // pair 기반으로 만들어진 vector의 경우 따로 설정하지 않으면, first, second순으로 차례차례 오름차순 정렬됨
    // vector<pair<int, int>> v;
    // for(int i = 10; i >= 1; i--){
    //     v.push_back({i, 10 - i});
    // }
    // sort(v.begin(), v.end());
    // for(auto it : v){
    //     cout << it.first << " : " << it.second << "\n";
    // }
    // for(pair<int, int> it : v){
    //     cout << it.first << " : " << it.second << "\n";
    // }

    // // first 내림차순, second는 오름차순 정렬 - 커스텀 비교함수 cmp
    // vector<pair<int, int>> v;
    // for(int i = 10; i >= 1; i--){
    //     v.push_back({i, 10 - i});
    // }
    // sort(v.begin(), v.end(), cmp);
    // for(pair<int, int> it : v){
    //     cout << it.first << " : " << it.second << "\n";
    // }

    // // sort()는 각각의 요소들을 cmp함수가 true 가 뜨는 “요소들의 순서”로 바꿔줌
    // // false가 나오면 자리를 바꿔줌
    // vector<int> v2 = {3, 10, 4, 11};
    // sort(v2.begin(), v2.end(), intcmp);
    // for(int i : v2){
    //     cout << i << " ";
    // }

    //////////////////////////////////////////////////////////////////////
    /**
     * stable_sort()
     * 만약 들어온 순서대로 정렬하고 싶다면 sort()가 아닌 stable_sort()를 사용해야함
     * 일반 sort()는 unstable sort이기 때문에 두번째 요소의 순서를 보장하지 않음
     */
    //////////////////////////////////////////////////////////////////////
    vector<pair<int, int>> pairs = {{5, 1}, {2, 5}, {5, 3}, {3, 4}, {2, 2}};
    cout << "Original: ";
    for(const auto &p : pairs){
        cout << "(" << p.first << ", " << p.second << ") "; 
    }
    cout << "\n";
    
    // sort()의 경우 (2, 2), (2, 5) 이렇게 나올수도 있고, (2, 5), (2, 2) 이렇게 나올 수도 있음
    sort(pairs.begin(), pairs.end());
    cout << "Sorted with sort: ";
    for(const auto &p : pairs){
        cout << "(" << p.first << ", " << p.second << ") ";
    }
    cout << "\n";

    // 원본 데이터로 초기화
    pairs = {{5, 1}, {2, 5}, {5, 3}, {3, 4}, {2, 2}};
    stable_sort(pairs.begin(), pairs.end());
    cout << "Sorted with stable_sort: ";
    for(const auto &p : pairs){
        cout << "(" << p.first << ", " << p.second << ") ";
    }
    cout << "\n";

    //////////////////////////////////////////////////////////////////////
    /**
     * sort()와 stable_sort()의 차이
     * - sort() 함수는 unstable sort 알고리즘을 사용
     * - 같은 값을 가진 요소들의 들어온 순서를 정렬후에 보존하지 않음
     * 
     * - stable_sort() 함수는 stable sort 알고리즘을 사용
     * - 같은 값을 가진 요소들의 들어온 순서를 정렬후에도 보존함
     */
    //////////////////////////////////////////////////////////////////////                
    return 0;
}