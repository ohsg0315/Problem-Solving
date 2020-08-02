import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    private static int N, direction = 3;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static int[] L = {2, 3, 1, 0};
    private static int[] D = {3, 2, 0, 1};
    private static int[][] map;
    private static HashMap<Integer, Character> command;

    private static boolean isRange(int x, int y) {
        if (x <= 0 || y <= 0 || x > N || y > N) {
            return false;
        }
        return true;
    }

    private static int game() {
        int cnt = 0;
        Deque<Point> snake = new ArrayDeque<>();

        snake.offer(new Point(1, 1));
        map[1][1] = -1;

        while (true) {
            // 방향 바꿔야 하면 바꿈
            if (command.containsKey(cnt)) {
                if (command.get(cnt) == 'L') {
                    direction = L[direction];
                } else if (command.get(cnt) == 'D') {
                    direction = D[direction];
                }
            }
            int nextX = snake.getFirst().x + dx[direction], nextY = snake.getFirst().y + dy[direction];
            cnt++;

            // 밖으로 나가거나 몸에 닿으면 게임 끝
            if (!isRange(nextX, nextY) || map[nextY][nextX] == -1) {
                return cnt;
            }

            // 이동
            if (map[nextY][nextX] == 1) {   // 사과 득탬
                snake.offerFirst(new Point(nextX, nextY));
            } else {    // 그런거 없음
                snake.offerFirst(new Point(nextX, nextY));
                map[snake.peekLast().y][snake.peekLast().x] = 0;
                snake.pollLast();
            }
            map[nextY][nextX] = -1;
        }
    }


    public static void main(String[] args) throws IOException {
        // 뱀은 처음에 오른쪽 방향
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        // 값 입력
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        command = new HashMap<>();
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            map[Integer.parseInt(tokenizer.nextToken())][Integer.parseInt(tokenizer.nextToken())] = 1;
        }
        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            command.put(Integer.parseInt(tokenizer.nextToken()), tokenizer.nextToken().charAt(0));
        }
        System.out.println(game());
    } // end of main
} // end of class