import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] parent = new int[n];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (parent[i] == 0) {
                queue.clear();
                queue.add(i);
                parent[i] = 1;

                while (!queue.isEmpty()) {
                    int cur = queue.poll();

                    for (int adjacent : graph[cur]) {
                        if (parent[adjacent] == 0) {
                            parent[adjacent] = -parent[cur];
                            queue.add(adjacent);
                        } else if (parent[adjacent] != -parent[cur]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}