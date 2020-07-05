import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;

        T = sc.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            ArrayList<Integer> arrayList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                arrayList.add(sc.nextInt());
            }
            Collections.sort(arrayList);

            for (int i : arrayList) {
                sb.append(i);
                sb.append(" ");
            }
            System.out.println("#" + testCase + " " + sb.toString());
        }
    }
}