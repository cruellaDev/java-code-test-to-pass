package arrays;

import java.util.Arrays;

public class Solution01SortArray {

    public static void main(String[] args) {
        int[][] inputs = {{ 1, -5, 2, 4, 3 }, {2, 1, 1, 3, 2, 5, 4}, {6, 1, 7}};
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
        // sort() API는 O(NlogN)의 시간복잡도를 가진다.
        Arrays.sort(arr);
        return arr;
    }

    /*

    // 배열의 최대 길이가 10^5 이므로 제한 시간이 3초일 경우 시간복잡도가 O(N^2)인 아래 식 사용할 수 없음
    public static int[] solution(int[] arr) {
        // bubble sort 사용
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

     */

}
