package stack;

import java.util.Arrays;
import java.util.Stack;

public class Solution12StockPrice {
    public static void main(String[] args) {
        int[] input = {1,6,9,5,3,2,7};
        long start = System.currentTimeMillis();
        System.out.print("입력: ");
        System.out.print(Arrays.toString(input));
        System.out.print(", 출력: ");
        System.out.print(Arrays.toString(solution(input)));
        long end = System.currentTimeMillis();
        System.out.print(", 시간: " + (end - start) / 1000.0 + "초");
        System.out.println();
    }

    public static int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < n; i++) {
            // 가격이 떨어졌을 때
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int j = stack.pop();
                answer[j] = i - j;
            }
            stack.push(i);
        }

        // 가격이 떨어지지 않았을 때
        while (!stack.isEmpty()) {
            int j = stack.pop();
            answer[j] = n - 1 - j;
        }
        return answer;
    }
}
