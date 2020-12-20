import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stair = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        // cache[현재 층][연속으로 밟은 계단 수]
        int[][] cache = new int[n + 1][3];

        // 첫번째 계단
        cache[1][1] = stair[1];

        // 두번째 계단
        if (n > 1) {
            cache[2][1] = stair[2];
            cache[2][2] = stair[1] + stair[2];
        }

        for (int i = 3; i <= n; i++) {
            cache[i][1] = Math.max(cache[i - 2][1], cache[i - 2][2]) + stair[i];
            cache[i][2] = cache[i - 1][1] + stair[i];
        }
        System.out.println(Math.max(cache[n][1], cache[n][2]));
    } // end of main
} // end of class