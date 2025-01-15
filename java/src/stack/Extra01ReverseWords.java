package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Extra01ReverseWords {

    // 문제 출처: [백준 - 단어순서 뒤집기](https://www.acmicpc.net/problem/12605)

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] array = new String[N];
        Stack<String> stack;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            String[] words = str.split(" ");
            stack = new Stack<>();
            for (String word: words) {
                stack.push(word);
            }
            array[i] = String.join(", ", stack);
            System.out.println("Case #" + i + 1 + " " + array[i]);
        }
    }
}
