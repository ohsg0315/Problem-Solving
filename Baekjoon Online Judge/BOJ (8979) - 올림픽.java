import java.io.*;
import java.util.*;

public class Main {
    private static class Country {
        int gold, silver, bronze, number;

        public Country(int number, int gold, int silver, int bronze) {
            this.number = number;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());
        ArrayList<Country> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            int number = Integer.parseInt(tokenizer.nextToken());
            int gold = Integer.parseInt(tokenizer.nextToken());
            int silver = Integer.parseInt(tokenizer.nextToken());
            int bronze = Integer.parseInt(tokenizer.nextToken());

            list.add(new Country(number, gold, silver, bronze));
        }
        Collections.sort(list, new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                if (o1.gold == o2.gold) {
                    if (o1.silver == o2.silver) {
                        if (o1.bronze == o2.bronze) {
                            if (o1.number == k) {
                                return -1;
                            } else if (o2.number == k) {
                                return 1;
                            } else {
                                return 0;
                            }
                        }
                        return o2.bronze - o1.bronze;
                    }
                    return o2.silver - o1.silver;
                }
                return o2.gold - o1.gold;
            }
        });

        int rank = 1;
        for (Country c : list) {
            if (c.number == k) break;
            rank++;
        }
        System.out.println(rank);
    } // end of main
} // end of class