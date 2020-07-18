import java.util.*;
import java.io.*;

public class Solution {
    private static boolean isNextDay(int[] hour, int[] minute, int[] second) {
        if (hour[0] < hour[1]) {
            return false;
        } else if (hour[0] > hour[1]) {
            return true;
        } else {
            if (minute[0] < minute[1]) {
                return false;
            } else if (minute[0] > minute[1]) {
                return true;
            } else {
                if (second[0] < second[1]) {
                    return false;
                } else if (second[0] > second[1]) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    private static String calTime(int[] hour, int[] minute, int[] second) {
        StringBuilder sb = new StringBuilder();

        if (second[0] > second[1]) {
            second[1] += 60;
            minute[1] -= 1;
        }

        sb.insert(0, ":" + String.format("%02d", second[1] - second[0]));

        if (minute[0] > minute[1]) {
            minute[1] += 60;
            hour[1] -= 1;
        }
        sb.insert(0, ":" + String.format("%02d", minute[1] - minute[0]));
        sb.insert(0, String.format("%02d", hour[1] - hour[0]));

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            int[] hour = new int[2], minute = new int[2], second = new int[2];
            for (int i = 0; i < 2; i++) {
                tokenizer = new StringTokenizer(br.readLine(), ":");
                hour[i] = Integer.parseInt(tokenizer.nextToken());
                minute[i] = Integer.parseInt(tokenizer.nextToken());
                second[i] = Integer.parseInt(tokenizer.nextToken());
            }

            if (isNextDay(hour, minute, second)) {
                hour[1] += 24;
            }

            String res = calTime(hour, minute, second);
            System.out.println("#" + testCase + " " + res);
        }
    }
}