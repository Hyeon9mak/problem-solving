package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class b2108_통계학 {

    private static final String ENTER_LINE = "\n";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = new ArrayList<>();
        int numberCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < numberCount; i++) {
            numbers.add(Integer.parseInt(br.readLine()));
        }

        StringBuffer sb = new StringBuffer();
        sb.append(getArithmeticMean(numbers));
        sb.append(getMedian(numbers));
        sb.append(getMostOftenAppear(numbers));
        sb.append(getRange(numbers));

        System.out.println(sb);
    }

    private static String getArithmeticMean(final List<Integer> numbers) {
        double totalSum = numbers.stream().reduce(0, Integer::sum);
        double count = numbers.size();
        return Math.round(totalSum / count) + ENTER_LINE;
    }

    private static String getMedian(final List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers.get(numbers.size() / 2) + ENTER_LINE;
    }

    private static String getMostOftenAppear(final List<Integer> numbers) {
        Map<Integer, Integer> numbersMap = getNumbersMap(numbers);
        int maxCount = getMaxCount(numbers);
        List<Integer> maxCountNumbers = new ArrayList<>();

        for (Entry<Integer, Integer> entry : numbersMap.entrySet()) {
            if (entry.getValue().equals(maxCount)) {
                maxCountNumbers.add(entry.getKey());
            }
        }

        if (maxCountNumbers.size() == 1) {
            return maxCountNumbers.get(0) + ENTER_LINE;
        }
        maxCountNumbers.sort(Comparator.reverseOrder());
        return maxCountNumbers.get(1) + ENTER_LINE;
    }

    private static int getMaxCount(final List<Integer> numbers) {
        int maxCount = 0;
        int currentCount = 1;
        int numbersCount = numbers.size();

        for (int i = 1; i < numbersCount; i++) {
            int prevNumber = numbers.get(i - 1);
            int currentNumber = numbers.get(i);
            if (prevNumber == currentNumber) {
                currentCount += 1;
            } else {
                if (maxCount < currentCount) {
                    maxCount = currentCount;
                }
                currentCount = 1;
            }
        }

        return maxCount;
    }

    private static Map<Integer, Integer> getNumbersMap(final List<Integer> numbers) {
        Map<Integer, Integer> numbersMap = new HashMap<>();
        for (Integer number : numbers) {
            if (numbersMap.containsKey(number)) {
                numbersMap.put(number, numbersMap.get(number) + 1);
            } else {
                numbersMap.put(number, 1);
            }
        }
        return numbersMap;
    }

    private static String getRange(final List<Integer> numbers) {
        return numbers.get(numbers.size() - 1) - numbers.get(0) + ENTER_LINE;
    }
}

/*
문제
수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 단, N은 홀수라고 가정하자.

산술평균 : N개의 수들의 합을 N으로 나눈 값
중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
최빈값 : N개의 수들 중 가장 많이 나타나는 값
범위 : N개의 수들 중 최댓값과 최솟값의 차이
N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 그 다음 N개의 줄에는 정수들이 주어진다. 입력되는 정수의 절댓값은 4,000을 넘지 않는다.

출력
첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.

둘째 줄에는 중앙값을 출력한다.

셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.

넷째 줄에는 범위를 출력한다.

예제 입력 1
5
1
3
8
-2
2
예제 출력 1
2
2
1
10
예제 입력 2
1
4000
예제 출력 2
4000
4000
4000
0
예제 입력 3
5
-1
-2
-3
-1
-2
예제 출력 3
-2
-2
-1
2
 */