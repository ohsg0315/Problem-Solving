import java.util.*;
import java.io.*;

public class Main {
    private static int n, res;
    private static int[] player;
    private static int[][] info;
    private static boolean[] selected;

    private static void playGame() {
        int outCnt = 0, cur = 0, inning = 0, score = 0;
        boolean[] base = new boolean[3];

        while (inning < n) {
            switch (info[inning][player[cur]]) {
                case 0:
                    outCnt++;
                    // 이닝 종료
                    if (outCnt == 3) {
                        // 이닝 초기화
                        for (int i = 0; i < 3; i++) {
                            base[i] = false;
                        }
                        outCnt = 0;
                        inning++; // 이닝 늘림
                    }
                    break;
                case 1:
                    // 안타 : 모든 주자 1루 진출
                    for (int i = 2; i >= 0; i--) {
                        if (base[i]) {
                            if (i == 2) {
                                score++;
                                base[i] = false;
                            } else {
                                base[i + 1] = true;
                                base[i] = false;
                            }
                        }
                    }
                    base[0] = true; // 타자 1루 진출
                    break;
                case 2:
                    // 2루타 : 모든 주자 2루 진출
                    for (int i = 2; i >= 0; i--) {
                        if (base[i]) {
                            if (i > 0) {
                                score++;
                                base[i] = false;
                            } else {
                                base[i + 2] = true;
                                base[i] = false;
                            }
                        }
                    }
                    base[1] = true; // 타자 2루 진출
                    break;
                case 3:
                    // 3루타 : 모든 주자 홈인
                    for (int i = 2; i >= 0; i--) {
                        if (base[i]) {
                            score++;
                            base[i] = false;
                        }
                    }
                    base[2] = true; // 타자 3루 진출
                    break;
                case 4:
                    // 홈런 : 모든 주자 홈인
                    for (int i = 2; i >= 0; i--) {
                        if (base[i]) {
                            score++;
                            base[i] = false;
                        }
                    }
                    score++; // 타자 홈인
                    break;
            } // end of switch

            // 다음 타자
            cur = (cur + 1) % 9;
        } // end of while
        if (score > res) {
            res = score;
        }
    } // end of method

    private static void permutation(int cnt) {
        // 타순이 다 정해짐
        if (cnt == 9) {
            playGame();
            return;
        }
        // 4번 타자는 고정
        if (cnt == 3) {
            permutation(cnt + 1);
            return;
        }
        // 순열
        for (int i = 1; i < 9; i++) {
            if (!selected[i]) {
                selected[i] = true;
                player[cnt] = i;
                permutation(cnt + 1);

                selected[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        n = Integer.parseInt(br.readLine());
        player = new int[9];
        selected = new boolean[9];
        Arrays.fill(player, -1);
        info = new int[n][9];
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < 9; j++) {
                info[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        // 1번 선수는 4번 타자
        player[3] = 0;
        selected[0] = true;

        permutation(0);
        System.out.println(res);
    } // end of main
} // end of class