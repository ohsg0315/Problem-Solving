import java.io.*;
import java.util.*;

public class Main {
    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            points[i] = new Point(x, y);
        }

        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.x == o2.x)
                    return o1.y - o2.y;
                return o1.x - o2.x;
            }
        });

        for (Point p : points) {
            sb.append(p.x).append(' ').append(p.y).append('\n');
        }
        System.out.println(sb.toString());

    } // end of main
} // end of class