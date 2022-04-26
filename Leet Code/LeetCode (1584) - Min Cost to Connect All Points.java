import java.util.*;

class Solution {

    private class Edge {
        int firstId;
        int secondId;
        int dist;

        public Edge(int firstId, int secondId, int dist) {
            this.firstId = firstId;
            this.secondId = secondId;
            this.dist = dist;
        }
    }

    private int[] parent;

    private int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    private void merge(int a, int b) {
        a = find(a);
        b = find(b);

        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    private boolean isMerged(int a, int b) {
        return find(a) == find(b);
    }

    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.dist - o2.dist;
            }
        });

        //Set All Edges
        for (int i = 0, length = points.length; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int[] first = points[i];
                int[] second = points[j];
                int dist = Math.abs(first[0] - second[0]) + Math.abs(first[1] - second[1]);

                priorityQueue.add(new Edge(i, j, dist));
            }
        }

        //Set init
        parent = new int[points.length];
        for (int i = 0, length = points.length; i < length; i++) {
            parent[i] = i;
        }

        //Kruskal
        int result = 0, edgeCnt = 0;
        final int EDGE_CNT = points.length - 1;

        while (!priorityQueue.isEmpty() && edgeCnt < EDGE_CNT) {
            Edge edge = priorityQueue.poll();

            if (isMerged(edge.firstId, edge.secondId)) {
                continue;
            }

            edgeCnt++;
            result += edge.dist;
            merge(edge.firstId, edge.secondId);
        }

        return result;
    }
}