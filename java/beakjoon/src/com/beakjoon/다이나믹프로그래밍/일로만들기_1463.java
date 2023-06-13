package com.beakjoon.다이나믹프로그래밍;

import java.io.*;

public class 일로만들기_1463 {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))){
            String str = bufferedReader.readLine();
            int num = Integer.parseInt(str);

            int[] arr = new int[num + 1];
            for (int i = 2; i <= num; i++) {
                // 1을 빼는 경우
                arr[i] = arr[i-1] + 1;

                // 2로 나누어 떨어지는 경우
                if (i % 2 == 0) {
                    arr[i] = Math.min(arr[i], arr[i / 2] + 1);
                }
                // 3로 나누어 떨어지는 경우
                if (i % 3 == 0) {
                    arr[i] = Math.min(arr[i], arr[i / 3] + 1);
                }
            }
            bufferedWriter.write(arr[num] + "\n");
            bufferedWriter.flush();
        } catch (IOException ioException) {
            System.out.println("ioException = " + ioException);
        }
    }
}
