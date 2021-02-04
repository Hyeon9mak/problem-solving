package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b10872_팩토리얼 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int factorialNumber = Integer.parseInt(br.readLine());

        System.out.println(getFactorialResult(factorialNumber));
    }

    private static int getFactorialResult(int factorialNumber) {
        if (factorialNumber > 1) {
            return factorialNumber * getFactorialResult(factorialNumber - 1);
        }
        return 1;
    }

}

/*
문제
0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 정수 N(0 ≤ N ≤ 12)가 주어진다.

출력
첫째 줄에 N!을 출력한다.

예제 입력 1
10
예제 출력 1
3628800
예제 입력 2
0
예제 출력 2
1
 */