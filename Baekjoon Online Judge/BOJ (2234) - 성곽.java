import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static int[][] map;
    private static boolean[][] visited, check;
    private static ArrayList<Room> rooms;

    private static class Room {
        int x, y, size;

        public Room(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }
    }

    private static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    private static void bfs(int x, int y, boolean flag) {
        int size = 0;
        Queue<int[]> qu = new LinkedList<>();

        visited[y][x] = true;
        qu.offer(new int[]{x, y});

        while (!qu.isEmpty()) {
            size++;
            int[] now = qu.poll();

            for (int i = 0; i < 4; i++) {
                if ((map[now[1]][now[0]] & 1 << i) == 0) {
                    int nextX = now[0] + dx[i];
                    int nextY = now[1] + dy[i];

                    if (isRange(nextX, nextY) && !visited[nextY][nextX]) {
                        visited[nextY][nextX] = true;
                        qu.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }
        if (flag) rooms.add(new Room(x, y, size));
    }

    private static int isMerge(int x, int y) {
        int res = 0;
        Queue<int[]> qu = new LinkedList<>();

        check[y][x] = true;
        qu.offer(new int[]{x, y});

        while (!qu.isEmpty()) {
            res++;
            int[] now = qu.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];

                if (!isRange(nextX, nextY)) continue;

                if (visited[nextY][nextX] && !check[nextY][nextX]) {
                    check[nextY][nextX] = true;
                    qu.offer(new int[]{nextX, nextY});
                }
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        map = new int[m][n];
        visited = new boolean[m][n];
        rooms = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) bfs(j, i, true);
            }
        }

        Collections.sort(rooms, new Comparator<Room>() {
            @Override
            public int compare(Room o1, Room o2) {
                return o2.size - o1.size;
            }
        });

        int roomSize = rooms.size(), maxRoomSize = rooms.get(0).size;
        ArrayList<Room[]> mergeRooms = new ArrayList<>();

        for (int i = 0; i < roomSize - 1; i++) {
            for (int j = i + 1; j < roomSize; j++) {
                mergeRooms.add(new Room[]{rooms.get(i), rooms.get(j)});
            }
        }

        Collections.sort(mergeRooms, new Comparator<Room[]>() {
            @Override
            public int compare(Room[] o1, Room[] o2) {
                return (o2[0].size + o2[1].size) - (o1[0].size + o1[1].size);
            }
        });

        System.out.println(rooms.size());
        System.out.println(maxRoomSize);

        for (Room[] mergeRoom : mergeRooms) {
            Room first = mergeRoom[0], second = mergeRoom[1];

            check = new boolean[m][n];
            visited = new boolean[m][n];

            bfs(first.x, first.y, false);
            bfs(second.x, second.y, false);

            label:
            for (int y = 0; y < m; y++) {
                for (int x = 0; x < n; x++) {
                    if (visited[y][x]) {
                        int cur = isMerge(x, y);
                        if (cur == first.size + second.size) {
                            System.out.println(cur);
                            return;
                        } else break label;
                    }
                }
            }
        }
    }
}