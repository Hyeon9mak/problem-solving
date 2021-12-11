package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1012_유기농_배추 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < testCount; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int M = Integer.parseInt(tokenizer.nextToken());
            int N = Integer.parseInt(tokenizer.nextToken());
            int K = Integer.parseInt(tokenizer.nextToken());
            
            int[][] ground = new int[M][N];
            for (int j = 0; j < K; j++) {
                StringTokenizer cabbagePoint = new StringTokenizer(reader.readLine());
                int X = Integer.parseInt(cabbagePoint.nextToken());
                int Y = Integer.parseInt(cabbagePoint.nextToken());
                ground[X][Y] = 1;
            }

            System.out.println(solution(ground, M, N));
        }
    }

    private static int solution(int[][] ground, int M, int N) {
        int answer = 0;

        for (int x = 0; x < M; x++) {
            for (int y = 0; y < N; y++) {
                if (ground[x][y] == 1) {
                    tracking(ground, x, y, M, N);
                    answer += 1;
                }
            }
        }

        return answer;
    }

    private static void tracking(int[][] ground, int x, int y, int M, int N) {
        ground[x][y] = 0;

        if (0 <= (x - 1) && ground[x - 1][y] == 1) {
            tracking(ground, x - 1, y, M, N);
        }
        if ((x + 1) < M && ground[x + 1][y] == 1) {
            tracking(ground, x + 1, y, M, N);
        }
        if (0 <= (y - 1) && ground[x][y - 1] == 1) {
            tracking(ground, x, y - 1, M, N);
        }
        if ((y + 1) < N && ground[x][y + 1] == 1) {
            tracking(ground, x, y + 1, M, N);
        }
    }
}
