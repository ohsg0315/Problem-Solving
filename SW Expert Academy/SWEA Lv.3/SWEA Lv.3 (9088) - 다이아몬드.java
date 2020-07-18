import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(tokenizer.nextToken()), K = Integer.parseInt(tokenizer.nextToken()), res = Integer.MIN_VALUE;
            int[] diamonds = new int[N];

            for (int i = 0; i < N; i++) {
                diamonds[i] = Integer.parseInt(br.readLine());
            }
            // 오름차순 정렬
            Arrays.sort(diamonds);

            // 최댓값 - 최솟값 <= K 가 될 때 -> 묶음 완성
            for (int i = 0; i < N - 1; i++) {
                // 검색하려는 나머지가 현재 최대 묶음 길이보다 작다면 검색할 필요가 없다.
                if (N - 1 - i <= res) {
                    break;
                }
                // 검색
                for (int j = N - 1; j > i; j--) {
                    if (diamonds[j] - diamonds[i] <= K) {
                        res = Math.max(res, j - i + 1);
                        break;
                    }
                }
            }
            System.out.println("#" + testCase + " " + res);
        }
    }
}