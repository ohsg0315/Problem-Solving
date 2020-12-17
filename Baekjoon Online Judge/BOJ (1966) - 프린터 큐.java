import java.io.*;
import java.util.*;

public class Main {
    private static class Number {
        int value, order;

        public Number(int value, int order) {
            this.value = value;
            this.order = order;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        StringBuilder sb = new StringBuilder();
        ArrayList<Number> list = new ArrayList<>();
        Queue<Number> qu = new LinkedList<>();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            list.clear();
            qu.clear();

            int n = Integer.parseInt(tokenizer.nextToken());
            int m = Integer.parseInt(tokenizer.nextToken());

            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                int cur = Integer.parseInt(tokenizer.nextToken());
                list.add(new Number(cur, i));
                qu.offer(new Number(cur, i));
            }

            int cnt = 0;
            Collections.sort(list, new Comparator<Number>() {
                @Override
                public int compare(Number o1, Number o2) {
                    return o2.value - o1.value;
                }
            });

            while (!qu.isEmpty()) {
                if (qu.peek().value == list.get(cnt).value) {
                    cnt++;
                    if (qu.poll().order == m) break;
                } else
                    qu.offer(qu.poll());
            }
            sb.append(cnt).append('\n');
        }
        System.out.print(sb.toString());
    } // end of main
}