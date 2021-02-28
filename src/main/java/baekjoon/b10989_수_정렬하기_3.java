package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b10989_수_정렬하기_3 {

    private static final int NUMBER_RANGE = 10000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputCount = Integer.parseInt(br.readLine());
        int[] numbers = new int[NUMBER_RANGE + 1];

        for (int i = 0; i < inputCount; i++) {
            numbers[Integer.parseInt(br.readLine())] += 1;
        }

        System.out.println(getResult(numbers));
    }

    private static StringBuilder getResult(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= NUMBER_RANGE; i++) {
            for (int j = 0; j < numbers[i]; j++) {
                sb.append(i).append("\n");
            }
        }
        return sb;
    }
}

/*
문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.

출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

예제 입력 1
10
5
2
3
1
4
2
3
5
1
7
예제 출력 1
1
1
2
2
3
3
4
5
5
7
 */