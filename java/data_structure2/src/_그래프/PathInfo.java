package _그래프;

// 경로 정보를 저장하는 내부 클래스
public class PathInfo {

  int distance;

  WeightedGraphCity previousCity;

  public PathInfo(int distance, WeightedGraphCity previousCity) {
    this.distance = distance;
    this.previousCity = previousCity;
  }

  public int getDistance() {
    return distance;
  }

  public WeightedGraphCity getPreviousCity() {
    return previousCity;
  }

  @Override
  public String toString() {
    return "PathInfo{" +
        "distance=" + distance +
        ", previousCity=" + previousCity +
        '}';
  }
}
