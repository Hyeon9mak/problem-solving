package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class b1427_소트인사이드 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numberString = br.readLine();
        List<Character> numbers = new ArrayList<>();
        int numberStringLength = numberString.length();

        for (int i = 0; i < numberStringLength; i++) {
            numbers.add(numberString.charAt(i));
        }

        StringBuffer sb = new StringBuffer();
        numbers.stream().sorted(Collections.reverseOrder()).forEach(sb::append);
        System.out.println(sb);
    }
}

/*
문제
배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.

입력
첫째 줄에 정렬하고자하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.

예제 입력 1
2143
예제 출력 1
4321
 */
