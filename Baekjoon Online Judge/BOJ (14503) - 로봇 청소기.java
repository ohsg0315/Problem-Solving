import java.util.*;
import java.io.*;

public class Main {
    private static int n, m, res;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};
    private static int[][] map;
    private static boolean[][] cleaned;

    private static void dfs(int x, int y, int dir) {
        //    1. 현재 위치 청소
        if (!cleaned[y][x]) res++;
        cleaned[y][x] = true;
        int nextX, nextY, nextDir = dir;

        //    2.현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
        for (int i = 0; i < 4; i++) {
            nextDir = nextDir - 1 >= 0 ? nextDir - 1 : 3;
            nextX = x + dx[nextDir];
            nextY = y + dy[nextDir];

            //    왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
            if (map[nextY][nextX] == 0 && !cleaned[nextY][nextX]) {
                dfs(nextX, nextY, nextDir);
                return;
            }
            //    왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
        }

        //    네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
        //    네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
        nextX = x - dx[dir];
        nextY = y - dy[dir];

        if (map[nextY][nextX] == 1) return;
        else {
            dfs(nextX, nextY, dir);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        map = new int[n][m];
        cleaned = new boolean[n][m];

        tokenizer = new StringTokenizer(br.readLine(), " ");
        int y = Integer.parseInt(tokenizer.nextToken());
        int x = Integer.parseInt(tokenizer.nextToken());
        int dir = Integer.parseInt(tokenizer.nextToken());

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        dfs(x, y, dir);
        System.out.println(res);
    } // end of main
} // end of class
