import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    private static final int EAST = 2, WEST = 6, ALL = 0, LEFT = -1, RIGHT = 1;
    private static LinkedList<Integer>[] sawTooth;

    private static void move(int num, int rotate, int direct) {
        int original, opponent;


        // 왼쪽
        if (direct != RIGHT && 0 < num - 1) {
            original = sawTooth[num].get(WEST);
            opponent = sawTooth[num - 1].get(EAST);

            if (original != opponent) {
                move(num - 1, -rotate, LEFT);
            }
        }
        // 오른쪽
        if (direct != LEFT && num + 1 < 5) {
            original = sawTooth[num].get(EAST);
            opponent = sawTooth[num + 1].get(WEST);

            if (original != opponent) {
                move(num + 1, -rotate, RIGHT);
            }
        }

        if (rotate == 1) {
            int buf = sawTooth[num].removeLast();
            sawTooth[num].addFirst(buf);
        } else if (rotate == -1) {
            int buf = sawTooth[num].removeFirst();
            sawTooth[num].addLast(buf);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        sawTooth = new LinkedList[5];

        for (int i = 1; i < 5; i++) {
            String buf = br.readLine();
            sawTooth[i] = new LinkedList<>();
            for (int j = 0; j < 8; j++) {
                sawTooth[i].add(Integer.parseInt(buf.charAt(j) + ""));
            }
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            int number = Integer.parseInt(tokenizer.nextToken());
            int rotate = Integer.parseInt(tokenizer.nextToken());

            move(number, rotate, ALL);
        }
        int score = 0;
        for (int i = 1; i < 5; i++) {
            if (sawTooth[i].getFirst() == 1) {
                score += Math.pow(2, i - 1);
            }
        }
        System.out.println(score);
    } // end of main
} // end of class