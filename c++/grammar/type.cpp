#include <bits/stdc++.h>
using namespace std;

// int ret = 1;
// double aa();

// void a(){
//     ret = 2;
//     cout << ret << "\n";
//     return;
// }

// double aa() {
//     return 1.2333;
// }

// char b(){
//     char a = 'a';
//     return a;
// }

int main(){
    // a();
    // double ret = aa();
    // cout << ret << '\n';

    // char a = 'a';
    // cout << a << "\n";

    // char a = b();
    // cout << a << "\n";

    char a = '\0';  // a에 NULL 문자 할당
    char b = 0;     // b에 정수 0 할당, 이는 char에서 NULL 문자와 동일
    char c = NULL;  // c에 NULL 매크로 할당, 이는 '\0'과 동일
    string d = "";

    cout << "hello";  // "hello" 출력

    if(a == b) cout << 1;  // a와 b는 동일하므로 1 출력
    if(b == c) cout << 1;  // b와 c도 동일하므로 1 출력

    // string(1, a)는 a를 하나의 문자로 가지는 문자열 생성, 이는 "\0"과 같음
    if(string(1, a) == d) cout << 1;

    // string a = "나는야";
    // cout << a[0] << "\n";
    // cout << a[0] << a[1] << a[2] << '\n';
    // cout << a << "\n";

    // string b = "abc";
    // cout << b[0] << "\n";
    // cout << b << "\n";

    // string a = "love is";
    // a += " pain!";
    // a.pop_back();

    // cout << a << " : " << a.size() << "\n";
    // cout << char(* a.begin()) << "\n";
    // cout << char(* (a.end() - 1 )) << "\n";

    // // string& insert (size_t pos, const string& str);
    // a.insert(0, "test ");
    // cout << a << " : " << a.size() << "\n";
    // // string& erase (size_t pos, const string& str)
    // a.erase(0, 5);
    // cout << a << " : " << a.size() << "\n";

    // // size_t find (const string& str, size_t pos = 0);
    // // auto는 추론형 타입
    // auto it = a.find("love");
    // if(it != string::npos){
    //     cout << "포함되어 있다." << "\n";
    // }
    // cout << it << "\n";
    // cout << string::npos << "\n";

    // // string substr(size_t pos = 0, size_t len = npos) const;
    // cout << a.substr(5, 2) << "\n";

    // // 입출력 동기화 해제
    // ios::sync_with_stdio(false);
    // // 입출력 연결 해제 & 버퍼 플러시
    // cin.tie(NULL); cout.tie(NULL);

    // string a = "aaabbb";
    // string b = a.substr(2);
    // cout << b << "\n";

    // 문자열은 아스키 기반으로 이루어짐
    // 아스키코드로 어떤 로직을 구축한다 했을 때 127이 넘어가는 숫자를 만들면 에러
    // 0 -> 48, A -> 65, a -> 97
    // ios::sync_with_stdio(false);
    // cin.tie(NULL);
    // string s = "123";
    // s[0]++;
    // cout << s << "\n"; // 223

    // ios_base::sync_with_stdio(false);
    // cin.tie(NULL); cout.tie(NULL);
    // char a = 'a';
    // cout << a << '\n';
    // cout << (int)a << '\n';

    // string a = "It's hard to have a sore leg";
    // reverse(a.begin(), a.end());
    // cout << a << '\n';

    // reverse(a.begin(), a.end());
    // cout << a << '\n';

    // reverse(a.begin() + 3, a.end());
    // cout << a << '\n';
    /*
        gel eros a evah ot drah s'tI
        It's hard to have a sore leg
        It'gel eros a evah ot drah s
    */
    return 0;
}

