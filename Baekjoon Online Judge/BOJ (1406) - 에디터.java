import java.util.*;
import java.io.*;

public class Main {
    // LinkedList 사용
    private static void editorLinkedList() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int N = Integer.parseInt(br.readLine());
        int index = s.length();
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < index; i++) {
            list.add(s.charAt(i));
        }
        ListIterator it = list.listIterator(list.size());

        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            char c = command.charAt(0);

            switch (c) {
                case 'L':
                    if (it.hasPrevious()) {
                        it.previous();
                    }
                    break;
                case 'D':
                    if (it.hasNext()) {
                        it.next();
                    }
                    break;
                case 'B':
                    if (it.hasPrevious()) {
                        it.previous();
                        it.remove();
                    }
                    break;
                case 'P':
                    char input = command.charAt(2);
                    it.add(input);
                    break;
            }
        }
        StringBuilder sb = new StringBuilder(list.size());
        Iterator<Character> iter = list.iterator();
        while (iter.hasNext()) {
            sb.append(iter.next());
        }
        System.out.println(sb);
    }

    // Stack 사용
    private static void editorStack() throws IOException {
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
    }

    public static void main(String[] args) throws IOException {
        editorLinkedList(); // 좀 더 빠르다.
        // editorStack();
    } // end of main
} // end of class