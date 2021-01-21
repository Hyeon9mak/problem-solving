package baeckjoon;

import java.util.Scanner;

public class b11720_숫자의_합 {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int countOfInteger = Integer.parseInt(scanner.nextLine());
        String integerString = scanner.nextLine();

        System.out.println(getSumOfNumbers(integerString, countOfInteger));
    }

    private static int getSumOfNumbers(String integerString, int countOfInteger) {
        int sumResult = 0;

        for (int i = 0; i < countOfInteger; i++) {
            sumResult += Character.getNumericValue(integerString.charAt(i));
        }

        return sumResult;
    }
}


/*
문제
N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.

출력
입력으로 주어진 숫자 N개의 합을 출력한다.
 */