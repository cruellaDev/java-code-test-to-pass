package stack;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Solution10RotateParentheses {
    public static void main(String[] args) {
        String input = "[]{}()";
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
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            // 임시로 괄호를 담을 stack 생성
            Stack<Character> stack = new Stack<>();
            // 치환시킬 char array 생성
            char[] array = new char[s.length()];
            // 왼쪽으로 돌리기
            for (int j = 0; j < s.length(); j++) {
                array[(j + s.length() - 1) % s.length()] = s.charAt(j);
            }
            s = String.valueOf(array);
            for (char a : array) {
                if (a == '[' || a == '{' || a == '(') {
                    stack.add(a);
                } else if (a == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        stack.add(a);
                    }
                } else if (a == '}') {
                    if (!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    } else {
                        stack.add(a);
                    }
                } else if (a == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.add(a);
                    }
                }
            }
            // stack 이 비어있으면 answer++
            if (stack.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }

    record Sd() {

    }

    /*
    // 모범답안
    public static int solution(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        int n = s.length();
        s += s;
        int answer = 0;

        A: for (int i = 0; i < n; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            for (int j = i; j < i + n; j++) {
                char c = s.charAt(j);
                if (!map.containsKey(c)) {
                    stack.push(c);
                }
                else {
                    if(stack.isEmpty() || !stack.pop().equals(map.get(c))) {
                        continue A;
                    }
                }
            }
            if (stack.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }

     */
}
