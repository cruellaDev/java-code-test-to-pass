package arrays;

import java.util.Arrays;

public class Solution05MultiplyMatrix {
    public static void main(String[] args) {
        int[][] input1 = {{ 1, 4 }, {3, 2}, { 4, 1 }};
        int[][] input2 = {{ 3, 3 }, {3, 3}};
        long start = System.currentTimeMillis();
        System.out.print("입력: ");
        System.out.print(Arrays.deepToString(input1));
        System.out.print(", ");
        System.out.print(Arrays.deepToString(input2));
        System.out.print(", 출력: ");
        System.out.print(Arrays.deepToString(solution(input1, input2)));
        long end = System.currentTimeMillis();
        System.out.print(", 시간: " + (end - start) / 1000.0 + "초");
        System.out.println();

    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] result = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                for (int k = 0; k < arr2.length; k++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return result;
    }
}
