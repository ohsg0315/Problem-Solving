import java.util.*;
import java.io.*;

public class Main {
    private static int r, c, k, h, w, res = 0;
    private static int[][] arr;
    private static HashMap<Integer, Integer> hm;
    private static ArrayList<Number> list;

    private static class Number {
        int n, cnt;

        public Number(int n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }
    }

    private static ArrayList<Number> sortByValue(HashMap<Integer, Integer> map) {
        ArrayList<Number> list = new ArrayList();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(new Number(entry.getKey(), entry.getValue()));
        }
        Collections.sort(list, (o1, o2) -> {
            if (o1.cnt == o2.cnt) {
                return o1.n - o2.n;
            }
            return o1.cnt - o2.cnt;
        });
        return list;
    }

    private static int[][] deepCopy(int[][] cur) {
        int[][] next = new int[100][100];

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                next[i][j] = cur[i][j];
            }
        }
        return next;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        r = Integer.parseInt(tokenizer.nextToken()) - 1;
        c = Integer.parseInt(tokenizer.nextToken()) - 1;
        k = Integer.parseInt(tokenizer.nextToken());
        arr = new int[100][100];
        hm = new HashMap<>();

        h = w = 3;
        for (int i = 0; i < 3; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        while (res <= 100 && arr[r][c] != k) {
            res++;
            // R 연산
            if (h >= w) {
                int wBuf = 0;
                for (int i = 0; i < h; i++) {
                    for (int j = 0; j < w; j++) {
                        if (arr[i][j] == 0) continue;
                        hm.put(arr[i][j], hm.getOrDefault(arr[i][j], 0) + 1);
                        arr[i][j] = 0;
                    }
                    list = sortByValue(hm);
                    for (int j = 0, size = list.size(); j < size; j++) {
                        int n = list.get(j).n;
                        int cnt = list.get(j).cnt;
                        int idx = j * 2;

                        if (idx + 2 > 100) break;

                        arr[i][idx] = n;
                        arr[i][idx + 1] = cnt;
                        wBuf = Math.max(wBuf, idx + 2);
                    }
                    hm.clear();
                }
                w = wBuf;
            }
            // C 연산
            else {
                int hBuf = 0;
                int[][] buf = deepCopy(arr);
                for (int i = 0; i < w; i++) {
                    for (int j = 0; j < h; j++) {
                        if (arr[j][i] == 0) continue;
                        hm.put(arr[j][i], hm.getOrDefault(arr[j][i], 0) + 1);
                        buf[j][i] = 0;
                    }
                    list = sortByValue(hm);
                    for (int j = 0, size = list.size(); j < size; j++) {
                        int n = list.get(j).n;
                        int cnt = list.get(j).cnt;
                        int idx = j * 2;

                        if (idx + 2 > 100) break;

                        buf[idx][i] = n;
                        buf[idx + 1][i] = cnt;
                        hBuf = Math.max(hBuf, idx + 2);
                    }
                    hm.clear();
                }
                h = hBuf;
                arr = buf;
            }
        }
        if (res > 100) res = -1;
        System.out.println(res);
    } // end of main
} // end of class