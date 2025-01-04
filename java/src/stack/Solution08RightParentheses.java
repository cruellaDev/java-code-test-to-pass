package stack;

import java.util.Stack;

public class Solution08RightParentheses {

    public static void main(String[] args) {
        String input = "(())()";
        long start = System.currentTimeMillis();
        System.out.print("입력: ");
        System.out.print(input);
        System.out.print(", 출력: ");
        System.out.print(solution(input));
        long end = System.currentTimeMillis();
        System.out.print(", 시간: " + (end - start) / 1000.0 + "초");
        System.out.println();
    }

    public static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.add(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
