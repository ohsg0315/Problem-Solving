import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    private static boolean flag = true;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static char[][] board = new char[12][6];
    private static boolean[][] visited;

    private static boolean isRange(int x, int y) {
        if (x < 0 || y < 0 || x >= 6 || y >= 12) {
            return false;
        }
        return true;
    }

    private static void bfs(int x, int y) {
        Queue<Point> qu = new LinkedList<>();
        ArrayList<Point> pointArr = new ArrayList<>();

        char standard = board[y][x];
        qu.offer(new Point(x, y));
        pointArr.add(new Point(x, y));
        visited[y][x] = true;

        while (!qu.isEmpty()) {
            Point now = qu.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (!isRange(nextX, nextY)) {
                    continue;
                }

                if (board[nextY][nextX] == standard && !visited[nextY][nextX]) {
                    qu.offer(new Point(nextX, nextY));
                    pointArr.add(new Point(nextX, nextY));
                    visited[nextY][nextX] = true;
                }
            }
        }
        // 같은 색이 4개 이상이면 터트린다
        if (pointArr.size() >= 4) {
            for (int i = 0, length = pointArr.size(); i < length; i++) {
                board[pointArr.get(i).y][pointArr.get(i).x] = '.';
            }
            flag = true;
        }
    }

    private static void refreshBoard() {
        for (int i = 10; i >= 0; i--) {
            for (int j = 0; j < 6; j++) {
                if (board[i][j] != '.') {
                    int next = i;
                    while (next + 1 < 12 && board[next + 1][j] == '.') {
                        next++;
                    }
                    if (next != i) {
                        board[next][j] = board[i][j];
                        board[i][j] = '.';
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 12; i++) {
            String buf = br.readLine();
            for (int j = 0; j < 6; j++) {
                board[i][j] = buf.charAt(j);
            }
        }

        int cnt = -1;
        while (flag) {
            cnt++;
            flag = false;
            visited = new boolean[12][6];

            // 터질 수 있는거 찾기
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (!visited[i][j] && board[i][j] != '.') {
                        bfs(j, i);
                    }
                }
            }
            // 터진게 있다면 보드 최신화
            if (flag) {
                refreshBoard();
            }
        }

        System.out.println(cnt);
    } // end of main
} // end of class