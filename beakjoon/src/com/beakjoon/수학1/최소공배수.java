package com.beakjoon.수학1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class 최소공배수 {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            String str = bufferedReader.readLine();
            int num = Integer.parseInt(str);
            while (num-- > 0) {
                String line = bufferedReader.readLine();
                StringTokenizer st = new StringTokenizer(line, " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int gcd = gcd(a, b);
                System.out.println(a * b / gcd);
            }


        } catch (Exception e) {
            System.out.println("e = " + e);
        }
    }

    public static int gcd(int a, int b) {
        int result = 1;
        for (int i = 2; i <= min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                result = i;
            }
        }
        return result;
    }
}
