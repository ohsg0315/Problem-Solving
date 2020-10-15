import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        int n = Integer.parseInt(br.readLine());
        ArrayList<int[]> list = new ArrayList<>();
        Stack<int[]> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(tokenizer.nextToken());
            int h = Integer.parseInt(tokenizer.nextToken());

            list.add(new int[]{l, h});
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int total = 0, high = 0;
        for (int i = 0; i < n; i++) {
            int[] now = list.get(i);

            if (st.isEmpty()) {
                st.push(now);
                high = now[1];
            } else if (i == n - 1) {
                if (now[1] >= high) {
                    int[] before = {};
                    total += Math.abs(now[1] - high);
                    while (!st.isEmpty()) {
                        before = st.pop();
                    }
                    int w = (now[0] + 1) - before[0];

                    total += w * high;
                } else {
                    while (!st.isEmpty()) {
                        if (st.peek()[1] > now[1]) {
                            int w = 0;
                            if (st.peek()[1] == high) {
                                w = (now[0] + 1) - st.peek()[0];
                                total += st.peek()[1] - now[1];
                            } else {
                                w = (now[0] + 1) - (st.peek()[0] + 1);
                            }

                            total += w * now[1];
                            now = st.pop();
                        } else {
                            st.pop();
                        }
                    }
                }

            } else if (now[1] >= high) {
                int[] before = {};
                while (!st.isEmpty()) {
                    before = st.pop();
                }
                int w = now[0] - before[0];
                int h = before[1];

                total += w * h;

                st.push(now);
                high = now[1];
            } else {
                st.push(now);
            }
        }
        if (!st.isEmpty()) {
            total += st.peek()[1];
        }
        System.out.println(total);
    }
}