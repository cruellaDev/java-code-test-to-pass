package stack;

import java.util.Arrays;
import java.util.Stack;

public class Solution13ClawMachine {

    // 문제 출처 - [프로그래머스 - 크레인 인형 뽑기 게임](https://school.programmers.co.kr/learn/courses/30/lessons/64061)

    public static void main(String[] args) {
        int[][] input1 = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] input2 = {1,5,3,5,1,2,1,4};
        long start = System.currentTimeMillis();
        System.out.print("입력1: ");
        System.out.print(Arrays.deepToString(input1));
        System.out.print(", 입력2: ");
        System.out.print(Arrays.toString(input2));
        System.out.print(", 출력: ");
        System.out.print(solution(input1, input2));
        long end = System.currentTimeMillis();
        System.out.print(", 시간: " + (end - start) / 1000.0 + "초");
        System.out.println();
    }

    public static int solution(int[][] board, int[] moves) {
        Stack<Integer> 바구니 = new Stack<>();
        int answer = 0;
        for (int move : moves) {
            int doll = 0;
            // 인형 위치 탐색
            for (int i=0, j=move-1;i < board.length; i++) {
                // 크레인으로 인형 가져오기
                if (board[i][j] != 0) {
                    doll = board[i][j];
                    board[i][j] = 0;
                    break;
                }
            }

            if (doll == 0) {
                continue;
            }

            // 인형 넣으면서 바구니 확인하기
            if (!바구니.isEmpty() && doll == 바구니.peek()) {
                바구니.pop();
                answer++;
            } else {
                바구니.push(doll);
            }
        }

        return answer * 2;
    }

    /*

    // 모범 답안
    public static int solution(int[][] board, int[] moves) {
        // 각 열에 대한 스택을 생성
        Stack<Integer>[] lanes = new Stack[board.length];
        for (int i = 0; i < lanes.length; i++) {
            lanes[i] = new Stack<>();
        }

        // board를 역순으로 탐색하며 각 열의 인형을 lanes에 추가함
        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length;j++) {
                if (board[i][j] > 0) {
                    lanes[j].push(board[i][j]);
                }
            }
        }

        // 인형을 담을 buckt 생성
        Stack<Integer> bucket = new Stack<>();

        // 사라진 인형의 총 개수를 저장할 변수 초기화
        int answer = 0;

        // moves 순회하여 각 열에서 인형 뽑아 bucket 추가
        for (int move : moves) {
            if (!lanes[move-1].isEmpty()) {
                int doll = lanes[move - 1].pop();
                if (!bucket.isEmpty() && bucket.peek() == doll) {
                    bucket.pop();
                    answer += 2;
                } else {
                    bucket.push(doll);
                }
            }
        }

        return answer;
    }

     */
}
