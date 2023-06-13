package com.beakjoon.자료구조;

import java.io.*;
import java.util.Stack;

public class 스택수열_1874 {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {

            String str = bufferedReader.readLine();
            int num = Integer.parseInt(str);

            Stack<Integer> stack = new Stack<>();
            StringBuilder stringBuilder = new StringBuilder();
            int start = 0;
            while (num-- > 0) {
                int value = Integer.parseInt(bufferedReader.readLine());
                if (value > start) {
                    for (int i = start + 1; i <= value; i++) {
                        stack.push(i);
                        stringBuilder.append("+").append("\n");
                    }
                    //다음 push 할 때의 오름차순을 유지하기 위한 변수 초기화
                    start = value;
                } else if(stack.peek() > value){
                    stringBuilder.setLength(0);
                    stringBuilder.append("NO");
                    break;
                }
                stack.pop();
                stringBuilder.append("-").append("\n");
            }
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.flush();
        } catch (IOException ioException) {
            System.out.println("ioException = " + ioException);
        }
    }
}
