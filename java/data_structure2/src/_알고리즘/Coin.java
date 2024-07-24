package _알고리즘;

import java.util.ArrayList;
import java.util.List;

public class Coin {

  private final int won;

  private int count;

  public Coin(int won) {
    this.won = won;
    this.count = 0;
  }

  public int getWon() {
    return won;
  }

  public int getCount() {
    return count;
  }

  public void incrementCount() {
    this.count++;
  }

  public static void changeCoin(int money) {
    System.out.println(money + "원 거슬러주기");

    // 큰 금액의 동전부터 작은 금액의 동전 순서대로 저장
    List<Coin> coins = new ArrayList<>();
    coins.add(new Coin(500));
    coins.add(new Coin(100));
    coins.add(new Coin(50));
    coins.add(new Coin(10));

    // 각 동전에 대해 거스름돈을 계산 (큼 금액의 동전부터 계산)
    for (Coin coin : coins) {
      while (coin.getWon() <= money) {
        coin.incrementCount();
        money -= coin.getWon();
      }
    }

    System.out.println(coins);
  }

  @Override
  public String toString() {
    return "Coin{" +
        "won=" + won +
        ", count=" + count +
        '}';
  }

  public static void main(String[] args) {
    changeCoin(2380);
  }
}