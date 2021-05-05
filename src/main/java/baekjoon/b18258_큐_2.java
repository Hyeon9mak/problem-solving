package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.Objects;

public class b18258_큐_2 {

    private static final String PUSH = "push";
    private static final String POP = "pop";
    private static final String SIZE = "size";
    private static final String EMPTY = "empty";
    private static final String FRONT = "front";
    private static final String BACK = "back";
    private static final String REGEX = " ";
    private static final String ENTER_LINE = "\n";
    private static final int ERROR = -1;
    private static final int TRUE = 1;
    private static final int FALSE = 0;

    private static final Deque<Integer> QUEUE = new ArrayDeque<>();
    private static final StringBuilder STRING_BUILDER = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int commandCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < commandCount; i++) {
            String command = br.readLine();

            if (command.startsWith(PUSH)) {
                push(Integer.parseInt(command.split(REGEX)[1]));
            }

            if (command.startsWith(POP)) {
                pop();
            }

            if (command.startsWith(SIZE)) {
                size();
            }

            if (command.startsWith(EMPTY)) {
                empty();
            }

            if (command.startsWith(FRONT)) {
                front();
            }

            if (command.startsWith(BACK)) {
                back();
            }
        }

        System.out.print(STRING_BUILDER);
    }

    public static void push(final int number) {
        QUEUE.addLast(number);
    }

    private static void pop() {
        try {
            STRING_BUILDER.append(QUEUE.removeFirst()).append(ENTER_LINE);
        } catch (NoSuchElementException e) {
            STRING_BUILDER.append(ERROR).append(ENTER_LINE);
        }
    }

    private static void size() {
        STRING_BUILDER.append(QUEUE.size()).append(ENTER_LINE);
    }

    private static void empty() {
        if (QUEUE.isEmpty()) {
            STRING_BUILDER.append(TRUE).append(ENTER_LINE);
        } else {
            STRING_BUILDER.append(FALSE).append(ENTER_LINE);
        }
    }

    private static void front() {
        if (Objects.isNull(QUEUE.peekFirst())) {
            STRING_BUILDER.append(ERROR).append(ENTER_LINE);
        } else {
            STRING_BUILDER.append(QUEUE.peekFirst()).append(ENTER_LINE);
        }
    }

    private static void back() {
        if (Objects.isNull(QUEUE.peekLast())) {
            STRING_BUILDER.append(ERROR).append(ENTER_LINE);
        } else {
            STRING_BUILDER.append(QUEUE.peekLast()).append(ENTER_LINE);
        }
    }
}

/*
문제
정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 여섯 가지이다.

push X: 정수 X를 큐에 넣는 연산이다.
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 큐에 들어있는 정수의 개수를 출력한다.
empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
입력
첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 2,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.

출력
출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.

예제 입력 1
15
push 1
push 2
front
back
size
empty
pop
pop
pop
size
empty
pop
push 3
empty
front
예제 출력 1
1
2
2
0
1
2
-1
0
1
-1
0
3
 */