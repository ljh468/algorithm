#include <bits/stdc++.h>
using namespace std;

// 랄로 구조체 정의하기
struct Ralo {
    int a, b;
    double c, d, e;
};

void print(Ralo ralo) {
    cout << ralo.a << " " << ralo.b << " " << 
    ralo.c << " " << ralo.d << " " << ralo.e << "\n";
};

// Point 구조체 정의하기
struct Point {
    int y, x;
    // x, y를 받아 Point 구조체를 생성 (생성자)
    Point(int y, int x) : y(y), x(x) {}
    // 만약 x, y가 정해지지 않은 경우 기본값 설정
    Point() {
        y = -1;
        x = -1;
    }
    // 연산자 오버로딩 (구조체끼리 비교할때 사용)
    // x가 1순위, y가 2순위로 “오름차순"으로 정렬
    bool operator < (const Point &a) const {
        if(x == a.x) {
            // x가 같으면 y가 작은게 true
            return y < a.y;
        }
        // x가 작은게 true
        return x < a.x;
    }
};

struct Point2{
    int y, x, z;
    Point2(int y, int x, int z) : y(y), x(x), z(z){}
    Point2(){y = -1; x = -1; z = -1; }
    bool operator < (const Point2 & a) const{
        if(x == a.x) {
        if(y == a.y) return z < a.z;
        return y > a.y;
        }
        return x < a.x;
    }
};

bool compareString(string a, string b) {
    if(a.size() == b.size()) {
        return a < b;
    }
    return a.size() < b.size();
}

bool compareRalo(Ralo A, Ralo B) {
    if(A.a == B.a) {
        return A.b < B.b;
    }
    return A.a < B.a;
}

struct Point3{
    int y, x;
};

bool cmp(const Point3 &a, const Point3 &b){
    return a.x > b.x;
}

int main() {
    // //////////////////////////////////////////////////////////////////////
    // /**
    //  * struct (구조체)
    //  * - 개발자가 커스텀한 자료구조를 의미
    //  * - 클래스랑 또 다름
    //  * - 맴버변수에 값을 넣지 않으면 0으로 초기화
    //  * 
    //  * struct 구조체이름 {
    //  *  int a[5];
    //  *  char b[10];
    //  *  float c;
    //  * }
    //  */
    // //////////////////////////////////////////////////////////////////////
    // Ralo ralo = {1, 1, 1, 1, 1};
    // print(ralo);
    
    // vector<Ralo> ret;
    // ret.push_back({1, 2, 3, 4, 5});
    // ret.push_back({1, 2, 3, 4, 6});
    // ret.push_back({}); // 0으로 초기화됨
    // ret.push_back({1, 3}); // 앞에서부터 초기화 넣지 않은 값은 0으로 초기화
    // for(Ralo ralo : ret) {
    //     print(ralo);
    // }

    // //////////////////////////////////////////////////////////////////////
    // /**
    //  * 구조체를 집어넣은 vector를 정렬하려면?
    //  * - 1순위 a, 2순위 b로 오름차순 정렬하고 싶다면?
    //  * - 아무것도 넣지 않아 0 또는 빈문자열로 들어가야하는데, 초기값을 설정하고 싶다면?
    //  * 
    //  * operator 연산자 오버로딩을 구조체에 정의해야함 (오퍼레이터 대상이 바뀌기 때문에 오버로딩이라고 함)
    //  * sort()함수 자체가 < 오퍼레이터를 기준으로 정렬하기 때문에 < 오퍼레이터를 기준으로 설정되어야함
    //  * compare 함수를 만들어서 할 수도 있음
    //  * 
    //  * struct Point{
    //  *  int y, x;
    //  *  Point(int y, int x) : y(y), x(x){}
    //  *  Point(){y = -1; x = -1; }
    //  *   bool operator < (const Point & a) const{
    //  *      if(x == a.x) return y < a.y;
    //  *      return x < a.x;
    //  *   }
    //  * };
    //  * 
    //  * - 왼쪽에서부터 아스키코드순으로 비교함
    //  * - 항상 숫자로 이루어진 문자열을 비교할 때는 사이즈확인 로직이어야 함
    //  * bool compare(string a, string b) {
    //  *  if(a.size() == b.size()) {
    //  *      return a < b;
    //  *  }
    //  *  return a.size() < b.size();
    //  * }
    //  */
    // //////////////////////////////////////////////////////////////////////
    // ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    // string a[3] = {"111", "222", "33"};
    // sort(a, a + 3, compareString); // first는 포함 last는 미포함
    // for(string b : a) {
    //     cout << b << " ";
    // }

    // //////////////////////////////////////////////////////////////////////
    // /**
    //  * Ralo struct를 compare 함수를 통해 정렬한 코드
    //  * struct Ralo {
    //  *  int a, b;
    //  * }
    //  * 
    //  * bool compar(Ralo A, Ralo B) {
    //  *  if (A.a == B.a) {
    //  *      return A.b < B.b;
    //  *  }
    //  *  return A.a < B.a;
    //  * }
    //  * 
    //  */
    // //////////////////////////////////////////////////////////////////////
    // ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    // Ralo a[3] = {{1, 2}, {1, 3}, {0, 4}};
    // sort(a, a + 3, compareRalo);
    // for(Ralo A : a) {
    //     cout << "{" << A.a << ", " << A.b << "}" << "\n";
    // }

    // //////////////////////////////////////////////////////////////////////
    // /**
    //  * 3개의 멤버변수 정렬하기
    //  * 3개의 멤버변수인 y, x, z가 필요하다고 했을때,
    //  * x를 1순위로 오름차순으로 정렬하고 y가 2순위로 내림차순 z가 3순위로 오름차순 정렬하고 싶다면?
    //  * 
    //  * struct Point2 {
    //  *  int x, y, z;
    //  *  Point2(int x, y, z) : x(x), y(y), z(z) {}
    //  *  Point2() {
    //  *      x = -1;
    //  *      y = -1;
    //  *      z = -1;
    //  *  }
    //  * }
    //  * 
    //  * bool operator < (const Point2 &a) const {
    //  *  if(x == a.x) {
    //  *      if(y = a.y) {
    //  *          return z < a.z;
    //  *      }
    //  *      return y < a.y;
    //  *  }
    //  *  return x < a.x;
    //  * }
    //  */
    // //////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////
    /**
     * vector에다 struct넣고 정렬하기
     * struct Point3 {
     *  int y, x;
     * }
     * bool cmp(const Point3 &a, const Point3 &b) {
     *  return a.x > b.x;
     * }
     * 
     * * struct의 멤버변수는 기본적으로 public이며 상속이 안되고
     * * class의 멤버변수는 기본적으로 private이며 상속이 됨 (코테에서는 struct만 알아도 충분함)
     */
    //////////////////////////////////////////////////////////////////////
    vector<Point3> v;
    for(int i = 10; i >= 1; i--) {
        v.push_back({i, 10 - i}); // 10, 9 -> 9, 1 -> 8, 2 ...
    }
    sort(v.begin(), v.end(), cmp);
    for(const Point3& it : v) {
        cout << it.y << " : " << it.x << "\n";
    }
    return 0;
}