import java.util.*;
import java.io.*;

public class Main {
    private static int L, C;
    private static char[] crr;
    private static boolean[] selected;
    private static StringBuilder sb;
    private static TreeSet<String> ts;

    private static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'o' || c == 'u' || c == 'i') {
            return true;
        }
        return false;
    }

    private static void Permutation(int idx, int cnt, int vowel, int consonant) {
//        종료조건 : L개 조합 && 자음 2개, 모음 1개 이상
        if (cnt == L && vowel >= 1 && consonant >= 2) {
            ts.add(sb.toString());
            return;
        }
//        가지치기 : 남은 알파벳으로 길이 L을 만들지 못하면 검사 X
        if ((C - idx + cnt) < L) {
            return;
        }
        for (int i = idx; i < C; i++) {
            if (selected[i]) {
                continue;
            }
            selected[i] = true;
            sb.append(crr[i]);


            if (isVowel(crr[i])) {
                Permutation(i, cnt + 1, vowel + 1, consonant);
            } else {
                Permutation(i, cnt + 1, vowel, consonant + 1);
            }

            selected[i] = false;
            sb.delete(cnt, cnt + 2);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        L = Integer.parseInt(tokenizer.nextToken());
        C = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(br.readLine(), " ");
        sb = new StringBuilder();
        ts = new TreeSet<>();
        crr = new char[C];
        selected = new boolean[C];
        for (int i = 0; i < C; i++) {
            crr[i] = tokenizer.nextToken().charAt(0);
        }

        Arrays.sort(crr);
        Permutation(0, 0, 0, 0);

        Iterator<String> it = ts.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    } // end of main
} // end of class