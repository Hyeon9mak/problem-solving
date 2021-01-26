package baeckjoon;

import java.util.Scanner;

public class b8958_OX퀴즈 {

    private static final char ANSWER = 'O';
    private static final int EQUAL = 0;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = Integer.parseInt(scanner.nextLine());
        int[] scoreArray = new int[testCaseCount];

        for (int i = 0; i < testCaseCount; i++) {
            scoreArray[i] = calculateResult(scanner);
        }

        for (int i = 0; i < testCaseCount; i++) {
            System.out.println(scoreArray[i]);
        }

    }

    private static int calculateResult(Scanner scanner) {
        int oCount = 0;
        int score = 0;
        String oxResult = scanner.nextLine();
        int oxResultLength = oxResult.length();

        for (int i = 0; i < oxResultLength; i++) {
            if (isAnswer(oxResult.charAt(i))) {
                oCount += 1;
                score += oCount;
            } else {
                oCount = 0;
            }
        }

        return score;
    }

    private static boolean isAnswer(char result) {
        return Character.compare(ANSWER, result) == EQUAL;
    }
}

/*
문제
"OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. O는 문제를 맞은 것이고, X는 문제를 틀린 것이다. 문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다. 예를 들어, 10번 문제의 점수는 3이 된다.

"OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.

OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 길이가 0보다 크고 80보다 작은 문자열이 주어진다. 문자열은 O와 X만으로 이루어져 있다.

출력
각 테스트 케이스마다 점수를 출력한다.

예제 입력 1
5
OOXXOXXOOO
OOXXOOXXOO
OXOXOXOXOXOXOX
OOOOOOOOOO
OOOOXOOOOXOOOOX
예제 출력 1
10
9
7
55
30
 */