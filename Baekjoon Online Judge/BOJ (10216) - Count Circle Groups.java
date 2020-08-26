import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int[] parent;
    private static Enemy[] enemies;

    private static class Enemy {
        int x, y, r;

        public Enemy(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    private static boolean isUnion(int a, int b) {
        a = find(a);
        b = find(b);

        return a == b;
    }

    private static boolean isRange(int x1, int y1, int r1, int x2, int y2, int r2) {
        double range = r1 + r2;
        double dist = Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));

        return dist <= range;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());


        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            parent = new int[n];
            enemies = new Enemy[n];
            HashSet<Integer> set = new HashSet<>();

            for (int i = 0; i < n; i++) {
                tokenizer = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(tokenizer.nextToken());
                int y = Integer.parseInt(tokenizer.nextToken());
                int r = Integer.parseInt(tokenizer.nextToken());

                parent[i] = i;
                enemies[i] = new Enemy(x, y, r);
            }

            for (int i = 0; i < n; i++) {
                Enemy cur = enemies[i];
                for (int j = 0; j < n; j++) {
                    if (i == j || isUnion(i, j)) continue;

                    Enemy next = enemies[j];
                    if (isRange(cur.x, cur.y, cur.r, next.x, next.y, next.r)) {
                        union(i, j);
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                set.add(find(i));
            }
            sb.append(set.size()).append('\n');
        } // end of while
        System.out.print(sb.toString());
    } // end of main
} // end of class