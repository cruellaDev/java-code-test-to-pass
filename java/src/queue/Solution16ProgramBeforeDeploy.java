package queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution16ProgramBeforeDeploy {

    // 문제 출처 - [프로그래머스- 기능개발](https://school.programmers.co.kr/learn/courses/30/lessons/42586)

    public static void main(String[] args) {
        int[] input1 = {95, 90, 99, 99, 80, 99};
        int[] input2 = {1, 1, 1, 1, 1, 1, 1};
        long start = System.currentTimeMillis();
        System.out.print("입력1: ");
        System.out.print(Arrays.toString(input1));
        System.out.print(", 입력2: ");
        System.out.print(Arrays.toString(input2));
        System.out.print(", 출력: ");
        System.out.print(Arrays.toString(solution(input1, input2)));
        long end = System.currentTimeMillis();
        System.out.print(", 시간: " + (end - start) / 1000.0 + "초");
        System.out.println();
    }

    // 내 풀이
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[101];
        int day = 0;
        int index = 0;

        while (index != progresses.length) {
            if (progresses[index] >= 100) {
                days[day]++;
                index++;
            } else {
                for (int i = 0; i < progresses.length; i++) {
                    progresses[i] += speeds[i];
                }
                day++;
            }
        }
        return Arrays.stream(days).filter(i -> i > 0).toArray();
    }

    /*
    // 모범답안
    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> answer = new ArrayDeque<>();

        int n = progresses.length;
        // 1. 각 작업의 배포 가능일 계산
        int[] daysLeft = new int[n];
        for (int i = 0;i < n;i++) {
            daysLeft[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }

        int count = 0; // 배포될 작업 수의 카운트
        int maxDay = daysLeft[0]; // 현재 배포될작업 중 가장 늦게 배포될 작업의 가능일

        for (int i = 0; i < n;i++) {
            if (daysLeft[i] <= maxDay) { // 배포 가능일이 가장 늦은 배포일보다 빠르면
                count++;
            } else { // 배포 예정일이 기준 배포일보다 느리면
                answer.add(count);
                count = 1;
                maxDay = daysLeft[i];
            }
        }

        answer.add(count); // 마지막으로 카운트된 작업들으르 함께 배포

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
     */
}
