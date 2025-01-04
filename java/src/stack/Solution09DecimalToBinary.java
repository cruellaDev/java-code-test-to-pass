package stack;

import java.util.Stack;

public class Solution09DecimalToBinary {
    public static void main(String[] args) {
        int input = 27;
        long start = System.currentTimeMillis();
        System.out.print("입력: ");
        System.out.print(input);
        System.out.print(", 출력: ");
        System.out.print(solution(input));
        long end = System.currentTimeMillis();
        System.out.print(", 시간: " + (end - start) / 1000.0 + "초");
        System.out.println();
    }

    /*
    // Long 이 제공해주는 메소드 활용하기
    public static String solution(int decimal) {
        return Long.toBinaryString(decimal);
    }
     */

    public static String solution(int decimal) {
        Stack<Integer> stack = new Stack<>();
        while (decimal > 0) {
            int div = decimal / 2;
            int mod = decimal % 2;
            stack.push(mod);
            decimal = div;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
