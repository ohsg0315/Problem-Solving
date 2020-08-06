import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    private static int n, m, res = Integer.MAX_VALUE;
    private static ArrayList<Point> chicken, minChicken, home;

    private static void combination(int idx, int cnt) {
        // 조합 치킨집 m개 고름
        if (cnt == m) {
            int total = 0;
            int[] dist = new int[home.size()];

            // 각 치킨집에서 집 사이의 거리를 구함
            for (int i = 0, length = home.size(); i < length; i++) {
                dist[i] = Integer.MAX_VALUE;
                Point p = home.get(i);

                for (int j = 0; j < m; j++) {
                    Point chic = minChicken.get(j);
                    dist[i] = Math.min(dist[i], Math.abs(p.x - chic.x) + Math.abs(p.y - chic.y));
                }
                total += dist[i];
            }
            res = Math.min(res, total);
            return;
        }
        // 조합 백트래킹
        for (int i = idx, length = chicken.size(); i < length; i++) {
            minChicken.add(chicken.get(i));
            combination(i + 1, cnt + 1);

            minChicken.remove(chicken.get(i));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        chicken = new ArrayList<>();
        minChicken = new ArrayList<>();
        home = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int buf = Integer.parseInt(tokenizer.nextToken());

                if (buf == 1) {
                    home.add(new Point(j, i));
                } else if (buf == 2) {
                    chicken.add(new Point(j, i));
                }
            }
        }
        combination(0, 0);

        System.out.println(res);
    } // end of main
} // end of class