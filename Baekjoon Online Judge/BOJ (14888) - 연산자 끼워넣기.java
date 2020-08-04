import java.util.*;
import java.io.*;

public class Main {
    private static long N, maxRes = Integer.MIN_VALUE, minRes = Integer.MAX_VALUE;
    private static int[] operatorNum, numbers;
    private static char[] operator = {'+', '-', 'x', '÷'};

    private static void dfs(long total, int cnt) {
        if (cnt == N) {
            if (total > maxRes) {
                maxRes = total;
            }
            if (total < minRes) {
                minRes = total;
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (operatorNum[i] > 0) {
                operatorNum[i]--;
                switch (operator[i]) {
                    case '+':
                        dfs(total + numbers[cnt], cnt + 1);
                        break;
                    case '-':
                        dfs(total - numbers[cnt], cnt + 1);
                        break;
                    case 'x':
                        dfs(total * numbers[cnt], cnt + 1);
                        break;
                    case '÷':
                        dfs(total / numbers[cnt], cnt + 1);
                        break;
                }
                operatorNum[i]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        numbers = new int[(int) N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
        }
        tokenizer = new StringTokenizer(br.readLine());
        operatorNum = new int[4];
        for (int i = 0; i < 4; i++) {
            operatorNum[i] = Integer.parseInt(tokenizer.nextToken());
        }
        dfs(numbers[0], 1);
        System.out.println(maxRes);
        System.out.println(minRes);
    } // end of main
} // end of class