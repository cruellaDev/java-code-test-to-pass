package queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution15JosephusProblem {
    public static void main(String[] args) {
        int input1 = 5;
        int input2 = 2;
        long start = System.currentTimeMillis();
        System.out.print("입력1: ");
        System.out.print(input1);
        System.out.print(", 입력2: ");
        System.out.print(input2);
        System.out.print(", 출력: ");
        System.out.print(solution(input1, input2));
        long end = System.currentTimeMillis();
        System.out.print(", 시간: " + (end - start) / 1000.0 + "초");
        System.out.println();
    }

    public static int solution(int N, int K) {
        int answer = 1;

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        int counter = 1;
        while (!queue.isEmpty()) {
            int first = queue.poll();
            if (counter == K) {
                answer = first;
                counter = 1;
            } else {
                queue.add(first);
                counter++;
            }
        }
        return answer;
    }
}
