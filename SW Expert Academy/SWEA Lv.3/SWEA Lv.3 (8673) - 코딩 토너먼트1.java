import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Solution {
    private static int res = 0;

    private static void tournament(ArrayList<Integer> arr) {
        int len = arr.size();
        ArrayList<Integer> winner = new ArrayList<>();

        for (int i = 0; i < len - 1; i += 2) {
            winner.add(Math.max(arr.get(i), arr.get(i + 1)));
            res += Math.abs(arr.get(i) - arr.get(i + 1));
        }

        if (winner.size() == 1) {
            return;
        } else {
            tournament(winner);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            int K = Integer.parseInt(br.readLine());
            StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
            ArrayList<Integer> arrayList = new ArrayList<>();

            for (int i = 0; tokenizer.hasMoreTokens(); i++) {
                arrayList.add(Integer.parseInt(tokenizer.nextToken()));
            }
            res = 0;
            tournament(arrayList);
            System.out.println("#" + testCase + " " + res);
        }
    }
}