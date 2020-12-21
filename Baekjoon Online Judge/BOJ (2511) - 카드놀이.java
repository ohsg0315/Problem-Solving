import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        int A = 0, B = 0;
        int[][] player = new int[2][10];
        for (int i = 0; i < 2; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 10; j++) {
                player[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        for (int i = 0; i < 10; i++) {
            if (player[0][i] > player[1][i]) A += 3;
            else if (player[0][i] < player[1][i]) {
                B += 3;
            } else {
                A++;
                B++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(A).append(' ').append(B).append('\n');
        if (A > B) sb.append('A');
        else if (A < B) sb.append('B');
        else {
            int i;
            for (i = 9; i >= 0; i--) {
                if (player[0][i] > player[1][i]) {
                    sb.append('A');
                    break;
                } else if (player[0][i] < player[1][i]) {
                    sb.append('B');
                    break;
                }
            }
            if(i == -1) sb.append('D');
        }

        sb.append('\n');
        System.out.print(sb.toString());
    } // end of main
} // end of class