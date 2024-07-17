#include<bits/stdc++.h>
using namespace std;

list<int> a;
void print(list<int> a){
    for(int it : a){
        cout << it << " ";
    }
    cout << "\n";
}

int main(){
    // //////////////////////////////////////////////////////////////////////
    // /**
    //  * List() - 연결리스트
    //  * 랜덤 접근이 불가능하며 오로지 순차적 접근만 가능
    //  * 요소들은 next, prev라는 포인터로 연결되어 이루어지며 중복을 허용함
    //  * 삽입과 삭제가 O(1), n번째 요소를 참조한다고 했을때 O(n)의 시간복잡도를 가짐
    //  * 
    //  * 연결리스트는 싱글연결리스트, 이중연결리스트, 원형연결리스트 크게 3가지가 있음
    //  * * 싱글 연결리스트 - next 포인터밖에 존재하지 않으며 한방향으로만 데이터가 연결
    //  * * 이중 연결리스트 - prev, next 2개의 포인터로 양방향으로 데이터가 연결
    //  * * 원형 연결리스트 - 마지막 노드와 첫번째 노드가 연결되어 원을 형성
    //  */
    // //////////////////////////////////////////////////////////////////////
    // class Node {
    // public:
    //     int data;
    //     Node* next;
    //     Node(){
    //         data = 0;
    //         next = NULL:
    //     }
    //     Node(int data){
    //         this -> data = data;
    //         this -> next = NULL:
    //     }
    // }

    // //////////////////////////////////////////////////////////////////////
    // /**
    //  * push_fron(value)
    //  * - 리스트의 앞에서 부터 value를 넣음
    //  * 
    //  * push_back(value)
    //  * - 리스트의 뒤에서 부터 value를 넣음
    //  * 
    //  * insert(index, value)
    //  * - iterator insert(const_iterator position, const value_type& val);
    //  * - 리스트위 index 위치에 요소(value)를 삽입
    //  * 
    //  * erase(index)
    //  * - iterator erase(const_iterator position);
    //  * - 리스트의 index 위치의 요소를 지움
    //  * 
    //  * pop_front()
    //  * - 맨 앞 요소를 지움
    //  * 
    //  * pop_back()
    //  * - 맨 끝 요소를 지움
    //  * 
    //  * front()
    //  * - 맨 앞 요소를 참조
    //  * 
    //  * back()
    //  * - 맨 끝 요소를 참조
    //  * 
    //  * clear()
    //  * - 모든 요소를 지움
    //  */
    // //////////////////////////////////////////////////////////////////////
    // for(int i = 1; i <= 3; i++){
    //     a.push_back(i);
    // }
    // for(int i = 1; i <= 3; i++){
    //     a.push_front(i);
    // }
    // print(a);

    // list<int>::iterator it = a.begin();
    // it++;
    // a.insert(it, 1000);
    // print(a);

    // // 2번째 요소(1000)을 제거
    // it = a.begin(); it++;
    // a.erase(it);
    // print(a);

    // a.pop_front();
    // a.pop_back();
    // print(a);

    // cout << a.front() << " : " << a.back() << '\n';
    // a.clear();

    // //////////////////////////////////////////////////////////////////////
    // /**
    //  * 배열과 연결리스트 비교
    //  * 배열은 연속된 메모리 공간에 데이터를 저장하고 연결리스트는 연속되지 않은 메모리 공간에 데이터를 저장
    //  * 
    //  * 배열은 삽입과 삭제에는 O(n)이 걸리고 참조에는 O(1)이 걸림
    //  * - 배열은 데이터 변경이 오래 걸리고 조회는 빠름
    //  * - 참조를 많이 하는 것은 배열을 사용
    //  * 
    //  * 연결리스트는 삽입과 삭제에는 O(1)이 걸리고 참조에는 O(n)이 걸림
    //  * - 연결리스트는 데이터 변경이 용이하고 조회는 느림
    //  * - 데이터추가와 삭제를 많이 하는 것은 연결 리스트 사용
    //  */
    // //////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////
    /**
     * map
     * map은 고유한 키를 기반으로 key - value 쌍으로 이루어져있는 정렬된 연관 컨테이너
     * 레드 - 블랙트리로 구현됨
     * 삽입, 삭제, 수정, 탐색이 - O(logn)
     * 
     * 고유한 키를 갖기 때문에 하나의 키에 중복된 값이 들어갈 수 없으며 자동으로 오름차순 정렬되기 때문에
     * 넣은 순서대로 map을 탐색할 수 있는 것이 아닌 아스키코드순으로 정렬된 값들을 기반으로 탐색하게 됨
     * 또한 대괄호 연산자 [] 로 해당 키로 직접 참조할 수 있음
     */
    //////////////////////////////////////////////////////////////////////
    map<string, int> mp;
    string a[] = {"이재훈", "이승철", "박소담"};
    for(int i = 0; i < 3; i++){
        mp.insert({a[i], i + 1});\
        mp[a[i]] = i + 1;
    }
    // mp에 해당 키가 없다면 0으로 초기화 되어 할당됨.(int의 경우)
    // 만약 mp에 해당 키가 없는지 확인하고 싶고
    // 초깃값으로 0으로 할당되지 않아야 되는 상황이라면 find를 써야 함.
    cout << mp["jaehoon"] << "\n";

    // 대괄호로 수정가능
    mp["jaehoon"] = 4;
    cout << mp.size() << "\n";
    mp.erase("jaehoon");
    
    map<string, int>::iterator it = mp.find("jaehoon");
    if(it == mp.end()){
        cout << "못찾겠네 꾀꼬리\n";
    }

    mp["jaehoon"] = 100;
    it = mp.find("jaehoon");
    if(it != mp.end()){
        cout << (*it).first << " : " << (*it).second << "\n";
    }
    // pair는 바로 접근이 가능하기 때문에 (it)
    for(pair<string, int> it : mp){
        cout << (it).first << " : " << (it).second << "\n";
    }
    // 이터레이터이기 때문에, 역참조 (*it)
    for(map<string, int>::iterator it = mp.begin(); it != mp.end(); it++){
        cout << (*it).first << " : " << (*it).second << "\n";
    }
    mp.clear();


    // //////////////////////////////////////////////////////////////////////
    // /**
    //  * insert({key, value})
    //  * - map에다 {key, value}를 추가함
    //  *
    //  * [key] = value
    //  * - 대괄호[]를 통해 key에 해당하는 value를 할당
    //  * 
    //  * [key]
    //  * - 대괄호[]를 통해 key를 기반으로 map에 있는 요소를 참조
    //  * 
    //  * size()
    //  * - map에 있는 요소들의 개수를 반환
    //  * 
    //  * erase(key);
    //  * - key에 해당하는 요소를 지움
    //  * 
    //  * find(key)
    //  * - map에서 해당 key를 가진 요소를 찾아 해당 이터레이터를 반환
    //  * - 만약 못찾을 경우 해당 map의 end() 이터레이터를 반환
    //  * 
    //  * for(auto it : mp)
    //  * - 범위기반 for루프로 map에 있는 요소들을 순회
    //  * - map을 순회할 때는 key는 first, value는 second로 참조가 가능
    //  * 
    //  * for(auto it = mp.begin(); it != mp.end(); it++)
    //  * - map에 있는 요소들을 이터레이터로 순회할 수 있음
    //  * 
    //  * mp.clear()
    //  * - map에 있는 요소들을 모두 제거
    //  */
    // //////////////////////////////////////////////////////////////////////

    // //////////////////////////////////////////////////////////////////////
    // /**
    //  * 맵을 쓸 때 주의할 점
    //  * - map의 경우 해당 인덱스에 참조만해도 맵의 요소가 생기게 됨
    //  * - 만약 map의 해당 키에 요소가 없다면 0 또는 빈문자열로 초기화가 되어 할당됨 (int는 0, string은 빈문자열)
    //  * - 할당하고 싶지 않아도 대괄호[]로 참조할 경우 자동으로 요소가 추가 되기 때문에 조심해야함
    //  */
    // //////////////////////////////////////////////////////////////////////
    // map<int, int> mp;
    // map<string, string> mp2;
    // ios_base::sync_with_stdio(false);
    // cin.tie(NULL); cout.tie(NULL);

    // // 대괄호[]로 참조할경우 자동으로 요소가 추가 됨
    // cout << mp[1] << "\n";
    // cout << mp2["aaa"] << "\n";

    // for(auto i : mp){
    //     cout << i.first << " " << i.second;
    // }
    // cout << "\n";

    // for(auto i : mp2){
    //     cout << i.first << " " << i.second;
    // }
    // cout << "\n";

    // // 맵에 요소가 있는지 없는지를 확인하고 맵에 요소를 할당하는 로직
    // mp.clear();
    // mp2.clear();
    // if(mp[1] == 0){
    //     mp[1] = 2;
    // }
    // for(auto i : mp){
    //     cout << i.first << " " << i.second;
    // }
    // cout << "\n";

    // // 0이 들어가는 것을 비교하기 귀찮다면 다음 코드를 기반으로
    // mp.clear();
    // mp2.clear();
    // if(mp.find(1) == mp.end()){
    //     mp[1] = 2;
    // }
    // for(auto it : mp){
    //     cout << it.first << " " << it.second;
    // }

    //////////////////////////////////////////////////////////////////////
    /**
     * unordered_map
     * map은 정렬이 되는 반면, unordered_map은 정렬이 되지 않은 map이며 메서드는 map과 동일
     * 되도록 map을 쓰는것을 권장
     * 
     * - map : 정렬이 됨 / 레드블랙트리기반 / 탐색, 삽입, 삭제에 O(logN)이 걸림
     * - unordered_map : 정렬이 안됨 / 해시테이블 기반 / 탐색, 삽입, 삭제에 평균적으로 O(1), 가장 최악의 경우 O(N)
     */
    //////////////////////////////////////////////////////////////////////
    unordered_map<string, int> umap;
    umap["bcd"] = 1;
    umap["aaa"] = 1;
    umap["aba"] = 1;
    for(pair<string, int> it : umap){
        cout << it.first << " : " << it.second << "\n";
    }
    return 0;
}