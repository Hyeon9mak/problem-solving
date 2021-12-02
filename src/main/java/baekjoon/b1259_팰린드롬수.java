package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringJoiner;

public class b1259_팰린드롬수 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringJoiner results = new StringJoiner("\n");

        while (true) {
            String number = reader.readLine();
            if (isEndCommand(number)) {
                break;
            }

            int halfIndex = number.length() / 2;
            String frontNumber = number.substring(0, halfIndex);
            String backNumber = generateBackNumber(number, halfIndex);

            compareNumbers(results, frontNumber, backNumber);
        }

        System.out.println(results);
    }

    private static String generateBackNumber(String number, int halfIndex) {
        if (isOddLength(number)) {
            return number.substring(halfIndex);
        }

        return number.substring(halfIndex + 1);
    }

    private static void compareNumbers(StringJoiner results, String frontNumber, String backNumber) {
        StringBuilder backNumberBuilder = new StringBuilder(backNumber);
        String reversedBackNumber = backNumberBuilder.reverse().toString();

        if (frontNumber.equals(reversedBackNumber)) {
            results.add("yes");
        } else {
            results.add("no");
        }
    }

    private static boolean isOddLength(String number) {
        return number.length() % 2 == 0;
    }

    private static boolean isEndCommand(String command) {
        return Objects.equals(command, "0");
    }
}

/*
짝수면 절반 잘라서 reverse 후 비교
홀수면 절반 자르고 맨 뒤 하나 잘라서 비교

 */