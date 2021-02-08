package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b3009_네_번째_점 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> xPoints = new ArrayList<String>();
        List<String> yPoints = new ArrayList<String>();

        System.out.println(findFourthPoint(br, xPoints, yPoints));

    }

    private static String findFourthPoint(BufferedReader br, List<String> xPoints,
        List<String> yPoints) throws IOException {
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String xPoint = st.nextToken();
            checkPoints(xPoints, xPoint);
            String yPoint = st.nextToken();
            checkPoints(yPoints, yPoint);
        }
        return xPoints.get(0) + " " + yPoints.get(0);
    }

    private static void checkPoints(List<String> points, String point) {
        if (points.contains(point)) {
            points.remove(point);
        } else {
            points.add(point);
        }
    }

}

/*
문제
세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾는 프로그램을 작성하시오.

입력
세 점의 좌표가 한 줄에 하나씩 주어진다. 좌표는 1보다 크거나 같고, 1000보다 작거나 같은 정수이다.

출력
직사각형의 네 번째 점의 좌표를 출력한다.

예제 입력 1
30 20
10 10
10 20
예제 출력 1
30 10
 */