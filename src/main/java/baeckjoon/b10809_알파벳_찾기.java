package baeckjoon;

import java.util.Arrays;
import java.util.Scanner;

public class b10809_알파벳_찾기 {

    private static final int COUNT_OF_ALPHABET = 26;
    private static final int INIT_NUMBER_OF_ALPHABET_ARRAY = -1;
    private static final int NUMBER_OF_ASCII_ALPHABET = 97;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();
        int[] alphabetArray = initAlphabetArray();

        for (int index = 0; index < string.length(); index++) {
            char alphabet = string.charAt(index);
            int order = ((int) alphabet) - NUMBER_OF_ASCII_ALPHABET;
            fixAlphabetArray(alphabetArray, index, order);
        }

        Arrays.stream(alphabetArray).forEach(value -> System.out.print(value + " "));
    }

    private static void fixAlphabetArray(int[] alphabetArray, int index, int order) {
        if (alphabetArray[order] == INIT_NUMBER_OF_ALPHABET_ARRAY) {
            alphabetArray[order] = index;
        }
    }

    private static int[] initAlphabetArray() {
        int[] alphabetArray = new int[COUNT_OF_ALPHABET];
        for (int i = 0; i < COUNT_OF_ALPHABET; i++) {
            alphabetArray[i] = INIT_NUMBER_OF_ALPHABET_ARRAY;
        }
        return alphabetArray;
    }
}


/*
문제
알파벳 소문자로만 이루어진 단어 S가 주어진다. 각각의 알파벳에 대해서, 단어에 포함되어 있는 경우에는 처음 등장하는 위치를, 포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 단어 S가 주어진다. 단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.

출력
각각의 알파벳에 대해서, a가 처음 등장하는 위치, b가 처음 등장하는 위치, ... z가 처음 등장하는 위치를 공백으로 구분해서 출력한다.

만약, 어떤 알파벳이 단어에 포함되어 있지 않다면 -1을 출력한다. 단어의 첫 번째 글자는 0번째 위치이고, 두 번째 글자는 1번째 위치이다.
 */