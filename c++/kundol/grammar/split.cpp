#include <bits/stdc++.h>
using namespace std;

vector<string> split(string input, string delimiter){
    vector<string> ret;
    long long pos = 0;
    string token = "";

    // 단 3줄만 외우면 됨
    while((pos = input.find(delimiter)) != string::npos){
        token = input.substr(0, pos);
        ret.push_back(token);
        input.erase(0, pos + delimiter.length());
    }
    
    ret.push_back(input);
    return ret;
}

vector<string> split2(const string& input, string delimiter){
    vector<string> result;
    auto start = 0;
    auto end = input.find(delimiter);
    while(end != string::npos){
        result.push_back(input.substr(start, end - start));
        start = end + delimiter.size();
        end = input.find(delimiter, start);
    }
    result.push_back(input.substr(start));
    return result;
}

int main(){
    string s = "안녕하세요 재훈이는 킹갓제네럴 천재입니다 정말이에요!", d = " ";
    vector<string> a = split(s, d);
    for(string b : a){
        cout << b << "\n";
    }
    cout << '\n';
    vector<string> b = split2(s, d);
    for(string b : a){
        cout << b << "\n";
    }

    // 범위기반 for 루프
    // vector<int> a = {1, 2, 3};
    // for(int b : a){
    //     cout << b << "\n"; // 1, 2, 3
    // }

    // for(int i = 0; i < a.size(); i++){
    //     cout << a[i] << "\n";
    // }

    // int a[10];
    // for(int i : a){
    //     cout << i << " ";
    // }

    // forEach 할때의 루프의 범위는 컴파일시기에 결정됨
    // a[n] 배열이 런타임시기에 결정되기 때문에 에러가 나옴
    // 일부 GCC 컴파일러는 앞의 코드에서 에러가 발생되지 않습니다. 그러나 표준 C++에서는 권장하지 않는 방법
    int n;
    cin >> n;
    int ddd[n];
    memset(ddd, 0, sizeof(ddd));
    for(int i : ddd){
        cout << i << " ";
    }

    
    return 0;
}