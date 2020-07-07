import java.util.*;

public class Solution {
    // Binary String to Byte
    private static byte binaryStringToByte(String s) {
        byte res = 0;
        for (int i = 0; i < 8; i++) {
            res += ((s.charAt(7 - i) == '1') ? (byte) Math.pow(2, i) : 0);
        }
        return res;
    }

    // Binary String length != 6 이면 앞에 0을 채워준다.
    private static String fixLength(String s) {
        if (s.length() != 6) {
            int needs = 6 - s.length();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < needs; i++) {
                sb.append("0");
            }
            sb.append(s);

            return sb.toString();
        }
        return s;
    }

    // Decoding Table 생성
    private static void makeDecodingTable(HashMap<Character, Byte> hm) {
        for (byte i = 0; i < 62; i++) {
            if (i < 26) {
                hm.put((char) ('A' + i), i);
            } else if (26 <= i && i < 52) {
                hm.put((char) ('a' + i - 26), i);
            } else {
                hm.put((char) ('0' + i - 52), i);
            }
        }
        hm.put('+', (byte) 62);
        hm.put('/', (byte) 63);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;

        // Decoding Table
        HashMap<Character, Byte> hm = new HashMap<>();
        makeDecodingTable(hm);

        T = sc.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            String s = sc.next();
            int len = s.length();
            StringBuilder sb = new StringBuilder();

            // 문자를 Binary String으로 변환하여 sb에 저장
            for (int i = 0; i < len; i++) {
                byte buf = hm.get(s.charAt(i));
                sb.append(fixLength(Integer.toBinaryString(buf)));
            }

            s = sb.toString();
            len = s.length();
            sb.delete(0, sb.length());

            // sb에서 Binary String을 Byte 단위로 Decoding
            for (int i = 0; i < len; i += 8) {
                byte res = binaryStringToByte(s.substring(i, i + 8));
                sb.append((char) res);
            }
            // 출력
            System.out.println("#" + testCase + " " + sb.toString());
        }
    }
}