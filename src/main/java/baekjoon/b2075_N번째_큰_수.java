package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2075_N번째_큰_수 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> numbers = new PriorityQueue<>();

        int N = Integer.parseInt(reader.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

            for (int j = 0; j < N; j++) {
                numbers.offer(Integer.parseInt(tokenizer.nextToken()));

                if (numbers.size() > N) {
                    numbers.remove();
                }
            }
        }

        System.out.println(numbers.peek());
    }
}
