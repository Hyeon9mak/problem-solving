package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1978_소수_찾기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int primeNumberCount = 0;
        int testCaseCount = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < testCaseCount; i++) {
            if (isPrimeNumber(Integer.parseInt(st.nextToken()))) {
                primeNumberCount += 1;
            }
        }

        System.out.println(primeNumberCount);
    }

    private static boolean isPrimeNumber(int number) {
        if (number == 2) {
            return true;
        } else if (number <= 1 || number % 2 == 0) {
            return false;
        } else {
            return isUnDividedNumber(number);
        }
    }

    private static boolean isUnDividedNumber(int number) {
        int sqrtNumber = (int) Math.sqrt(number);

        for (int i = 2; i <= sqrtNumber; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}

/*
문제
주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
(1보단 크고, 1과 자기 자신으로만 나누어지는 수)

입력
첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.

출력
주어진 수들 중 소수의 개수를 출력한다.

예제 입력 1
4
1 3 5 7
예제 출력 1
3
 */