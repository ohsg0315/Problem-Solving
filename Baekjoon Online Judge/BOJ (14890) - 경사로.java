import java.util.*;
import java.io.*;

public class Main {
    private static int findPath(int n, int l, int[][] map, boolean[][] selected) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            boolean flag = true;

            for (int j = 1; j < n; j++) {
                if (!flag) break;

                int diff = Math.abs(map[i][j] - map[i][j - 1]);

                // 같은 높이면 건너 뜀
                if (diff == 0) continue;
                    // 높이 차가 1이 넘음
                else if (diff > 1) {
                    flag = false;
                    break;
                }
                // 높이 차가 1
                else {
                    if (map[i][j] < map[i][j - 1]) {
                        if (j + l > n) {
                            flag = false;
                            break;
                        }
                        for (int k = 0; k < l; k++) {
                            if (selected[i][j + k]) {
                                flag = false;
                                break;
                            } else {
                                selected[i][j + k] = true;
                            }
                        }
                    } else if (map[i][j] > map[i][j - 1]) {
                        if (j - l < 0) {
                            flag = false;
                            break;
                        }
                        for (int k = 0; k < l; k++) {
                            if (selected[i][j - 1 - k]) {
                                flag = false;
                                break;
                            } else {
                                selected[i][j - 1 - k] = true;
                            }
                        }
                    }
                }
            }
            if (flag) cnt++;
        }
        return cnt;
    }

    private static int[][] rotate(int n, int[][] cur) {
        int[][] next = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                next[i][j] = cur[n - 1 - j][i];
            }
        }
        return next;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        int res = 0;
        int n = Integer.parseInt(tokenizer.nextToken());
        int l = Integer.parseInt(tokenizer.nextToken());
        int[][] map = new int[n][n];
        boolean[][] selected = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        // 가로
        res += findPath(n, l, map, selected);
        // 세로
        map = rotate(n, map);
        selected = new boolean[n][n];
        res += findPath(n, l, map, selected);

        System.out.println(res);
    }
}