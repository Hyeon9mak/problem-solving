package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2869_달팽이는_올라가고_싶다 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double A = Double.parseDouble(st.nextToken());
        double B = Double.parseDouble(st.nextToken());
        double V = Double.parseDouble(st.nextToken());

        System.out.println(getTotalTakeDay(A, B, V));
    }

    private static int getTotalTakeDay(double A, double B, double V) {
        return (int) (Math.ceil((V - A) / (A - B)) + 1);
    }
}
// 소수점 계산 후 올림을 떠올렸으면 쉽게 풀어지는 문제였는데,
// 괜스레 정수값 만으로 해결하려고 하다가 피 본 문제.
// 항상 알맞는 데이터타입, 자료구조를 고민하자.

/*
문제
땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.

달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 또, 정상에 올라간 후에는 미끄러지지 않는다.

달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 세 정수 A, B, V가 공백으로 구분되어서 주어진다. (1 ≤ B < A ≤ V ≤ 1,000,000,000)

출력
첫째 줄에 달팽이가 나무 막대를 모두 올라가는데 며칠이 걸리는지 출력한다.

예제 입력 1
2 1 5
예제 출력 1
4
예제 입력 2
5 1 6
예제 출력 2
2
예제 입력 3
100 99 1000000000
예제 출력 3
999999901
 */