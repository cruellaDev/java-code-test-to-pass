package queue;

import java.util.*;

public class Solution17CardStack {

    // 문제 출처: [프로그래머스 - 카드 뭉치](https://school.programmers.co.kr/learn/courses/30/lessons/159994)

    public static void main(String[] args) {
        String[] input1 = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        String[] input2 = {"string", "or", "integer"};
        String[] input3 = {"string", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        long start = System.currentTimeMillis();
        System.out.print("입력1: ");
        System.out.print(Arrays.toString(input1));
        System.out.print(", 입력2: ");
        System.out.print(Arrays.toString(input2));
        System.out.print(", 입력3: ");
        System.out.print(Arrays.toString(input3));
        System.out.print(", 출력: ");
        System.out.print(solution(input1, input2, input3));
        long end = System.currentTimeMillis();
        System.out.print(", 시간: " + (end - start) / 1000.0 + "초");
        System.out.println();
    }

    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> cardsX = new ArrayDeque<>(Arrays.asList(cards1));
        Queue<String> cardsY = new ArrayDeque<>(Arrays.asList(cards2));

        for (String g : goal) {
            if (!cardsX.isEmpty() && g.equals(cardsX.peek())) {
                cardsX.poll();
            } else if (!cardsY.isEmpty() && g.equals(cardsY.peek())) {
                System.out.println(cardsY.peek());
                cardsY.poll();
            } else {
                return "No";
            }
        }
        return "Yes";
    }

    /*
    // 모범 답안
    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        ArrayDeque<String> cardsDeque1 = new ArrayDeque<>(Arrays.asList(cards1));
        ArrayDeque<String> cardsDeque2 = new ArrayDeque<>(Arrays.asList(cards2));
        ArrayDeque<String> goalDeque = new ArrayDeque<>(Arrays.asList(goal));

        while (!goalDeque.isEmpty()) {
            if (!cardsDeque1.isEmpty() && cardsDeque1.peekFirst().equals(goalDeque.peekFirst())) {
                cardsDeque1.pollFirst();
                goalDeque.pollFirst();
            } else if (!cardsDeque2.isEmpty() && cardsDeque2.peekFirst().equals(goalDeque.peekFirst())) {
                cardsDeque2.pollFirst();
                goalDeque.pollFirst();
            } else {
                break;
            }
        }

        return goalDeque.isEmpty() ? "Yes" : "No";
    }

     */
}
