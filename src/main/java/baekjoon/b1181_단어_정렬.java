package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class b1181_단어_정렬 {

    public static final String NEW_LINE = "\n";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputCount = Integer.parseInt(br.readLine());
        Set<String> stringSet = new HashSet<>();

        for (int i = 0; i < inputCount; i++) {
            stringSet.add(br.readLine());
        }

        printResult(getSortedStrings(stringSet));
    }

    private static List<String> getSortedStrings(final Set<String> stringSet) {
        List<String> stringList = new ArrayList<>(stringSet);
        stringList.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            } else {
                return o1.length() - o2.length();
            }
        });
        return stringList;
    }

    private static void printResult(final List<String> strings) {
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            sb.append(string).append(NEW_LINE);
        }
        System.out.print(sb);
    }
}

/*
문제
알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.

길이가 짧은 것부터
길이가 같으면 사전 순으로
입력
첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 주어지는 문자열의 길이는 50을 넘지 않는다.

출력
조건에 따라 정렬하여 단어들을 출력한다. 단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.

예제 입력 1
13
but
i
wont
hesitate
no
more
no
more
it
cannot
wait
im
yours

예제 출력 1
i
im
it
no
but
more
wait
wont
yours
cannot
hesitate
 */