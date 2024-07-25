#include <iostream>
#include <numeric>  // std::accumulate 사용
#include <string>
#include <unordered_map>
#include <vector>
using namespace std;

void print_scores(const unordered_map<string, vector<int>>& student_scores,
                  const string& name) {
  // 학생 이름에 해당하는 점수 목록을 찾습니다.
  // unordered_map<string, vector<int>>::const_iterator it = student_scores.find(name);
  auto it = student_scores.find(name);
  if (it != student_scores.end()) {
    cout << name << "의 점수: ";
    // 점수 목록을 순회하며 출력합니다.
    for (int score : it->second) {
      cout << score << " ";
    }
    cout << '\n';
  }
};

void print_average_score(const unordered_map<string, vector<int>>& student_scores,
                         const string& name) {
  // 학생 이름에 해당하는 점수 목록을 찾습니다.
  // unordered_map<string, vector<int>>::const_iterator it = student_scores.find(name);
  auto it = student_scores.find(name);

  if (it != student_scores.end()) {
    const vector<int>& scores = it->second;  // 학생의 점수 목록을 참조
    double average = accumulate(scores.begin(), scores.end(), 0.0) / scores.size();  // 평균 계산
    cout << name << "의 평균점수: " << average << '\n';
  } else {
    cout << name << "의 점수를 찾을 수 없습니다." << '\n';
  }
}

int main() {
  // 학생 이름을 키로 하고, 그 학생의 점수 목록을 벡터로 저장하는 unordered_map
  // 선언
  unordered_map<string, vector<int>> student_scores;

  // 학생들의 점수를 추가합니다.
  student_scores["Alice"].push_back(90);  // Alice의 점수 목록에 90 추가
  student_scores["Alice"].push_back(85);  // Alice의 점수 목록에 85 추가
  student_scores["Bob"].push_back(78);    // Bob의 점수 목록에 78 추가
  student_scores["Bob"].push_back(82);    // Bob의 점수 목록에 82 추가
  student_scores["Bob"].push_back(88);    // Bob의 점수 목록에 88 추가

  // Alice의 점수를 출력
  print_scores(student_scores, "Alice");
  // Alice의 평균 점수를 출력
  print_average_score(student_scores, "Alice");

  // Bob의 점수를 출력
  print_scores(student_scores, "Bob");
  // Bob의 평균 점수를 출력
  print_average_score(student_scores, "Bob");

  // 존재하지 않는 학생 Charlie의 점수를 출력 시도
  print_scores(student_scores, "Charlie");
  // 존재하지 않는 학생 Charlie의 평균 점수를 출력 시도
  print_average_score(student_scores, "Charlie");

  return 0;
}