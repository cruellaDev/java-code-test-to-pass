package stack;

import java.util.Stack;

public class Solution11RemovePair {
    public static void main(String[] args) {
        String input = "baabaa";
        long start = System.currentTimeMillis();
        System.out.print("입력: ");
        System.out.print(input);
        System.out.print(", 출력: ");
        System.out.print(solution(input));
        long end = System.currentTimeMillis();
        System.out.print(", 시간: " + (end - start) / 1000.0 + "초");
        System.out.println();
    }

    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }
            char prev = stack.peek();
            if (prev == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

    /*
    // 모범답안
    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

     */
}
