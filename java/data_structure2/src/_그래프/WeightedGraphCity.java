package _그래프;

import java.util.HashMap;
import java.util.Map;

public class WeightedGraphCity {

  private final String name; // 도시이름

  private final Map<String, Integer> adjacentCities; // 인접한 도시들을 저장하는 변수(key는 도시이름, value는 거리)

  public WeightedGraphCity(String name) {
    this.name = name;
    this.adjacentCities = new HashMap<>();
  }

  public String getName() {
    return name;
  }

  public Map<String, Integer> getAdjacentCities() {
    return adjacentCities;
  }

  public void addAdjacentCity(WeightedGraphCity city, int distance) {
    this.adjacentCities.put(city.getName(), distance);
  }

  public void removeAdjacentCity(WeightedGraphCity city) {
    this.adjacentCities.remove(city.getName());
  }

  @Override
  public String toString() {
    return "WeightedGraphCity{" +
        "name='" + name + '\'' +
//        ", adjacentCities=" + adjacentCities +
        '}';
  }
}
