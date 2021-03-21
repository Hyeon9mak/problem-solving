package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class b15650_N과_M_2 {

    public static final String DELIMITER = " ";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] numbers = fromOneToN(N);

        Set<String> results = new HashSet<>();
        backtracking(numbers, results, new ArrayList<>(), M);
        printResult(results);
    }

    private static int[] fromOneToN(int N) {
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = i+1;
        }
        return numbers;
    }

    private static void backtracking(int[] numbers, Set<String> results, List<Integer> sequence, int M) {
        if(sequence.size() == M) {
            sequence.sort(Integer::compareTo);
            results.add(sequence.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER))
                .toString());
            return;
        }

        for (int number : numbers) {
            if(!sequence.contains(number)) {
                List<Integer> newSequence = new ArrayList<>(sequence);
                newSequence.add(number);
                backtracking(numbers, results, newSequence, M);
            }
        }
    }

    private static void printResult(Set<String> results) {
        List<String> strings = new ArrayList<>(results);
        strings.sort(String::compareTo);
        StringBuilder sb = new StringBuilder();
        for (String result : strings) {
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}

/*
문제
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
고른 수열은 오름차순이어야 한다.
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
1 2
1 3
1 4
2 3
2 4
3 4
예제 입력 3
4 4
예제 출력 3
1 2 3 4
 */