import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		for (int testCase = 1; testCase <= T; testCase++) {
			int Len = Integer.parseInt(br.readLine()), res = 0;
			String s = br.readLine();
			StringBuilder sb = new StringBuilder();
			Stack<Integer> st = new Stack<>();

			for (int i = 0; i < Len; i++) {
				char c = s.charAt(i);

				if (c == '+') {
					if (i + 2 < Len && s.charAt(i + 2) == '+') {
						sb.append(s.charAt(i + 1));
						sb.append(c);
						i++;
					} else if (i + 2 < Len && s.charAt(i + 2) == '*') {
						int j = i + 2;
						boolean flag = true;
						while (s.charAt(j) == '*') {
							if (flag) {
								sb.append(s.charAt(j - 1));
								flag = false;
							}
							sb.append(s.charAt(j + 1));
							sb.append(s.charAt(j));

							j += 2;
							if (j >= Len) {
								break;
							}
						}
						sb.append(c);
						i = j - 1;
					} else {
						sb.append(s.charAt(i + 1));
						sb.append(c);
						i++;
					}
				} else if (c == '*') {
					sb.append(s.charAt(i + 1));
					sb.append(c);
					i++;
				} else {
					sb.append(c);
				}
			} // end of for

			s = sb.toString();
			for (int i = 0; i < Len; i++) {
				char c = s.charAt(i);

				if (c != '+' && c != '*') {
					st.push(Integer.parseInt(c + ""));
				} else {
					int a = st.pop();
					int b = st.pop();

					if (c == '+') {
						a += b;
					} else {
						a *= b;
					}
					st.push(a);
				}
			}
			System.out.println("#" + testCase + " " + st.pop());
		} // end of testCase
	} // end of main
} // end of class
