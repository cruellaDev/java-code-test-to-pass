package arrays;

import java.util.Arrays;
import java.util.Stack;

public class Extra01Bus {
    // 문제 출처 - [프로그래머스 PCCE - 버스](https://school.programmers.co.kr/learn/courses/30/lessons/340201)

    public static void main(String[] args) {
        int input1 = 5;
        String[][] input2 = {{"On", "On", "On"}, {"Off", "On", "-"}, {"Off", "-", "-"}};
        long start = System.currentTimeMillis();
        System.out.print("입력1: ");
        System.out.print(input1);
        System.out.print(", 입력2: ");
        System.out.print(Arrays.deepToString(input2));
        System.out.print(", 출력: ");
        System.out.print(solution(input1, input2));
        long end = System.currentTimeMillis();
        System.out.print(", 시간: " + (end - start) / 1000.0 + "초");
        System.out.println();
    }

    public static int solution(int seat, String[][] passengers) {
        Stack<String> stack = new Stack<>();

        for (String[] passenger : passengers) {
            for (String p : passenger) {
                if (p.equals("On")) {
                    stack.push(p);
                } else if (p.equals("Off") && !stack.isEmpty()) {
                    stack.pop();
                }
            }
        }

        return Math.max(0, seat - stack.size());
    }
}
