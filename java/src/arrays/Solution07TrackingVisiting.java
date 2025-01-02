package arrays;

import java.util.HashMap;
import java.util.HashSet;

public class Solution07TrackingVisiting {

    // 문제 출처 - [프로그래머스 - 방문길이](https://school.programmers.co.kr/learn/courses/30/lessons/49994)

    public static void main(String[] args) {
        String input1 = "LULLLLLLU";
        long start = System.currentTimeMillis();
        System.out.print("입력: ");
        System.out.print(input1);
        System.out.print(", 출력: ");
        System.out.print(solution(input1));
        long end = System.currentTimeMillis();
        System.out.print(", 시간: " + (end - start) / 1000.0 + "초");
        System.out.println();
    }

    public static int solution(String dirs) {
        // direction
        HashMap<Character, int[]> directions = new HashMap<>();
        directions.put('U', new int[]{0, 1});
        directions.put('D', new int[]{0, -1});
        directions.put('R', new int[]{1, 0});
        directions.put('L', new int[]{-1, 0});

        int max = 10;
        int min = 0;

        int prevX = 5;
        int prevY = 5;

        HashSet<String> answer = new HashSet<>();

        // 1. for 문
        for (int i = 0; i < dirs.length(); i++) {
            // 1. next = prev + direction
            char dir = dirs.charAt(i);
            int[] direction = directions.get(dir);
            int nextX = prevX + direction[0];
            int nextY = prevY + direction[1];

            // 2. 0보다 작을 경우 혹은 10보다 클 경우 continue
            if (nextX > max || nextX < min || nextY > max || nextY < min) {
                continue;
            }

            // 3. 방문 업데이트
            // a -> b 인 경우 b -> a 와 동일하게 방문된 곳이므로 추가되어야 함
            answer.add(prevX + " " + prevY + " " + nextX + " " + nextY);
            answer.add(nextX + " " + nextY + " " + prevX + " " + prevY);

            // 4. 좌표 업데이트
            prevX = nextX;
            prevY = nextY;
        }
        return answer.size() / 2;
    }

}
