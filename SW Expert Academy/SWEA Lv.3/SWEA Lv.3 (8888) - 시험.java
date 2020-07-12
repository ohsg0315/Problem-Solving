import java.util.*;
import java.io.*;

public class Solution {
    private static class Person {
        private int score, solve, number;
        private int[] problem;

        Person(int number, int T) {
            this.score = 0;
            this.solve = 0;
            this.number = number;
            this.problem = new int[T];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            String[] buffer = br.readLine().split(" ");
            int N = Integer.parseInt(buffer[0]), T = Integer.parseInt(buffer[1]), P = Integer.parseInt(buffer[2]) - 1;
            Person[] person = new Person[N];
            int[] problemScore = new int[T];

            // 참가자 번호 P와 문제 정답 유무 입력
            for (int i = 0; i < N; i++) {
                person[i] = new Person(i, T);
                buffer = br.readLine().split(" ");
                for (int j = 0; j < T; j++) {
                    person[i].problem[j] = Integer.parseInt(buffer[j]);

                    if (person[i].problem[j] == 1) {
                        person[i].solve++;
                    }
                }
            }

            // 문제별 점수 계산
            for (int i = 0; i < T; i++) {
                int score = 0;

                for (int j = 0; j < N; j++) {
                    if (person[j].problem[i] == 0) {
                        score++;
                    }
                }
                problemScore[i] = score;
            }

            // 참가자 최종 점수
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < T; j++) {
                    if (person[i].problem[j] == 1) {
                        person[i].score += problemScore[j];
                    }
                }
            }

            // 리스트에 담아서 정렬 - 문제 조건 순으로
            ArrayList<Person> personList = new ArrayList<>();
            for (Person p : person) {
                personList.add(p);
            }

            Collections.sort(personList, new Comparator<Person>() {

                @Override
                public int compare(Person o1, Person o2) {
                    if (o1.score < o2.score) {
                        return 1;
                    } else if (o1.score == o2.score) {
                        if (o1.solve < o2.solve) {
                            return 1;
                        } else if (o1.solve == o2.solve) {
                            return o1.number - o2.number;
                        } else {
                            return -1;
                        }
                    } else {
                        return -1;
                    }
                }
            });
            // P에 해당하는 사람 찾기
            for (int i = 0; i < N; i++) {
                Person p = personList.get(i);

                if (p.number == P) {
                    System.out.println("#" + testCase + " " + p.score + " " + (i + 1));
                    break;
                }
            }

        }
    }
}