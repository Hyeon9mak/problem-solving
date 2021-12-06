package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class b1946_신입_사원 {

    private static final int PAPER = 0;
    private static final int INTERVIEW = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringJoiner results = new StringJoiner("\n");
        int testCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < testCount; i++) {
            int N = Integer.parseInt(reader.readLine());
            int[][] ranks = new int[N][2];

            for (int j = 0; j < N; j++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                ranks[j][PAPER] = Integer.parseInt(tokenizer.nextToken());
                ranks[j][INTERVIEW] = Integer.parseInt(tokenizer.nextToken());
            }

            results.add(solution(N, ranks));
        }

        System.out.println(results);
    }

    private static String solution(int N, int[][] ranks) {
        Arrays.sort(ranks, Comparator.comparingInt(rank -> rank[PAPER]));

        int currentTopInterviewRank = ranks[0][INTERVIEW];
        int count = 1;

        for (int i = 1; i < N; i++) {
            if (ranks[i][INTERVIEW] < currentTopInterviewRank) {
                count += 1;
                currentTopInterviewRank = ranks[i][INTERVIEW];
            }
        }

        return String.valueOf(count);
    }
}
