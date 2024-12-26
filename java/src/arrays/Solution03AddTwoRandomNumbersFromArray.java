package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution03AddTwoRandomNumbersFromArray {

    // 문제 출처: [프로그래머스 - 두 개 뽑아서 더하기](https://school.programmers.co.kr/learn/courses/30/lessons/68644)

    public static void main(String[] args) {
        int[][] inputs = {{ 2, 1, 3, 4, 1 }, {5, 0, 2, 7}};
        for (int[] input :  inputs) {
            long start = System.currentTimeMillis();
            System.out.print("numbers: ");
            System.out.print(Arrays.toString(input));
            System.out.print(", result: ");
            System.out.print(Arrays.toString(solution(input)));
            long end = System.currentTimeMillis();
            System.out.print(", 시간: " + (end - start) / 1000.0 + "초");
            System.out.println();
        }
    }

    public static int[] solution(int[] numbers) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i != j) {
                    // result 에 두 수를 더한 값 추가
                    result.add(numbers[i] + numbers[j]);
                }
            }
        }

        // result 중복제거 후 오름차순 정렬
        return result.stream()
                .distinct()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    /*

    // 모범 답안 - 시간 복잡도: O(N^2log(N^2))

    public int[] solution(int[] numbers) {
        // 중복값 제거를 위한 해시셋 생성
        HashSet<Integer> result = new HashSet<Integer>();
        // 두 수를 선택하는 모든 경우의 수를 반복문으로 구함
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                // 두 수를 더한 결과를 해시셋에 추가
                result.add(numbers[i] + numbers[j]);
            }
        }
        // 해시셋의 값을 오름차순 정렬하고 int[] 형태의 배열로 반환
        return result.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
     */
}
