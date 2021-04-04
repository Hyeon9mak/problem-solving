package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b9663_N_Queen {

    private static int N;
    private static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        System.out.println(countOfNoneAttackPosition());
    }

    private static int countOfNoneAttackPosition() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

            }
        }
    }

    private static boolean canAttackOtherQueen(final int x, final int y) {
        return canAttackRightUp(x, y) ||
            canAttackRight(x, y) ||
            canAttackRightDown(x, y) ||
            canAttackDown(x, y) ||
            canAttackLeftDown(x, y) ||
            canAttackLeft(x, y) ||
            canAttackLeftUp(x, y) ||
            canAttackUp(x, y);
    }

    private static boolean canAttackRightUp(int x, int y) {
        boolean attackQueenChecker = false;
        while (x < N - 1 && y < N - 1) {
            x += 1;
            y += 1;
            if (board[x][y] == 1) {
                attackQueenChecker = true;
                break;
            }
        }
        return attackQueenChecker;
    }

    private static boolean canAttackRight(int x, int y) {
        boolean attackQueenChecker = false;
        while (x < N - 1) {
            x += 1;
            if (board[x][y] == 1) {
                attackQueenChecker = true;
                break;
            }
        }
        return attackQueenChecker;
    }

    private static boolean canAttackRightDown(int x, int y) {
        boolean attackQueenChecker = false;
        while (x < N - 1 && 0 < y) {
            x += 1;
            y -= 1;
            if (board[x][y] == 1) {
                attackQueenChecker = true;
                break;
            }
        }
        return attackQueenChecker;
    }

    private static boolean canAttackDown(int x, int y) {
        boolean attackQueenChecker = false;
        while (0 < y) {
            y -= 1;
            if (board[x][y] == 1) {
                attackQueenChecker = true;
                break;
            }
        }
        return attackQueenChecker;
    }

    private static boolean canAttackLeftDown(int x, int y) {
        boolean attackQueenChecker = false;
        while (0 < x && 0 < y) {
            x -= 1;
            y -= 1;
            if (board[x][y] == 1) {
                attackQueenChecker = true;
                break;
            }
        }
        return attackQueenChecker;
    }

    private static boolean canAttackLeft(int x, int y) {
        boolean attackQueenChecker = false;
        while (0 < x) {
            x -= 1;
            if (board[x][y] == 1) {
                attackQueenChecker = true;
                break;
            }
        }
        return attackQueenChecker;

    }

    private static boolean canAttackLeftUp(int x, int y) {
        boolean attackQueenChecker = false;
        while (0 < x && y < N - 1) {
            x -= 1;
            y += 1;
            if (board[x][y] == 1) {
                attackQueenChecker = true;
                break;
            }
        }
        return attackQueenChecker;
    }

    private static boolean canAttackUp(int x, int y) {
        boolean attackQueenChecker = false;
        while (y < N - 1) {
            y += 1;
            if (board[x][y] == 1) {
                attackQueenChecker = true;
                break;
            }
        }
        return attackQueenChecker;
    }

}

/*
문제
N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.

N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. (1 ≤ N < 15)

출력
첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.

예제 입력 1
8
예제 출력 1
92
 */