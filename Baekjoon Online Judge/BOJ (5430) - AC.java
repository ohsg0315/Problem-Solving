import java.util.*;
import java.io.*;

public class Main {
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            sb.setLength(0);
            String command = br.readLine();
            int listSize = Integer.parseInt(br.readLine());
            boolean isReverse = false, isComplete = true;

            String input = br.readLine();
            LinkedList<String> list = new LinkedList<>(Arrays.asList(input.substring(1, input.length() - 1).split(",")));

            for (int i = 0, size = command.length(); i < size; i++) {
                char c = command.charAt(i);

                if (c == 'R') {
                    isReverse = !isReverse;
                } else if (c == 'D') {
                    if (listSize == 0) {
                        sb.append("error");
                        isComplete = false;
                        break;
                    } else {
                        listSize--;
                        if (!isReverse) {
                            list.removeFirst();
                        } else {
                            list.removeLast();
                        }
                    }
                }
            } // end of for
            if (isComplete) {
                sb.append('[');
                if (!isReverse) {
                    for (int i = 0; i < listSize; i++) {
                        sb.append(list.get(i)).append(',');
                    }
                } else {
                    for (int i = listSize - 1; i >= 0; i--) {
                        sb.append(list.get(i)).append(',');
                    }
                }
                if (sb.length() != 1) {
                    sb.setCharAt(sb.length() - 1, ']');
                } else {
                    sb.append(']');
                }
            }
            System.out.println(sb.toString());
        } // end of while
    } // end of main
} // end of class