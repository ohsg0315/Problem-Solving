import java.util.*;
import java.io.*;

public class Solution {
    private static boolean[][][] map;

    private static boolean isPossible(int x, int y, int a, int n) {
        // 기둥
        if (a == 0) {
            if (y == 0) return true; // 바닥 위에 있거나

            else if ((x > 0 && map[y][x - 1][1]) || map[y][x][1]) return true; // 보의 한쪽 끝 부분 위에 있거나

            else if (y > 0 && map[y - 1][x][0]) return true; // 또 다른 기둥 위에 있다

            else return false;
        }
        // 보
        else if (a == 1) {
            // 4, 2
            if (y > 0 && (map[y - 1][x][0] || (x + 1 <= n && map[y - 1][x + 1][0]))) return true; // 한쪽 끝 부분이 기둥 위에 있거나

            else if (x > 0 && x + 1 <= n && map[y][x - 1][1] && map[y][x + 1][1]) return true; // 양쪽 끝 부분이 다른 보와 동시에 연결

            else return false;
        }
        return false;
    }

    public int[][] solution(int n, int[][] build_frame) {
        int size = 0;
        int[][] answer = {};
        map = new boolean[n + 1][n + 1][2];

        for (int[] info : build_frame) {
            int x = info[0], y = info[1], a = info[2], b = info[3];

            // 삭제
            if (b == 0) {
                map[y][x][a] = false;

                // 기둥 제거할 때
                if (a == 0) {
                    // 윗 기둥
                    if (y + 1 <= n && map[y + 1][x][0] && !isPossible(x, y + 1, 0, n)) {
                        map[y][x][a] = true;
                        continue;
                    }
                    // 왼쪽 보
                    else if (x > 0 && y + 1 <= n && map[y + 1][x - 1][1] && !isPossible(x - 1, y + 1, 1, n)) {
                        map[y][x][a] = true;
                        continue;
                    }
                    // 오른쪽 보
                    else if (y + 1 <= n && map[y + 1][x][1] && !isPossible(x, y + 1, 1, n)) {
                        map[y][x][a] = true;
                        continue;
                    }
                }
                // 보 제거할 때
                else if (a == 1) {
                    // 왼쪽 기둥

                    if (map[y][x][0] && !isPossible(x, y, 0, n)) {
                        map[y][x][a] = true;
                        continue;
                    }
                    // 오른쪽 기둥
                    else if (x + 1 <= n && map[y][x + 1][0] && !isPossible(x + 1, y, 0, n)) {
                        map[y][x][a] = true;
                        continue;
                    }
                    // 왼쪽 보
                    else if (x > 0 && map[y][x - 1][1] && !isPossible(x - 1, y, 1, n)) {
                        map[y][x][a] = true;
                        continue;
                    }
                    // 오른쪽 보
                    else if (x + 1 <= n && map[y][x + 1][1] && !isPossible(x + 1, y, 1, n)) {
                        map[y][x][a] = true;
                        continue;
                    }
                }
                size--;
            }
            // 설치
            else if (b == 1) {
                if (!isPossible(x, y, a, n)) continue;

                map[y][x][a] = true;
                size++;
            }
        }
        answer = new int[size][3];
        size = 0;
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                for (int k = 0; k < 2; k++) {
                    if (map[i][j][k]) {
                        answer[size++] = new int[]{j, i, k};
                        // System.out.println(j + ", " + i + ", " + k);
                    }
                }
            }
        }
        Arrays.sort(answer, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    if (a[1] == b[1]) {
                        return a[2] - b[2];
                    }
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        });
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
    } // end of main
} // end of class