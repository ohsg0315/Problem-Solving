import java.io.*;
import java.util.*;

public class Main {
    private static class Stack {
        private int index;
        private int[] container;

        public Stack() {
            index = -1;
            container = new int[10001];
        }

        public void push(int input) {
            container[++index] = input;
        }

        public int pop() {
            if(index < 0) return -1;
            else return container[index--];
        }

        public int size() {
            return index + 1;
        }

        public int empty() {
            if (index < 0) return 1;
            else return 0;
        }

        public int top() {
            if (index < 0) return -1;
            else return container[index];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack stack = new Stack();
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");

            String command = tokenizer.nextToken();
            switch (command) {
                case "push":
                    int input = Integer.parseInt(tokenizer.nextToken());
                    stack.push(input);
                    break;
                case "pop":
                    sb.append(stack.pop()).append('\n');
                    break;
                case "size":
                    sb.append(stack.size()).append('\n');
                    break;
                case "empty":
                    sb.append(stack.empty()).append('\n');
                    break;
                case "top":
                    sb.append(stack.top()).append('\n');
                    break;
            }
        }
        System.out.print(sb.toString());
    } // end of main
} // end of class