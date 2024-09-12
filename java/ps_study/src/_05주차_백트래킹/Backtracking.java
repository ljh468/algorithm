package _05주차_백트래킹;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 상태 정의 : 문제의 각 단계에서 가능한 상태를 정의
 * 유망 함수(isPromising) : 현재 상태가 유망한지 판단, 유망하지 않으면 더 이상 탐색 x
 * 해결책 확인(isSolution) : 현재 상태가 문제의 해결책인지 판단
 * 재귀 호출 : 유망한 상태로 이동하면서 문제 해결
 *
 */
public class Backtracking {

  // State 클래스는 문제에 따라 정의됩니다.
  class State {
    // 문제의 상태를 저장할 멤버 변수를 정의
    // 예: 경로, 선택된 값, 배열 등

    // 필요한 상태 생성자 및 메서드를 정의
  }

  // 유망성 판단 함수
  boolean isPromising(int level, State state) {
    // 현재 상태가 유망한지 판단하는 로직을 구현합니다.
    return true; // 임시로 true 반환
  }

  // 해결책 확인 함수
  boolean isSolution(State state) {
    // 현재 상태가 문제의 해결책인지 판단하는 로직을 구현합니다.
    return false; // 임시로 false 반환
  }

  // 해결책을 처리하는 함수
  void processSolution(State state) {
    // 해결책을 처리하는 로직을 구현합니다.
    System.out.println("Solution found: " + state);
  }

  // 가능한 다음 상태를 반환하는 함수
  List<State> possibleStates(State state) {
    // 현재 상태에서 가능한 다음 상태들을 리스트로 반환합니다.
    List<State> nextStates = new ArrayList<>();
    // 상태 생성 및 추가
    return nextStates;
  }

  // 백트래킹 함수
  void backtrack(int level, State state) {
    // 현재 상태가 해결책이면 처리
    if (isSolution(state)) {
      processSolution(state);
      return;
    }

    // 다음 가능한 상태를 탐색
    for (State nextState : possibleStates(state)) {
      if (isPromising(level, nextState)) {
        backtrack(level + 1, nextState);  // 재귀 호출로 다음 상태 탐색
      }
    }
  }

}
