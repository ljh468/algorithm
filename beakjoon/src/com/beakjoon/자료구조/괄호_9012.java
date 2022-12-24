package com.beakjoon.자료구조;

import java.io.*;
import java.util.Stack;

public class 괄호_9012 {
    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))){

            String str = bufferedReader.readLine();
            int num = Integer.parseInt(str);

            while (num-- > 0) {
                String input = bufferedReader.readLine();
                bufferedWriter.write(vps(input) + "\n");
                stack.clear();
            }
            bufferedWriter.flush();
        } catch (IOException ioException) {
            System.out.println("ioException = " + ioException);
        }
    }

    private static String vps(String str) {
        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (stack.empty()) {
                return "NO";
            } else {
                stack.pop();
            }
        }

        if (stack.empty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
