import java.util.*;
import java.io.*;

public class Main {
    private static int n, res = Integer.MIN_VALUE;
    private static int[][] meeting;

    // 시간초과
    private static void dfs(int before, int cnt, int idx) {
        if (idx == n) {
            if (res < cnt) {
                res = cnt;
            }
            return;
        }
        // 이전 회의가 끝나고 회의를 할 수 있다면
        if (before <= meeting[idx][0]) {
            dfs(meeting[idx][1], cnt + 1, idx + 1);
        }
        // 이번 회의 건너뜀
        dfs(before, cnt, idx + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        n = Integer.parseInt(br.readLine());
        meeting = new int[n][2];

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine());

            meeting[i][0] = Integer.parseInt(tokenizer.nextToken());
            meeting[i][1] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(meeting, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        // dfs(0, 0, 0);

        // Greedy
        int before = 0, res = 0;
        for (int i = 0; i < n; i++) {
            if (before <= meeting[i][0]) {
                before = meeting[i][1];
                res++;
            }
        }
        System.out.println(res);
    } // end of main
} // end of class