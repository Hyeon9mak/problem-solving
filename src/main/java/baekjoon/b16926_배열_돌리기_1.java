package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b16926_배열_돌리기_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int R = Integer.parseInt(tokenizer.nextToken());
        int halfMinValue = calculateHalfMinValue(N, M);

        String[][] matrix = generateMatrix(reader, N, M);

        int[] rotateX = {0, 1, 0, -1};
        int[] rotateY = {1, 0, -1, 0};

        for (int r = 0; r < R; r++) {
            for (int i = 0; i < halfMinValue; i++) {
                String value = matrix[i][i];
                int x = i;
                int y = i;

                for (int j = 0; j < 4; j++) {
                    int nextX = x + rotateX[j];
                    int nextY = y + rotateY[j];

                    if (nextX >= i && nextY >= i && nextX < N - i && nextY < M - i) {
                        matrix[x][y] = matrix[nextX][nextY];
                        x = nextX;
                        y = nextY;
                        j--;
                    }
                }
                matrix[i + 1][i] = value;
            }
        }

        System.out.println(parseResultMatrix(N, M, matrix));
    }

    private static int calculateHalfMinValue(int N, int M) {
        return Math.min(N, M) / 2;
    }

    private static String[][] generateMatrix(BufferedReader reader, int N, int M) throws IOException {
        String[][] matrix = new String[N][M];

        for (int n = 0; n < N; n++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

            for (int m = 0; m < M; m++) {
                matrix[n][m] = tokenizer.nextToken();
            }
        }

        return matrix;
    }

    private static StringBuilder parseResultMatrix(int N, int M, String[][] matrix) {
        StringBuilder results = new StringBuilder();

        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                results.append(matrix[n][m]).append(" ");
            }
            results.append("\n");
        }

        return results;
    }
}
