package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

public class Solution02ControlArray {

    public static void main(String[] args) {
        int[][] inputs = {{ 4, 2, 2, 1, 3, 4 }, {2, 1, 1, 3, 2, 5, 4}};
        for (int[] input :  inputs) {
            long start = System.currentTimeMillis();
            System.out.print("입력: ");
            System.out.print(Arrays.toString(input));
            System.out.print(", 출력: ");
            System.out.print(Arrays.toString(solution(input)));
            long end = System.currentTimeMillis();
            System.out.print(", 시간: " + (end - start) / 1000.0 + "초");
            System.out.println();
        }
    }

    public static int[] solution(int[] arr) {
        return Arrays.stream(arr).boxed()
                .distinct() // 1. 중복값 없애기
                .sorted(Comparator.reverseOrder()) // 2. 내림차순 정렬하기
                .mapToInt(Integer::intValue)
                .toArray();
    }

    /*

    // TreeSet을 사용해 O(NlogN)으로 구현하기
    public static int[] solution(int[] arr) {
        // 1. 내림차순 정렬 - 시간 복잡도: O(NlogN)
        // 2.중복값 제거- 시간 복잡도 - 시간 복잡도: O(N)
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for (int num: arr) {
            set.add(num);
        }

        // int형배열에 담아서 반환
        int[] result = new int[set.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = set.pollFirst();
        }
        return result;
    }
     */
}
