package baeckjoon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class b1157_단어_공부 {

    private static final int COUNT_OF_ALPHABET = 26;
    private static final int ASCII_UPPER_ALPHABET = 65;
    private static final int INIT_COUNT = 0;

    public static void main(String[] args) throws Exception {
        Map<Character, Integer> alphabets = initAlphabets();

        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine().toUpperCase();
        int wordLength = word.length();
        int maxCount = 0;

        for (int i = 0; i < wordLength; i++) {
            char alphabet = word.charAt(i);
            int getCount = alphabets.get(alphabet) + 1;
            if (maxCount < getCount) {
                maxCount = getCount;
            }
            alphabets.replace(alphabet, getCount);
        }

        List<Character> resultAlphabet = getResult(alphabets, maxCount);

        if (resultAlphabet.size() > 1) {
            System.out.println("?");
        } else {
            System.out.println(resultAlphabet.get(0));
        }
    }

    private static Map<Character, Integer> initAlphabets() {
        Map<Character, Integer> alphabets = new HashMap();
        for (int i = ASCII_UPPER_ALPHABET; i < ASCII_UPPER_ALPHABET + COUNT_OF_ALPHABET; i++) {
            alphabets.put((char) i, INIT_COUNT);
        }
        return alphabets;
    }

    private static List<Character> getResult(Map<Character, Integer> alphabets, int maxCount ) {
        List<Character> resultAlphabet = new ArrayList<>();
        for (int i = ASCII_UPPER_ALPHABET; i < ASCII_UPPER_ALPHABET + COUNT_OF_ALPHABET; i++) {
            if (alphabets.get((char) i).equals(maxCount)) {
                resultAlphabet.add((char) i);
            }
        }
        return resultAlphabet;
    }
}

/*
문제
알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.

입력
첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.

출력
첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.

예제 입력 1
Mississipi
예제 출력 1
?
예제 입력 2
zZa
예제 출력 2
Z
예제 입력 3
z
예제 출력 3
Z
예제 입력 4
baaa
예제 출력 4
A
 */
