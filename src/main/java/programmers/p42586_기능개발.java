package programmers;

import java.util.ArrayList;
import java.util.List;

public class p42586_기능개발 {

    public static void main(String[] args) {
        int[] progresses1 = {96, 94};
        int[] speeds1 = {3, 3};

        int[] solution1 = solution(progresses1, speeds1);
        for (int number : solution1) {
            System.out.print(number + " ");
        }

        System.out.println();

        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};

        int[] solution2 = solution(progresses2, speeds2);
        for (int number : solution2) {
            System.out.print(number + " ");
        }
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> devDays = new ArrayList<>();
        List<Integer> results = new ArrayList<>();

        int length = progresses.length;
        for (int i = 0; i < length; i++) {
            int devDay = calculateDevDay(progresses, speeds, i);

            if (!devDays.isEmpty() && devDays.get(0) < devDay) {
                results.add(devDays.size());
                devDays.clear();
            }
            devDays.add(devDay);
        }
        results.add(devDays.size());

        return results.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int calculateDevDay(int[] progresses, int[] speeds, int i) {
        if (((100 - progresses[i]) % speeds[i]) == 0) {
            return (100 - progresses[i]) / speeds[i];
        }

        return (100 - progresses[i]) / speeds[i] + 1;
    }
}
