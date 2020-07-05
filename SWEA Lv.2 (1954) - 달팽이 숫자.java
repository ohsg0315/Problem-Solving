import java.util.*;

public class Solution {
    // 달팽이 [우, 하, 좌, 상] 방향
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private static boolean isRange(int[][] snailArr, int x, int y) {
        if (x < 0 || y < 0 || x >= snailArr.length || y >= snailArr.length || snailArr[y][x] != 0) {
            return false;
        }
        return true;
    }

    private static void makeSnailArr(int[][] snailArr, int x, int y, int cnt, int direction) {
        snailArr[y][x] = cnt;
        if (cnt == (int) Math.pow(snailArr.length, 2)) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (isRange(snailArr, x + dx[direction], y + dy[direction])) {
                makeSnailArr(snailArr, x + dx[direction], y + dy[direction], cnt + 1, direction % 4);
            }
            direction = (direction + 1) % 4;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;

        T = sc.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt(), x = 0, y = 0;
            int[][] snailArr = new int[N][N];

            makeSnailArr(snailArr, x, y, 1, 0);
            System.out.println("#" + testCase);
            for (int[] i : snailArr) {
                for (int j : i) {
                    System.out.print(j + " ");
                }
                System.out.println();
            }
        }
    }
}