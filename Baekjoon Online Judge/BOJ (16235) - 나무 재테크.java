import java.util.*;
import java.io.*;

public class Main {
    private static int n, m, k;
    private static int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
    private static int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1};
    private static int[][] A, map;
    private static PriorityQueue<Tree> pq, alive, die;

    private static class Tree implements Comparable<Tree> {
        int x, y, age;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }

    private static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    private static void spring() {
        while (!pq.isEmpty()) {
            Tree tree = pq.poll();
            // 죽은 나무
            if (tree.age > map[tree.y][tree.x]) {
                die.offer(new Tree(tree.x, tree.y, tree.age));
            }
            // 나무 자람
            else {
                map[tree.y][tree.x] -= tree.age;
                alive.offer(new Tree(tree.x, tree.y, tree.age + 1));
            }
        }
    }

    private static void summer() {
        while (!die.isEmpty()) {
            Tree tree = die.poll();
            map[tree.y][tree.x] += tree.age / 2;
        }
    }

    private static void fall() {
        while (!alive.isEmpty()) {
            Tree tree = alive.poll();

            // 나무 나이가 5의 배수이면 번식
            if (tree.age % 5 == 0) {
                for (int i = 0; i < 8; i++) {
                    int nextX = tree.x + dx[i];
                    int nextY = tree.y + dy[i];

                    if (!isRange(nextX, nextY)) continue;

                    pq.offer(new Tree(nextX, nextY, 1));
                }
            }
            pq.offer(tree);
        }
    }

    private static void winter() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] += A[i][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        pq = new PriorityQueue<>();
        die = new PriorityQueue<>();
        alive = new PriorityQueue<>();

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        k = Integer.parseInt(tokenizer.nextToken());
        A = new int[n][n];
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                A[i][j] = Integer.parseInt(tokenizer.nextToken());
                map[i][j] = 5;
            }
        }

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(tokenizer.nextToken()) - 1;
            int x = Integer.parseInt(tokenizer.nextToken()) - 1;
            int age = Integer.parseInt(tokenizer.nextToken());

            pq.offer(new Tree(x, y, age));
        }

        while (k-- > 0) {
            spring();
            summer();
            fall();
            winter();
        }
        System.out.println(pq.size());
    }
}