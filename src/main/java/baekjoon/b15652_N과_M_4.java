package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class b15652_N과_M_4 {

    private static final List<String> results = new ArrayList<>();
    private static int N;
    private static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] numbers = initNumbers();

        backTracking(numbers, new ArrayList<>(), 0);
        printResult();
    }

    private static int[] initNumbers() {
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = i + 1;
        }

        return numbers;
    }

    private static void backTracking(int[] numbers, List<Integer> sequence, int index) {
        if (sequence.size() == M) {
            results.add(stringOfSequence(sequence));
            return;
        }

        for (int i = index; i < N; i++) {
            List<Integer> newSequence = new ArrayList<>(sequence);
            newSequence.add(numbers[i]);

            backTracking(numbers, newSequence, i);
        }
    }

    private static void printResult() {
        StringBuilder sb = new StringBuilder();
        for (String result : results) {
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }

    private static String stringOfSequence(List<Integer> sequence) {
        return sequence.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(" "));
    }
}

/*
문제
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

1부터 N까지 자연수 중에서 M개를 고른 수열
같은 수를 여러 번 골라도 된다.
고른 수열은 비내림차순이어야 한다.
길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
입력
첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.

예제 입력 1
3 1
예제 출력 1
1
2
3

예제 입력 2
4 2
예제 출력 2
1 1
1 2
1 3
1 4
2 2
2 3
2 4
3 3
3 4
4 4

예제 입력 3
3 3
예제 출력 3
1 1 1
1 1 2
1 1 3
1 2 2
1 2 3
1 3 3
2 2 2
2 2 3
2 3 3
3 3 3
 */