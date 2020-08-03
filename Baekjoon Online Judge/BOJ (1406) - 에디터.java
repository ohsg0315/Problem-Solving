import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> leftStack = new Stack<>(), rightStack = new Stack<>();
        String s = br.readLine();
        int N = Integer.parseInt(br.readLine());
        int index = s.length();
        for (int i = 0; i < index; i++) {
            leftStack.push(s.charAt(i));
        }

        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            char c = command.charAt(0);

            switch (c) {
                case 'L':
                    if (index > 0) {
                        index--;
                        rightStack.push(leftStack.pop());
                    }
                    break;
                case 'D':
                    if (!rightStack.isEmpty()) {
                        index++;
                        leftStack.push(rightStack.pop());
                    }
                    break;
                case 'B':
                    if (index != 0) {
                        leftStack.pop();
                        index--;
                    }
                    break;
                case 'P':
                    char input = command.charAt(2);
                    leftStack.push(input);
                    index++;
                    break;
            }
        }

        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }
        StringBuilder sb = new StringBuilder(rightStack.size());
        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }
        System.out.println(sb);
    } // end of main
} // end of class