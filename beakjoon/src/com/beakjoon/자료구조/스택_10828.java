package com.beakjoon.자료구조;

import java.io.*;
import java.util.Stack;

public class 스택_10828 {
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))){

            String str = bufferedReader.readLine();
            int num = Integer.parseInt(str);

            for (int i = 1; i <= num; i++) {
                String line = bufferedReader.readLine();
                Integer result = setStack(line);
                if (result != null) {
                    bufferedWriter.write(result + "\n");//출력
                }
            }
            bufferedWriter.flush();
        } catch (IOException ioException) {
            System.out.println("ioException = " + ioException);
        }
    }

    public static Integer setStack(String line) {
        String[] s = line.split(" ");
        switch (s[0]) {
            case "push":
                stack.push(Integer.parseInt(s[1]));
                break;
            case "pop":
                if (stack.empty()) {
                    return -1;
                } else {
                    return stack.pop();
                }
            case "size":
                return stack.size();
            case "empty":
                if (stack.empty()) {
                    return 1;
                } else {
                    return 0;
                }
            case "top":
                if (stack.empty()) {
                    return -1;
                } else {
                    return stack.peek();
                }
        }
        return null;
    }
}
