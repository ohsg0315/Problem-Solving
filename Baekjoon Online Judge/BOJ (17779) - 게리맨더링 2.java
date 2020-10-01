import java.util.*;
import java.io.*;

public class Main {
    private static int n, res = Integer.MAX_VALUE, total;
    private static int[][] A, map;
    private static boolean[] flag;

    private static void makeBoundary(int x, int y, int d1, int d2) {
        int maxPeople = 0, minPeople = Integer.MAX_VALUE;
        int[] people = new int[5];
        flag = new boolean[4];
        map = new int[n + 1][n + 1];
        people[0] = total;

//        1. (x, y), (x+1, y-1), ..., (x+d1, y-d1)
//        4. (x+d2, y+d2), (x+d2+1, y+d2-1), ..., (x+d2+d1, y+d2-d1)
        for (int i = 0; i <= d1; i++) {
            map[x + i][y - i] = 5;
            map[x + d2 + i][y + d2 - i] = 5;
        }
//        2. (x, y), (x+1, y+1), ..., (x+d2, y+d2)
//        3. (x+d1, y-d1), (x+d1+1, y-d1+1), ... (x+d1+d2, y-d1+d2)
        for (int i = 0; i <= d2; i++) {
            map[x + i][y + i] = 5;
            map[x + d1 + i][y - d1 + i] = 5;
        }

//        1번 선거구: 1 ≤ r < x+d1, 1 ≤ c ≤ y
        for (int i = 1; i < x + d1; i++) {
            for (int j = 1; j <= y; j++) {
                if (map[i][j] == 5) break;

                map[i][j] = 1;
                flag[0] = true;
                people[1] += A[i][j];
            }
        }
        if (people[1] == 0) return;

//        2번 선거구: 1 ≤ r ≤ x+d2, y < c ≤ N
        for (int i = 1; i <= x + d2; i++) {
            for (int j = n; j > y; j--) {
                if (map[i][j] == 5) break;

                map[i][j] = 2;
                flag[1] = true;
                people[2] += A[i][j];
            }
        }
        if (people[2] == 0) return;

//        3번 선거구: x+d1 ≤ r ≤ N, 1 ≤ c < y-d1+d2
        for (int i = x + d1; i <= n; i++) {
            for (int j = 1; j < y - d1 + d2; j++) {
                if (map[i][j] == 5) break;

                map[i][j] = 3;
                flag[2] = true;
                people[3] += A[i][j];
            }
        }
        if (people[3] == 0) return;

//        4번 선거구: x+d2 < r ≤ N, y-d1+d2 ≤ c ≤ N
        for (int i = x + d2 + 1; i <= n; i++) {
            for (int j = n; j >= y - d1 + d2; j--) {
                if (map[i][j] == 5) break;

                map[i][j] = 4;
                flag[3] = true;
                people[4] += A[i][j];
            }
        }
        if (people[4] == 0) return;

        if (flag[0] && flag[1] && flag[2] && flag[3]) {
            for (int i = 1; i < 5; i++) {
                people[0] -= people[i];

                maxPeople = Math.max(maxPeople, people[i]);
                minPeople = Math.min(minPeople, people[i]);
            }
            maxPeople = Math.max(maxPeople, people[0]);
            minPeople = Math.min(minPeople, people[0]);

            res = Math.min(res, maxPeople - minPeople);
        }
    }

    private static void findD1D2(int x, int y) {
        // [ 1 <= y - d1 ] -> [ d1 + 1 <= y ] -> [ d1 <= y -1 ] == [ d1 < y ]
        for (int d1 = 1; d1 < y; d1++) {
            for (int d2 = 1; y + d2 <= n; d2++) {
                if (x + d1 + d2 > n) continue;

                makeBoundary(x, y, d1, d2);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        n = Integer.parseInt(br.readLine());
        A = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                A[i][j] = Integer.parseInt(tokenizer.nextToken());
                total += A[i][j];
            }
        }

        // (d1, d2 >= 1) && (y + d2 <= n)  -> y 가 n이면 y + d2는 무조건 n 보다 크므로 y < n 까지
        // (d1, d2 >= 1) && (x + d1 + d2 <= n) -> d1, d2 = 1 일때 x + 2 <= n 이므로
        for (int y = 1; y < n; y++) {
            for (int x = 1; x + 2 <= n; x++) {
                findD1D2(x, y);
            }
        }
        System.out.println(res);
    }
}