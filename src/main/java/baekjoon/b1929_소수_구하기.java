package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b1929_소수_구하기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Arrays.stream(findPrimeNumbers(M, N, initNumbers(M, N)))
            .forEach(number -> System.out.println(number));

    }

    private static int[] initNumbers(int M, int N) {
        int[] numbers = new int[N - M + 1];
        int index = 0;
        for (int i = M; i <= N; i++) {
            numbers[index++] = i;
        }
        return numbers;
    }

    private static int[] findPrimeNumbers(int M, int N, int[] numbers) {
        int numbersSize = numbers.length;
        for (int i = 0; i < numbersSize; i++) {
            if (numbers[i] == -1) {
                continue;
            }
            if (numbers[i] == 1){
                numbers[i] = -1;
                continue;
            }
            for (int number = 2; number <= (int) Math.sqrt(numbers[i]); number++) {
                if (numbers[i] % number == 0) {
                    numbers[i] = -1;
                }
            }
        }
        return Arrays.stream(numbers).filter(number -> number != -1).toArray();
    }

}

/*
문제
M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.

출력
한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.

예제 입력 1
3 16
예제 출력 1
3
5
7
11
 */