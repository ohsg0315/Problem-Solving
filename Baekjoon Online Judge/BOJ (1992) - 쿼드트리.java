import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static char[][] map;
    private static StringBuilder sb;

    private static void dq(int n, int x, int y) {
        char c = map[y][x];
        boolean complete = true;

        ex:
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if (c != map[i][j]) {
                    complete = false;
                    break ex;
                }
            }
        }

        if (complete) {
            sb.append(c);
        } else {
            sb.append('(');
            dq(n / 2, x, y);
            dq(n / 2, x + n / 2, y);
            dq(n / 2, x, y + n / 2);
            dq(n / 2, x + n / 2, y + n / 2);
            sb.append(')');
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String buf = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = buf.charAt(j);
            }
        }

        dq(N, 0, 0);
        System.out.println(sb.toString());
    } // end of main
} // end of class``