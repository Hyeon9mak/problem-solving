package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b1041_주사위 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(reader.readLine());

        long[] dice = new long[6];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < 6; i++) {
            dice[i] = Long.parseLong(tokenizer.nextToken());
        }

        System.out.println(solution(N, dice));
    }

    private static BigInteger solution(long N, long[] dice) {
        if (N == 1) {
            long maxResult = Arrays.stream(dice).max().getAsLong();
            long sum = Arrays.stream(dice).sum();

            return BigInteger.valueOf(sum - maxResult);
        }

        long min1 = 51;
        long min2 = 101;
        long min3 = 151;

        for (int i = 0; i < 6; i++) {
            min1 = Math.min(min1, dice[i]);

            for (int j = i + 1; j < 6; j++) {
                if (i + j == 5) {
                    continue;
                }

                min2 = Math.min(min2, dice[i] + dice[j]);

                for (int k = j + 1; k < 6; k++) {
                    if (i + k == 5 || j + k == 5) {
                        continue;
                    }

                    min3 = Math.min(min3, dice[i] + dice[j] + dice[k]);
                }
            }
        }

        BigInteger result1 = BigInteger.valueOf((N - 2) * (N - 2))
            .add(BigInteger.valueOf((N - 2) * (N - 1))
                .multiply(BigInteger.valueOf(4)))
            .multiply(BigInteger.valueOf(min1));

        BigInteger result2 = BigInteger.valueOf(4 * (N - 2))
            .add(BigInteger.valueOf(4 * (N - 1)))
            .multiply(BigInteger.valueOf(min2));

        BigInteger result3 = BigInteger.valueOf(min3 * 4);

        return result1.add(result2).add(result3);
    }
}
