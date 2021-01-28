package baekjoon;

import java.util.Scanner;

public class b1193_분수찾기 {

    private static final int NUMBER_ONE = 1;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int order = Integer.parseInt(scanner.nextLine());
        int numerator = NUMBER_ONE;
        int denominator = NUMBER_ONE;
        boolean numberatorIncrease = false;

        while (order > NUMBER_ONE) {
            if (numerator == NUMBER_ONE) {
                denominator += NUMBER_ONE;
                numberatorIncrease = !numberatorIncrease;
                order -= NUMBER_ONE;

            } else if (denominator == NUMBER_ONE) {
                numerator += NUMBER_ONE;
                numberatorIncrease = !numberatorIncrease;
                order -= NUMBER_ONE;
            }

            if (order <= NUMBER_ONE) {
                break;
            }

            if (numberatorIncrease) {
                numerator += NUMBER_ONE;
                denominator -= NUMBER_ONE;

            } else {
                numerator -= NUMBER_ONE;
                denominator += NUMBER_ONE;
            }

            order -= NUMBER_ONE;
        }

        System.out.println(numerator + "/" + denominator);
    }
}

/*
문제
무한히 큰 배열에 다음과 같이 분수들이 적혀있다.

1/1	1/2	1/3	1/4	1/5	…
2/1	2/2	2/3	2/4	…	…
3/1	3/2	3/3	…	…	…
4/1	4/2	…	…	…	…
5/1	…	…	…	…	…
…	…	…	…	…	…
이와 같이 나열된 분수들을 1/1 -> 1/2 -> 2/1 -> 3/1 -> 2/2 -> … 과 같은 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.

X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 X(1 ≤ X ≤ 10,000,000)가 주어진다.

출력
첫째 줄에 분수를 출력한다.

예제 입력 1
14
예제 출력 1
2/4
 */