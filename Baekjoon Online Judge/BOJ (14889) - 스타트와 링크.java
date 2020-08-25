import java.util.*;
import java.io.*;

public class Main {
    private static int n, res;
    private static int[][] list;
    private static boolean[] isSelected;
    private static ArrayList<Integer> startList, linkList;


    private static void combination(int idx, int cnt) {
        if (cnt == n / 2) {
            int start = 0, link = 0;
            startList.clear();
            linkList.clear();
            for (int i = 0; i < n; i++) {
                if (isSelected[i])
                    startList.add(i);
                else
                    linkList.add(i);
            }
            for (int i = 0; i < cnt - 1; i++) {
                int a = startList.get(i);
                int b = linkList.get(i);

                for (int j = i + 1; j < cnt; j++) {
                    int a2 = startList.get(j);
                    int b2 = linkList.get(j);

                    start += list[a][a2] + list[a2][a];
                    link += list[b][b2] + list[b2][b];
                }
            }
            if (Math.abs(start - link) < res)
                res = Math.abs(start - link);
            return;
        }
        for (int i = idx; i < n; i++) {
            isSelected[i] = true;
            combination(i + 1, cnt + 1);
            isSelected[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        res = Integer.MAX_VALUE;
        n = Integer.parseInt(br.readLine());
        list = new int[n][n];
        isSelected = new boolean[n];
        startList = new ArrayList<>();
        linkList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                list[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        combination(0, 0);
        System.out.println(res);
    } // end of main
} // end of class