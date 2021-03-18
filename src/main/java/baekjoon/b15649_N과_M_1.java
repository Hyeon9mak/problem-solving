package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class b15649_N과_M_1 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] numbers = fromOneToN(N);
        List<String> results = new ArrayList<>();

        backTracking(numbers, results, new ArrayList<>(), M);

        printResult(results);
    }

    private static int[] fromOneToN(int N) {
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = i+1;
        }
        return numbers;
    }

    private static void backTracking(int[] numbers, List<String> results, List<Integer> sequence, int M) {
        if(sequence.size() == M) {
            addToResult(results, sequence);
            return;
        }

        for (int number : numbers) {
            if(!sequence.contains(number)) {
                ArrayList<Integer> nextSequence = new ArrayList<>(sequence);
                nextSequence.add(number);
                backTracking(numbers, results, nextSequence, M);
            }
        }
    }

    private static void addToResult(List<String> result, List<Integer> sequence) {
        result.add(sequence.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(" "))
        );
    }

    private static void printResult(List<String> results) {
        for (String result : results) {
            System.out.println(result);
        }
    }
}

/*
문제
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
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
2 1
2 3
2 4
3 1
3 2
3 4
4 1
4 2
4 3
예제 입력 3
4 4
예제 출력 3
1 2 3 4
1 2 4 3
1 3 2 4
1 3 4 2
1 4 2 3
1 4 3 2
2 1 3 4
2 1 4 3
2 3 1 4
2 3 4 1
2 4 1 3
2 4 3 1
3 1 2 4
3 1 4 2
3 2 1 4
3 2 4 1
3 4 1 2
3 4 2 1
4 1 2 3
4 1 3 2
4 2 1 3
4 2 3 1
4 3 1 2
4 3 2 1
 */