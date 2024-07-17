#include<bits/stdc++.h>
using namespace std;

int main(){
    // //////////////////////////////////////////////////////////////////////
    // /**
    //  * unique()
    //  * unique는 범위안에 있는 요소 중 앞에서부터 서로를 비교해가며 중복되는 요소를 제거하고
    //  * 나머지 요소들은 삭제하지 않고 그대로 두는 함수 - O(n) 시간복잡도를 가짐
    //  */
    // //////////////////////////////////////////////////////////////////////
    // vector<int> v;
    // for(int i = 1; i <= 5; i++){
    //     v.push_back(i);
    //     v.push_back(i);
    // }

    // for(int i : v){
    //     cout << i << " ";
    // }
    // cout << '\n';

    // // 중복되지 않은 요소로 채운 후, 그다음 번째 이터레이터를 반환한다.
    // // 1, 1, 2, 2, 3, 3, 4, 4, 5, 5
    // // 1, 2, 3, 4, 5 -> 여기부터 반환 (3, 4, 4, 5, 5)
    // vector<int>::iterator iter1 = unique(v.begin(), v.end());
    // cout << iter1 - v.begin() << '\n'; // 5 - 0 = 5

    // // 앞에서 부터 중복되지 않게 채운 후 나머지 요소들은 그대로 둔다.
    // for(int i : v){
    //     cout << i << " ";
    // }
    // cout << '\n';

    // vector<int> vv {1, 1, 2, 2, 3, 3, 5, 6, 7, 8, 9};
    //              // 1, 2, 3, 4, 5, 6, 7, 8, 7, 8, 9 
    // vector<int>::iterator iter2 = unique(vv.begin(), vv.end());
    // for(int i : vv){
    //     cout << i << " ";
    // }
    // cout << "\n";

    // // sort()와 같이 사용하는 unique()
    // ios_base::sync_with_stdio(false);
    // cin.tie(NULL); cout.tie(NULL);
    // vector<int> s {4, 3, 3, 5, 1, 2, 3};
    // s.erase(unique(s.begin(), s.end()), s.end());
    // for(int i : s){
    //     cout << i << " ";
    // }
    // cout << "\n";

    // vector<int> s2 {4, 3, 3, 5, 1, 2, 3};
    // sort(s2.begin(), s2.end());
    // cout << "정렬 후" << '\n';
    // for(int i : s2){
    //     cout << i << " ";
    // }
    // cout << '\n';

    // cout << "unique로 제거" << '\n';
    // s2.erase(unique(s2.begin(), s2.end()), s2.end());
    // for(int i : s2){
    //     cout << i << " ";
    // }

    // //////////////////////////////////////////////////////////////////////
    // /**
    //  * lower_bound()와 upper_bound()
    //  * 
    //  * - 어떠한 값이 나오는 첫번째 시점은 lower_bound()
    //  * - 어떠한 값이 초과되는 시점은 upper_bound()
    //  * - but 정렬된 배열에서만 사용해야 함
    //  * 
    //  * - 두 함수는 이터레이터를 반환함, 주소값을 기반으로 몇번째 요소인지를 뽑아낼 수 있음
    //  */
    // //////////////////////////////////////////////////////////////////////
    // vector<int> a {1, 2, 3, 3, 3, 4};
    // cout << &*lower_bound(a.begin(), a.end(), 3) << "\n";
    // cout << &*a.begin() << "\n";
    // cout << &*(a.begin() + 1) << "\n";

    // cout << lower_bound(a.begin(), a.end(), 3) - a.begin() << "\n"; // 2
    // cout << upper_bound(a.begin(), a.end(), 3) - a.begin() << "\n"; // 5

    // // 주소값끼리 -하게 되면 해당 주소값에서 몇번째에 이 요소가 들어있음을 반환하게 됨
    // cout << &*lower_bound(a.begin(), a.end(), 3) - &*a.begin() << "\n"; // 2
    
    // vector<int> b {0, 0, 0, 0};
    // cout << &*(b.begin() + 3) - &*b.begin() << "\n"; // 3

    // // lower_bound가 가리키는 요소를 출력할 수 있음 (역참조)
    // vector<int> c {1, 2, 3, 3, 4, 100};
    // cout << *lower_bound(c.begin(), c.end(), 100) << "\n";

    // vector<int> d {1, 2, 3, 3, 3, 3, 4, 100};
    // // 6 - 2 = 4 (3의 개수를 찾을 수 있음)
    // cout << upper_bound(d.begin(), d.end(), 3) - lower_bound(d.begin(), d.end(), 3) << "\n";

    // // 해당 요소가 없을 경우 다음코드처럼 그 근방지점을 반환
    // vector<int> v;
    // for(int i = 2; i <= 5; i++){
    //     v.push_back(i);
    // }
    // v.push_back(7);
    
    // // 2 3 4 5 7
    // // 0 1 2 3 4 에서 근방지점인 4번째 (7보다 6이 더 작으므로)
    // cout << lower_bound(v.begin(), v.end(), 6) - v.begin() << "\n"; // 4
    // // 2 3 4 5 7
    // // 0 1 2 3 4 에서 근방지점인 4번째 (7보다 6이 더 작으므로)
    // cout << upper_bound(v.begin(), v.end(), 9) - v.begin() << "\n"; // 4
    
    // // 2 3 4 5 7
    // // 0 1 2 3 4 에서 근방지점인 5번째(7보다 9가 더 크므로)
    // cout << lower_bound(v.begin(), v.end(), 9) - v.begin() << "\n"; // 5

    // // 2 3 4 5 7
    // // 0 1 2 3 4 에서 근방지점인 5번째(7보다 9가 더 크므로)
    // cout << lower_bound(v.begin(), v.end(), 9) - v.begin() << "\n"; // 5

    // // 2 3 4 5 7
    // // 0 1 2 3 4 에서 근방지점인 0번째(0보다 2가 더 크므로)
    // cout << upper_bound(v.begin(), v.end(), 0) - v.begin() << "\n"; // 0
    // // 2 3 4 5 7
    // // 0 1 2 3 4 에서 근방지점인 0번째(0보다 2가 더 크므로)
    // cout << lower_bound(v.begin(), v.end(), 0) - v.begin() << "\n"; // 0

    // //////////////////////////////////////////////////////////////////////
    // /**
    //  * accumulate()
    //  * 배열의 합을 쉽고 빠르게 구해주는 방법
    //  */
    // //////////////////////////////////////////////////////////////////////
    // vector<int> v = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    // int sum = accumulate(v.begin(), v.end(), 0);
    // cout << sum << "\n"; // 5

    // // //////////////////////////////////////////////////////////////////////
    // // /**
    // //  * max_element()
    // //  * 배열 중 가장 큰 요소를 추출하는 방법
    // //  * 이터레이터를 반환, *를 통해 값을 꺼낼 수 있음
    // //  */
    // // //////////////////////////////////////////////////////////////////////
    // vector<int> v = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    // int a = *max_element(v.begin(), v.end());
    // vector<int>::iterator b = max_element(v.begin(), v.end());
    // cout << a << "\n"; // 10
    // cout << (int)(b - v.begin()) << "\n"; // 9 (최대값의 인덱스)

    // //////////////////////////////////////////////////////////////////////
    // /**
    //  * min_element()
    //  * 배열 중 가장 작은 요소를 추출하는 방법
    //  */
    // //////////////////////////////////////////////////////////////////////
    // vector<int> v = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    // int a = *min_element(v.begin(), v.end());
    // vector<int>::iterator b = min_element(v.begin(), v.end());
    // cout << a << "\n"; // 1
    // cout << (int)(b - v.begin()) << "\n"; // 0 최소값의 인덱스
    return 0;
}