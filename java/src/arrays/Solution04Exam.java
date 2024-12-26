package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Solution04Exam {

    // 문제 출처 - [프로그래머스 - 모의고사](https://school.programmers.co.kr/learn/courses/30/lessons/42840)

    public static void main(String[] args) {
        int[][] inputs = {{ 1, 2, 3, 4, 5 }, {1, 3, 2, 4, 2}};
        for (int[] input :  inputs) {
            long start = System.currentTimeMillis();
            System.out.print("answers: ");
            System.out.print(Arrays.toString(input));
            System.out.print(", result: ");
            System.out.print(Arrays.toString(solution(input)));
            long end = System.currentTimeMillis();
            System.out.print(", 시간: " + (end - start) / 1000.0 + "초");
            System.out.println();
        }
    }

    public static int[] solution(int[] answers) {
        int[] candidate1 = {1, 2, 3, 4, 5};
        int[] candidate2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] candidate3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] scores = new int[3];

        for (int i = 0; i < answers.length; i++) {
            // 1. 1번 수포자 확인 후 정답일 시  + 1
            if (answers[i] == candidate1[i%candidate1.length]) {
                scores[0]++;
            }
            // 2. 2번 수포자 확인 후 정답일 시  + 1
            if (answers[i] == candidate2[i%candidate2.length]) {
                scores[1]++;
            }
            // 3. 3번 수포자 확인 후 정답일 시  + 1
            if (answers[i] == candidate3[i%candidate3.length]) {
                scores[2]++;
            }
        }

        int maxScore = IntStream.of(scores).max().getAsInt();
        List<Integer> tmps = new ArrayList<>();

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                tmps.add(i + 1);
            }
        }

        int[] result = new int[tmps.size()];
        for (int i = 0; i < tmps.size(); i++) {
            result[i] = tmps.get(i);
        }

        return result;

    }

    /*

    // 모범 답안

    public static int[] solution(int[] answers) {
        // 수포자들의 패턴
        int[][] pattern = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        // 수포자들의 점수를 저장할 배열
        int[] scores = new int[3];

        // 각 수포자의 패턴과 정답이 얼마나 일치하는지 확인
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < pattern.length; j++) {
                if (answers[i] == pattern[j][i % pattern[j].length]) {
                    scores[j]++;
                }
            }
        }

        // 가장 높은 점수 저장
        int maxScore = Arrays.stream(scores).max().getAsInt();

        // 가장 높은 점수를 가진 수포자들의ㅣ 번호를 찾아서 리스트에 담음
        ArrayList<Integer> answer = new ArrayList<>();

        // 가장 높은 점수를 가진 수포자들의 번호를 찾아서 리스트에 담음
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                answer.add(i + 1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

     */
}
