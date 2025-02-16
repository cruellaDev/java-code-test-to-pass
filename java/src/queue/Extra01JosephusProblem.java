package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Extra01JosephusProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine(), " ");
        StringBuilder answer = new StringBuilder("<");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> queue = new ArrayDeque<>(); // List로 바꾸면 더 쉽다
        for (int i = 0; i < n; i++) {
            queue.add(i + 1);
        }

        // 1234567 -> 456712 -> 71245 -> 4571 -> 145
        int front;
        int count = 1;
        while (!queue.isEmpty()) {
            front = queue.poll();
            if (count == k) {
                answer.append(front);
                if (!queue.isEmpty()) {
                    answer.append(", ");
                }
                count = 1;
                continue;
            }
            queue.add(front);
            count++;
        }

        answer.append(">");
        System.out.println(answer);
    }
}
