package _그래프;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dijkstra {

  // 모든 도시를 저장할 변수
  private final Map<String, WeightedGraphCity> allCities;

  public Dijkstra() {
    this.allCities = new HashMap<>();
  }

  // 도시를 추가하는 registerCity 메서드
  void registerCity(WeightedGraphCity city) {
    this.allCities.put(city.getName(), city);
  }

  // 최단 경로를 계산하는 shortestPath 메서드
  void shortestPath(WeightedGraphCity startCity, WeightedGraphCity endCity) {

    // 만약 시작도시가 등록되어 있지 않다면, 거리계산이 불가능 하므로 함수종료
    if (allCities.containsKey(startCity.getName()) == false) {
      System.out.println("출발 도시가 등록되어 있지 않습니다.");
      return;
    }

    // 만약 도착도시가 등록되어 있지 않다면, 거리계산이 불가능 하므로 함수종료
    if (allCities.containsKey(endCity.getName()) == false) {
      System.out.println("도착 도시가 등록되어 있지 않습니다.");
      return;
    }

    // 방문한 도시를 저장할 변수
    List<String> visitedCities = new ArrayList<>();

    // 방문하지 않은 도시를 저장할 변수
    List<String> unvisitedCities = new ArrayList<>();

    // 최단 경로 테이블
    // Map<String, Integer> shortestPathTable = new HashMap<>();
    // 최단 경로 테이블 (거리와 이전 도시 정보를 저장)
    Map<String, PathInfo> shortestPathTable = new HashMap<>();

    // 최단거리 테이블에 도시들의 최단거리와 이전 방문도시 초기화 & 방문한 도시 테이블은 false로 초기화
    for (String cityName : allCities.keySet()) {
      // shortestPathTable.put(cityName, Integer.MAX_VALUE);
      shortestPathTable.put(cityName, new PathInfo(Integer.MAX_VALUE, null));
      unvisitedCities.add(cityName);
    }

    // 시작 도시의 거리를 0으로 설정
    // shortestPathTable.put(startCity.getName(), 0);
    shortestPathTable.put(startCity.getName(), new PathInfo(0, null));

    // 방문하지 않은 도시중에서 가장 가까운 도시 찾기
    while (unvisitedCities.isEmpty() == false) {
      String closestCityName = null;
      for (String cityName : unvisitedCities) {
        // closestCityName가 null이면 현재 순회하는 도시를 가장 가까운 도시로 설정
        // 테이블에 등록된 가장 가까운 도시보다 현재 순회하는 도시가 가깝다면 현재 순회하는 도시를 가장 가까운 도시로 업데이트
        if (closestCityName == null ||
            (shortestPathTable.get(cityName).getDistance() < shortestPathTable.get(closestCityName).getDistance())) {
          closestCityName = cityName;
        }
      }

      // 모든 도시가 방문되었거나 도달할 수 없는 경우
      if (closestCityName == null) break;

      // closestCityName(가장 가까운 도시)을 방문한 도시에 등록
      visitedCities.add(closestCityName);
      // closestCityName(가장 가까운 도시)을 방문하지 않은 도시에서 제거
      unvisitedCities.remove(closestCityName);

      // 방문한 도시의 인접도시들을 순회
      WeightedGraphCity currentCity = allCities.get(closestCityName);
      for (Map.Entry<String, Integer> entry : currentCity.getAdjacentCities().entrySet()) {
        String adjacentCityName = entry.getKey();
        int distance = entry.getValue();

        // 만약 인접도시를 이미 방문했다면, 다음 인접도시로 넘어감
        if (visitedCities.contains(adjacentCityName)) {
          continue;
        }

        // 출발도시에서 방문한 도시까지 오는 최단거리 + 방문한 도시에서 인접도시까지의 거리
        int newDist = shortestPathTable.get(closestCityName).getDistance() + distance;

        // 출발도시에서 현재도시를 거쳐 인접도시로 가는 거리가 최단거리 테이블에 저장된 거리보다 더 짧다면 최단거리 테이블을 업데이트
        if (newDist < shortestPathTable.get(adjacentCityName).getDistance()) {
          shortestPathTable.put(adjacentCityName, new PathInfo(newDist, currentCity));
        }
      }
    }

    // 최단 경로를 출력
    String pathString = showShortestPathRecursively(endCity.getName(), shortestPathTable);
    System.out.println("최단 경로: " + pathString);
    System.out.println("최단 경로 테이블: " + shortestPathTable);
    System.out.println("출발도시(" + startCity.getName() + ")에서 도착도시(" + endCity.getName() + ")까지의 최단 거리: " + shortestPathTable.get(endCity.getName()).distance);
  }

  // 재귀적으로 최단 경로를 출력하는 메서드
  private String showShortestPathRecursively(String destinationCityName,
                                             Map<String, PathInfo> shortestPathTable) {
    // 기저 조건
    PathInfo pathInfo = shortestPathTable.get(destinationCityName);
    if (pathInfo.previousCity == null) {
      return destinationCityName;
    }
    String pathString = showShortestPathRecursively(pathInfo.previousCity.getName(), shortestPathTable);
    pathString += " -> " + destinationCityName;
    return pathString;
  }

  public static void main(String[] args) {
    // Dijkstra 인스턴스 생성
    Dijkstra dijkstra = new Dijkstra();

    // 도시 인스턴스 생성
    WeightedGraphCity seoul = new WeightedGraphCity("서울");
    WeightedGraphCity wonju = new WeightedGraphCity("원주");
    WeightedGraphCity gangneung = new WeightedGraphCity("강릉");
    WeightedGraphCity daejeon = new WeightedGraphCity("대전");
    WeightedGraphCity jeonju = new WeightedGraphCity("전주");
    WeightedGraphCity daegu = new WeightedGraphCity("대구");

    // 도시 등록
    dijkstra.registerCity(seoul);
    dijkstra.registerCity(wonju);
    dijkstra.registerCity(gangneung);
    dijkstra.registerCity(daejeon);
    dijkstra.registerCity(jeonju);
    dijkstra.registerCity(daegu);

    // 서울 연결
    seoul.addAdjacentCity(wonju, 87);
    seoul.addAdjacentCity(gangneung, 165);
    seoul.addAdjacentCity(daejeon, 140);
    seoul.addAdjacentCity(jeonju, 187);

    // 원주 연결
    wonju.addAdjacentCity(seoul, 87);
    wonju.addAdjacentCity(gangneung, 95);
    wonju.addAdjacentCity(daejeon, 118);
    wonju.addAdjacentCity(daegu, 178);

    // 강릉 연결
    gangneung.addAdjacentCity(seoul, 165);
    gangneung.addAdjacentCity(wonju, 95);
    gangneung.addAdjacentCity(daegu, 212);

    // 대전 연결
    daejeon.addAdjacentCity(seoul, 140);
    daejeon.addAdjacentCity(wonju, 118);
    daejeon.addAdjacentCity(jeonju, 56);
    daejeon.addAdjacentCity(daegu, 122);

    // 전주 연결
    jeonju.addAdjacentCity(seoul, 187);
    jeonju.addAdjacentCity(daejeon, 56);
    jeonju.addAdjacentCity(daegu, 130);

    // 대구 연결
    daegu.addAdjacentCity(wonju, 178);
    daegu.addAdjacentCity(gangneung, 212);
    daegu.addAdjacentCity(daejeon, 122);
    daegu.addAdjacentCity(jeonju, 130);

    // 최단 경로 계산
    // 서울 -> 대구
    dijkstra.shortestPath(seoul, daegu);
    System.out.println();
    // 강릉 -> 전주
    dijkstra.shortestPath(gangneung, jeonju);
  }

}