import java.util.*;
import java.io.*;

public class Solution {
    private static ArrayList<Integer> res[];

    private static void makeTree(List<Integer> numArr, int level) {
        int len = numArr.size(), mid = len / 2;
        res[level].add(numArr.get(mid));

        if (len == 3) {
            res[level + 1].add(numArr.get(0));
            res[level + 1].add(numArr.get(2));
            return;
        } else {
            makeTree(numArr.subList(0, mid), level + 1);
            makeTree(numArr.subList(mid + 1, len), level + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            int K = Integer.parseInt(br.readLine());
            tokenizer = new StringTokenizer(br.readLine(), " ");
            ArrayList<Integer> numArr = new ArrayList<>();

            while (tokenizer.hasMoreTokens()) {
                numArr.add(Integer.parseInt(tokenizer.nextToken()));
            }
            res = new ArrayList[K];
            for (int i = 0; i < K; i++) {
                res[i] = new ArrayList<>();
            }
            makeTree(numArr, 0);

            for (int i = 0; i < K; i++) {
                if (i == 0) {
                    System.out.println("#" + testCase + " " + res[i].get(0));
                    continue;
                }
                int size = res[i].size();
                for (int j = 0; j < size; j++) {
                    System.out.print(res[i].get(j) + " ");
                }
                System.out.println();
            }

        }
    }
}