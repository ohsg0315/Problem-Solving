import java.util.*;
import java.io.*;

public class Main {
    private static int n, m, res;
    private static boolean[] fact, team;
    private static ArrayList<Integer>[] party;

    private static void bfs() {
        Queue<Integer> qu = new LinkedList<>();

        for (int i = 0; i < party[0].size(); i++) {
            qu.offer(party[0].get(i));
        }

        while (!qu.isEmpty()) {
            int now = qu.poll();

            for (int i = 1, length = party.length; i < length; i++) {
                if (party[i].contains(now)) {
                    team[i] = true;
                    for (int j = 0, size = party[i].size(); j < size; j++) {
                        int buf = party[i].get(j);

                        if (!fact[buf]) {
                            fact[buf] = true;
                            qu.offer(buf);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        res = m;
        fact = new boolean[n + 1];
        team = new boolean[m + 1];
        party = new ArrayList[m + 1];
        tokenizer = new StringTokenizer(br.readLine(), " ");
        int factNum = Integer.parseInt(tokenizer.nextToken());
        // 진실
        party[0] = new ArrayList<>();
        for (int i = 1; i <= factNum; i++) {
            int buf = Integer.parseInt(tokenizer.nextToken());
            fact[buf] = true;

            party[0].add(buf);
        }

        for (int i = 1; i <= m; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            party[i] = new ArrayList<>();
            tokenizer.nextToken();
            while (tokenizer.hasMoreTokens()) {
                party[i].add(Integer.parseInt(tokenizer.nextToken()));
            }
        }
        bfs();
        for (int i = 1; i <= m; i++) {
            if (team[i])
                res--;
        }
        System.out.println(res);
    } // end of main
} // end of class