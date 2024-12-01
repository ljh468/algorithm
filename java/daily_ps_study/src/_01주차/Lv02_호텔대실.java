package _01주차;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/155651
public class Lv02_호텔대실 {

  public static void main(String[] args) {
    String[][] book_time = {
        {"15:00", "17:00"},
        {"16:40", "18:20"},
        {"14:20", "15:20"},
        {"14:10", "19:20"},
        {"18:20", "21:20"}
    };

    int result = solution(book_time);
    System.out.println("result = " + result);
  }

  public static int solution(String[][] book_time) {
    List<Room> rooms = new ArrayList<>();

    // 1. 문자열로 된 시간을 정수형으로 변경
    int[][] bookTime = new int[book_time.length][2];
    for (int i = 0; i < book_time.length; i++) {
      int start = Integer.parseInt(book_time[i][0].replace(":", ""));
      int end = Integer.parseInt(book_time[i][1].replace(":", ""));

      end += 10;
      if (end % 100 >= 60) {
        end += 40;
      }

      bookTime[i][0] = start;
      bookTime[i][1] = end;

    }

    // 2. 시작시간을 기준으로 정렬
    Arrays.sort(bookTime, Comparator.comparingInt(a -> a[0]));

    // 3. 예약을 순회하면서 룸에 배정
    for (int[] time : bookTime) {
      ReservationTime newReservation = new ReservationTime(time[0], time[1]);

      // 3-1. 룸 순회하면서 예약 가능하면 추가
      boolean added = false;
      for (Room room : rooms) {
        added = room.add(newReservation);
        if (added) {
          break;
        }
      }

      // 3-2. 모든 방에 추가 불가능하면 새 방 생성
      if (!added) {
        Room newRoom = new Room(newReservation);
        rooms.add(newRoom);
      }
    }

    return rooms.size();
  }

}

class Room {

  private int endTime; // 현재 방의 마지막 예약 종료 시간

  public Room(ReservationTime reservationTime) {
    this.endTime = reservationTime.end;
  }

  // 새로운 예약을 방에 추가할 수 있는지 확인하고 가능하면 추가
  public boolean add(ReservationTime reservationTime) {
    // 새로운 예약의 시작 시간이 현재 예약 종료 시간(청소시간 포함) 이후라면 추가 가능
    if (reservationTime.start >= this.endTime) {
      this.endTime = reservationTime.end; // 종료 시간 업데이트
      return true;
    }
    return false;
  }
}

class ReservationTime {
  int start;
  int end;

  public ReservationTime(int start, int end) {
    this.start = start;
    this.end = end;
  }
}
