package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b2504_괄호의_값 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> brackets = new Stack<>();
        int stackNumber = 1;
        int result = 0;

        String string = reader.readLine();
        int length = string.length();
        for (int i = 0; i < length; i++) {
            char bracket = string.charAt(i);

            if (bracket == '(') {
                stackNumber *= 2;
                brackets.push(bracket);
            } else if (bracket == '[') {
                stackNumber *= 3;
                brackets.push(bracket);
            } else if (bracket == ')' && hasMatchedOpenBracket(brackets, bracket)) {
                char preBracket = string.charAt(i - 1);
                if (preBracket == '(') {
                    result += stackNumber;
                }

                stackNumber /= 2;
                brackets.pop();
            } else if (bracket == ']' && hasMatchedOpenBracket(brackets, bracket)) {
                char preBracket = string.charAt(i - 1);
                if (preBracket == '[') {
                    result += stackNumber;
                }

                stackNumber /= 3;
                brackets.pop();
            } else {
                result = 0;
                break;
            }
        }

        if (brackets.isEmpty()) {
            System.out.println(result);
        } else {
            System.out.println(0);
        }
    }

    private static boolean hasMatchedOpenBracket(Stack<Character> brackets, Character closeBracket) {
        if (brackets.isEmpty()) {
            return false;
        }

        Character openBracket = brackets.peek();
        String expectBracket = openBracket.toString() + closeBracket.toString();

        return expectBracket.equals("[]") || expectBracket.equals("()");
    }
}
