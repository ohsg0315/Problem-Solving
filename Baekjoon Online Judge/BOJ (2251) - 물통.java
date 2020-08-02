import java.util.*;
import java.io.*;

public class Main {
    private static int[] bottle = new int[3];
    private static TreeSet<Integer> ts = new TreeSet<>();
    private static boolean visited[][][];

    private static class Water {
        int A, B, C;

        public Water(int a, int b, int c) {
            A = a;
            B = b;
            C = c;
        }
    }

    private static void bfs() {
        Queue<Water> qu = new LinkedList<>();
        qu.offer(new Water(0, 0, bottle[2]));
        visited[0][0][bottle[2]] = true;

        while (!qu.isEmpty()) {
            int A = qu.peek().A;
            int B = qu.peek().B;
            int C = qu.peek().C;
            qu.poll();

            if (A == 0) {
                ts.add(C);
            }

            // 하드코딩 오바
            // A to B
            if (A + B > bottle[1] && !visited[A + B - bottle[1]][bottle[1]][C]) {
                qu.offer(new Water(A + B - bottle[1], bottle[1], C));
                visited[A + B - bottle[1]][bottle[1]][C] = true;
            } else if (A + B <= bottle[1] && !visited[0][A + B][C]) {
                qu.offer(new Water(0, A + B, C));
                visited[0][A + B][C] = true;
            }
            // A to C
            if (A + C > bottle[2] && !visited[A + C - bottle[2]][B][bottle[2]]) {
                qu.offer(new Water(A + C - bottle[2], B, bottle[2]));
                visited[A + C - bottle[2]][B][bottle[2]] = true;
            } else if (A + C <= bottle[2] && !visited[0][B][A + C]) {
                qu.offer(new Water(0, B, A + C));
                visited[0][B][A + C] = true;
            }
            // B to A
            if (A + B > bottle[0] && !visited[bottle[0]][A + B - bottle[0]][C]) {
                qu.offer(new Water(bottle[0], A + B - bottle[0], C));
                visited[bottle[0]][A + B - bottle[0]][C] = true;
            } else if (A + B <= bottle[0] && !visited[A + B][0][C]) {
                qu.offer(new Water(A + B, 0, C));
                visited[A + B][0][C] = true;
            }
            // B to C
            if (B + C > bottle[2] && !visited[A][B + C - bottle[2]][bottle[2]]) {
                qu.offer(new Water(A, B + C - bottle[2], bottle[2]));
                visited[A][B + C - bottle[2]][bottle[2]] = true;
            } else if (B + C <= bottle[2] && !visited[A][0][B + C]) {
                qu.offer(new Water(A, 0, B + C));
                visited[A][0][B + C] = true;
            }
            // C to A
            if (A + C > bottle[0] && !visited[bottle[0]][B][A + C - bottle[0]]) {
                qu.offer(new Water(bottle[0], B, A + C - bottle[0]));
                visited[bottle[0]][B][A + C - bottle[0]] = true;
            } else if (A + C <= bottle[0] && !visited[A + C][B][0]) {
                qu.offer(new Water(A + C, B, 0));
                visited[A + C][B][0] = true;
            }
            // C to B
            if (B + C > bottle[1] && !visited[A][bottle[1]][B + C - bottle[1]]) {
                qu.offer(new Water(A, bottle[1], B + C - bottle[1]));
                visited[A][bottle[1]][B + C - bottle[1]] = true;
            } else if (B + C <= bottle[1] && !visited[A][B + C][0]) {
                qu.offer(new Water(A, B + C, 0));
                visited[A][B + C][0] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 3; i++) {
            bottle[i] = Integer.parseInt(tokenizer.nextToken());
        }
        visited = new boolean[bottle[0] + 1][bottle[1] + 1][bottle[2] + 1];
        StringBuilder sb = new StringBuilder();
        bfs();

        Iterator<Integer> it = ts.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append(" ");
        }
        System.out.println(sb.toString().trim());
    } // end of main
} // end of class