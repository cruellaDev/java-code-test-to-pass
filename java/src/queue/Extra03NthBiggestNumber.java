package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Extra03NthBiggestNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }

        while (pq.size() > n) {
            pq.poll();
        }

        System.out.println(pq.poll());

        /*
        int[] arr = new int[n * n];
        int idx = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[idx++] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(arr);
        System.out.println(arr[n * n - n]);
         */
    }
}
