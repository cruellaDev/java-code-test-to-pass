package stack;

import java.util.Arrays;
import java.util.Stack;

public class Solution14EditTable {

    // 문제 출처 - [프로그래머스 - 표 편집](https://school.programmers.co.kr/learn/courses/30/lessons/81303)

    public static void main(String[] args) {
        int input1 = 8;
        int input2 = 2;
        String[] input3 = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
        long start = System.currentTimeMillis();
        System.out.print("입력: ");
        System.out.print(input1);
        System.out.print(", ");
        System.out.print(input2);
        System.out.print(", ");
        System.out.print(Arrays.toString(input3));
        System.out.print(", 출력: ");
        System.out.print(solution(input1, input2, input3));
        long end = System.currentTimeMillis();
        System.out.print(", 시간: " + (end - start) / 1000.0 + "초");
        System.out.println();
    }

    public static String solution(int n, int k, String[] cmd) {
        // 삭제된 행의 인덱스를 저장하는 스택 생성
        Stack<Integer> deleted = new Stack<>();

        // 배열을 그대로 사용
        // 각 행을 기준으로 연산에 따른 위치를 표시하기 위한 배열
        int[] up = new int[n + 2];
        int[] down = new int[n + 2];

        for (int i = 0; i < n + 2; i++) {
            up[i] = i - 1;
            down[i] =i + 1;
        }

        // 현재 위치
        k++;



        // cmd 해석 및 적용
        for (String c: cmd) {
            if (c.startsWith("C")) {
                // 현재 위치 삭제
                deleted.push(k);
                up[down[k]] = up[k];
                down[up[k]] = down[k];
                // 그 다음 위치로 이동
                k = n < down[k] ? up[k] : down[k];
            } else if (c.startsWith("Z")) {
                // 가장 최근에 삭제된 행 보완
                int restore = deleted.pop();
                down[up[restore]] = restore;
                up[down[restore]] = restore;
            } else {
                // 현재 위치 이동
                String[] s = c.split(" ");
                int x = Integer.parseInt(s[1]);
                for (int i = 0; i < x; i++) {
                    k = s[0].equals("U") ? up[k] : down[k];
                }
            }
        }

        // OX 표시
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');

        for (int i : deleted) {
            answer[i - 1] = 'X';
        }

        return new String(answer);
    }
}
