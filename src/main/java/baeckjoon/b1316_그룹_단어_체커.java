package baeckjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class b1316_그룹_단어_체커 {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = Integer.parseInt(scanner.nextLine());
        int groupWordCount = 0;

        for (int i = 0; i < testCaseCount; i++) {
            if (isGroupWord(scanner.nextLine())) {
                groupWordCount++;
            }
        }

        System.out.println(groupWordCount);
    }

    private static boolean isGroupWord(String word) {
        List<Character> characters = new ArrayList<>();
        int wordLength = word.length();
        characters.add(word.charAt(0));

        for (int i = 1; i < wordLength; i++) {

            char lastCharacter = characters.get(characters.size() - 1);
            char currentCharacter = word.charAt(i);

            if (lastCharacter != currentCharacter) {
                if (characters.contains(currentCharacter)) {
                    return false;
                }
            }

            characters.add(word.charAt(i));
        }

        return true;
    }
}

/*
문제
그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다. 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.

단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 단어가 들어온다. 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.

출력
첫째 줄에 그룹 단어의 개수를 출력한다.

예제 입력 1
3
happy
new
year
예제 출력 1
3
예제 입력 2
4
aba
abab
abcabc
a
예제 출력 2
1
 */