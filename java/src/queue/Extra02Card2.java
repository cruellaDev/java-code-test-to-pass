package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Extra02Card2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            queue.add(i + 1);
        }

        // 1234 -> 342 -> 24 -> 4
        // 1234567 - > 345672 -> 56724 -> 7246 -> 462 -> 26 -> 6
        while (queue.size() > 1) {
            queue.poll();
            if (!queue.isEmpty()) {
                queue.add(queue.poll());
            }
        }

        System.out.println(queue.poll());
    }
}
