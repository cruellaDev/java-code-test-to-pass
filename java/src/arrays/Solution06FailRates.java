package arrays;

import java.util.Arrays;
import java.util.HashMap;

public class Solution06FailRates {

    // 문제 출처 - [프로그래머스 - 실패율](https://school.programmers.co.kr/learn/courses/30/lessons/42889)

    public static void main(String[] args) {
        int input1 = 5;
        int[] input2 = {2, 1, 2, 6, 2, 4, 3, 3};
        long start = System.currentTimeMillis();
        System.out.print("입력: ");
        System.out.print(input1);
        System.out.print(", ");
        System.out.print(Arrays.toString(input2));
        System.out.print(", 출력: ");
        System.out.print(Arrays.toString(solution(input1, input2)));
        long end = System.currentTimeMillis();
        System.out.print(", 시간: " + (end - start) / 1000.0 + "초");
        System.out.println();
    }

    public static int[] solution(int N, int[] stages) {
        double[] tried = new double[N + 1];
        double[] failed = new double[N + 1];

        for (int stage : stages) {
            for (int i = 0; i < stage; i++) {
                if (i + 1 <= stage) {
                    tried[i] += 1;
                }
                if (i + 1 == stage) {
                    failed[i] += 1;
                }
            }
        }

        double[][] failRate = new double[N][2];
        for (int i = 0; i < N; i++) {
            if (tried[i] == 0) {
                failRate[i][1] = i + 1;
                continue;
            }
            failRate[i][0] = Double.valueOf(failed[i] / tried[i]);
            failRate[i][1] = i + 1;
        }

        // 실패율 내림차순, 스테이지 번호 오름차순으로 정렬
        Arrays.sort(failRate, (a, b) -> {
            if (a[0] != b[0]) {
                return Double.compare(b[0], a[0]); // 실패율 내림차순
            }
            return Double.compare(a[1], b[1]); // 스테이지 번호 오름차순
        });

        // 정렬된 스테이지 번호만 추출
        return Arrays.stream(failRate)
                .mapToInt(x -> (int) x[1])
                .toArray();
    }

    /*

    // 모범 답안 - 시간 복잡도 - O(M + NlogN)

    public static int[] solution(int N, int[] stages) {
        // 1. 스테이지별 도전자 수를 구함
        int[] challenger = new int[N + 2];
        for (int stage : stages) {
            challenger[stage] += 1;
        }

        // 2. 스테이지 별 실패한 사용자 수 계산
        HashMap<Integer, Double> fails = new HashMap<>();
        double total = stages.length;

        // 3. 각 스테이지를 순회하며, 실패율 계산
        for (int i = 1; i <= N; i++) {
            if (challenger[i]== 0) { // 4. 도전한 사람이 없는 경우, 실패율은 0
                fails.put(i, 0.);
            } else {
                fails.put(i, challenger[i] / total); // 5. 시랲율 구함
                total -= challenger[i]; // 6. 다음 스테이지 실패율을 구하기 위해 현재 스테이지의 인원을 뺌
            }
        }

        return fails.entrySet().stream()
                .sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()))
                .mapToInt(HashMap.Entry::getKey)
                .toArray();
    }

     */
}
