package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b4153_직각삼각형 {

    private static final String FINISH_INPUT = "0 0 0";
    private static final String ISRIGHT = "right";
    private static final String ISWRONG = "wrong";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> answers = new ArrayList<>();
        String input = br.readLine();

        while (!input.equals(FINISH_INPUT)) {
            StringTokenizer st = new StringTokenizer(input);
            answers.add(getAnswer(st));
            input = br.readLine();
        }

        answers.stream().forEach(answer -> System.out.println(answer));
    }

    private static String getAnswer(StringTokenizer st) {
        double a = Math.pow(Integer.parseInt(st.nextToken()), 2);
        double b = Math.pow(Integer.parseInt(st.nextToken()), 2);
        double c = Math.pow(Integer.parseInt(st.nextToken()), 2);

        if (a + b == c || a + c == b || b + c == a) {
             return ISRIGHT;
        }
        return ISWRONG;
    }
}

/*
문제
과거 이집트인들은 각 변들의 길이가 3, 4, 5인 삼각형이 직각 삼각형인것을 알아냈다. 주어진 세변의 길이로 삼각형이 직각인지 아닌지 구분하시오.

입력
입력은 여러개의 테스트케이스로 주어지며 마지막줄에는 0 0 0이 입력된다. 각 테스트케이스는 모두 30,000보다 작은 양의 정수로 주어지며, 각 입력은 변의 길이를 의미한다.

출력
각 입력에 대해 직각 삼각형이 맞다면 "right", 아니라면 "wrong"을 출력한다.

예제 입력 1
6 8 10
25 52 60
5 12 13
0 0 0
예제 출력 1
right
wrong
right
 */