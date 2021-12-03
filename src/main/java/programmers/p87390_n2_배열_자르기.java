package programmers;

import java.util.ArrayList;
import java.util.List;

public class p87390_n2_배열_자르기 {

    public static void main(String[] args) {

        print(solution(3, 2, 5));
        print(solution(4, 7, 14));
    }

    private static void print(int[] solution) {
        for (int number : solution) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    public static int[] solution(int n, long left, long right) {

        List<Integer> answer = new ArrayList<>();

        for (long i = left; i <= right; i++) {
            answer.add((int) (Math.max(i / n, i % n) + 1));
        }

        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
