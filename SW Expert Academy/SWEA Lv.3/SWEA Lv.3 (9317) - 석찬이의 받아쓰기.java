import java.util.*;

public class Solution {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt(), res = 0;
            String problem = sc.next(), answer = sc.next();

            for (int i = 0; i < N; i++) {
                if(problem.charAt(i) == answer.charAt(i)){
                    res++;
                }
            }

            System.out.println("#" + testCase + " " + res);
        }
    }
}