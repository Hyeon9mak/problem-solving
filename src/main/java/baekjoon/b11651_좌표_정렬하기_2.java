package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b11651_좌표_정렬하기_2 {

    private static final int X = 0;
    private static final int Y = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputCount = Integer.parseInt(br.readLine());
        int[][] points = new int[inputCount][2];

        for (int i = 0; i < inputCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i][X] = Integer.parseInt(st.nextToken());
            points[i][Y] = Integer.parseInt(st.nextToken());
        }

        sortPoints(points);
        printResult(points, inputCount);

    }

    private static void sortPoints(int[][] points) {
        Arrays.sort(points, (prev, next) -> {
            if (prev[Y] == next[Y]) {
                return prev[X] - next[X];
            } else {
                return prev[Y] - next[Y];
            }
        });
    }

    private static void printResult(int[][] points, int inputCount) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inputCount; i++) {
            sb.append(points[i][X]).append(" ").append(points[i][Y]).append("\n");
        }
        System.out.print(sb);
    }
}

/*
문제
2차원 평면 위의 점 N개가 주어진다. 좌표를 y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.

출력
첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.

예제 입력 1
5
0 4
1 2
1 -1
2 2
3 3
예제 출력 1
1 -1
1 2
2 2
3 3
0 4
 */