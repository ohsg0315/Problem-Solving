import java.util.*;
import java.io.*;

public class Main {
    private static int n, m, t, total, index;
    private static int[] di = {-1, 1, 0, 0};
    private static int[] dj = {0, 0, -1, 1};
    private static ArrayList<Integer>[] list;

    private static boolean isRange(int i, int j) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }

    private static void rotate(int x, int d, int k) {
        for (int i = 0; i < k; i++) {
            if (d == 0) { // 시계 방향
                int buf = list[x].remove(m - 1);
                list[x].add(0, buf);
            } else {  // 반시계 방향
                int buf = list[x].remove(0);
                list[x].add(buf);
            }
        }
    }

    private static int refresh() {
        int curTotal = total;
        boolean flag = false;
        boolean[][] changed = new boolean[n + 1][m];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                int now = list[i].get(j);

                if (now == 0) continue;

                for (int k = 0; k < 4; k++) {
                    int nearI = i + di[k];
                    int nearJ = j + dj[k];

                    if (nearI == 0 || nearI > n) continue;

                    if (nearJ < 0) nearJ = m - 1;
                    else if (nearJ >= m) nearJ = 0;

                    if (now == list[nearI].get(nearJ)) {
                        flag = true;
                        changed[i][j] = true;
                        changed[nearI][nearJ] = true;
                    }
                }
            }
        }
        if (flag) {
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < m; j++) {
                    if (changed[i][j]) {
                        curTotal -= list[i].get(j);
                        list[i].set(j, 0);
                        index--;
                    }
                }
            }
        }
        return curTotal;
    }

    private static void refresh2(double avg) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                int buf = list[i].get(j);
                if (buf != 0) {
                    if (buf > avg) {
                        list[i].set(j, buf - 1);
                        total--;
                    } else if (buf < avg) {
                        list[i].set(j, buf + 1);
                        total++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        t = Integer.parseInt(tokenizer.nextToken());
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            tokenizer = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < m; j++) {
                list[i].add(Integer.parseInt(tokenizer.nextToken()));
                total += list[i].get(j);
                index++;
            }
        }

        for (int i = 0; i < t; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(tokenizer.nextToken());
            int d = Integer.parseInt(tokenizer.nextToken());
            int k = Integer.parseInt(tokenizer.nextToken());
            int cnt = 1;

            while (x * cnt <= n) {
                rotate(x * cnt, d, k);
                cnt++;
            }

            int buf = refresh();
            if (total == buf) {
                refresh2((double) total / index);
            } else total = buf;
        } // end of for
        System.out.println(total);
    } // end of main
}