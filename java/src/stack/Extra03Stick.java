package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Extra03Stick {

    // 문제 출처: [백준 - 막대기](https://www.acmicpc.net/problem/17608)

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int h  = Integer.parseInt(bufferedReader.readLine());
            while (!stack.isEmpty() && h > stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty() || h < stack.peek()) {
                stack.push(h);
            }
        }
        System.out.println(stack.size());
    }
}
