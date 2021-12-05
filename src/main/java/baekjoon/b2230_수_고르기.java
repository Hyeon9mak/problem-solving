package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b2230_수_고르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(numbers);

        int answer = Integer.MAX_VALUE;
        int left = 0;
        int right = 1;

        while (left < N && right < N) {
            int number = numbers[right] - numbers[left];

            if (number < M) {
                right += 1;
            } else {
                answer = Math.min(number, answer);
                left += 1;
            }
        }

        System.out.println(answer);
    }
}
