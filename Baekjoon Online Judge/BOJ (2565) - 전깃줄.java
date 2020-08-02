import java.util.*;
import java.io.*;

public class Main {
    private static int N;

    private static class Line {
        int a, b;

        public Line(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer;
        TreeSet<Integer> ts = new TreeSet<>();
        ArrayList<Line> lines = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            lines.add(new Line(a, b));
        }
        Collections.sort(lines, new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return o1.a - o2.a;
            }
        });

        ts.add(0);
        for (int i = 0; i < N; i++) {
            int b = lines.get(i).b;

            if (ts.last() > b) {
                ts.remove(ts.ceiling(b));
            }
            ts.add(b);
        }
        int res = N - (ts.size() - 1);

        System.out.println(res);
    } // end of main
} // end of class