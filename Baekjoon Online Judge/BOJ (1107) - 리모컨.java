import java.util.*;
import java.io.*;

public class Main {
    private static boolean isPossible(int N, boolean[] brokenNum) {
        int buf = N;
        if (buf == 0 && brokenNum[buf]) {
            return false;
        }
        while (buf != 0) {
            if (brokenNum[buf % 10]) {
                return false;
            }
            buf /= 10;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine()), res = Integer.MIN_VALUE;
        boolean[] brokenNum = new boolean[11]; // brokenNum[10]은 for문 빠져나가기 위해 생성
        if (M != 0) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
            while (tokenizer.hasMoreTokens()) {
                brokenNum[Integer.parseInt(tokenizer.nextToken())] = true;
            }
        }
//        +, - 만 이용
        res = Math.abs(N - 100);

//        키보드 다 부서졌으면 할 필요없음
        if (M != 10) {
//        한번에 갈 수 있는 경우
            if (isPossible(N, brokenNum)) {
                res = Math.min(res, Integer.toString(N).length());
            }
//        한번에 못 가는 경우
            else {
                for (int i = 1; i < res; i++) {
                    if ((N - i) >= 0 && isPossible(N - i, brokenNum)) {
                        res = Math.min(res, Integer.toString(N - i).length() + i);
                        brokenNum[10] = true;
                    }
                    if (isPossible(N + i, brokenNum)) {
                        res = Math.min(res, Integer.toString(N + i).length() + i);
                        brokenNum[10] = true;
                    }
                    if (brokenNum[10]) {
                        break;
                    }
                }
            }
        }
        System.out.println(res);
    } // end of main
} // end of class