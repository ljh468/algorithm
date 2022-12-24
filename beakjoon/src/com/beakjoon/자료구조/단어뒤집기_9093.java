package com.beakjoon.자료구조;

import java.io.*;
import java.util.Stack;

public class 단어뒤집기_9093 {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))){

            String str = bufferedReader.readLine();
            int num = Integer.parseInt(str);

            Stack<Character> stack = new Stack<>();
            while(num-- > 0) {
                String input = bufferedReader.readLine()+"\n";
                for(char ch : input.toCharArray()) {
                    if(ch == ' ' || ch == '\n') {
                        while(!stack.isEmpty()) {
                            bufferedWriter.write(stack.pop());
                        }
                        bufferedWriter.write(ch); // 공백
                    } else
                        stack.push(ch);
                }
            }
            bufferedWriter.flush();
        } catch (IOException ioException) {
            System.out.println("ioException = " + ioException);
        }
    }
}
