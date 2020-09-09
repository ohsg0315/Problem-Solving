import java.util.*;
import java.io.*;

public class Solution {
    private static int[][] rotate(int[][] cur) {
        int size = cur.length;
        int[][] next = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                next[i][j] = cur[size - 1 - j][i];
            }
        }
        return next;
    }

    public boolean solution(int[][] key, int[][] lock) {
        int n = lock.length, m = key.length, mapSize = n + 2 * m - 2;
        int start = m - 1, last = start + n, rest = 0;
        int[][] map = new int[mapSize][mapSize];
        int[][][] keys = new int[4][m][m];

        keys[0] = key;
        for (int i = 1; i < 4; i++) {
            keys[i] = rotate(keys[i - 1]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i + start][j + start] = lock[i][j];

                if (lock[i][j] == 0) rest++;
            }
        }

        for (int i = 0; i < last; i++) {
            for (int j = 0; j < last; j++) {
                for (int rot = 0; rot < 4; rot++) {
                    int cnt = 0;
                    boolean flag = true;
                    label:
                    for (int k = 0; k < m; k++) {
                        for (int l = 0; l < m; l++) {
                            if (i + k >= start && i + k < last && j + l >= start && j + l < last) {
                                int cur = map[i + k][j + l] + keys[rot][k][l];
                                if (cur == 0 || cur == 2) {
                                    flag = false;
                                    break label;
                                } else if (map[i + k][j + l] == 0) {
                                    cnt++;
                                }
                            }
                        }
                    }
                    if (flag && rest == cnt) return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}});
    } // end of main
} // end of class