import java.util.*;
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Integer, Node> map = new HashMap<>();

    private Node search(Node node) {
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }

        map.put(node.val, new Node(node.val));

        for (Node neighbor : node.neighbors) {
            map.get(node.val).neighbors.add(search(neighbor));
        }

        return map.get(node.val);
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        } else if (node.neighbors.size() == 0) {
            return new Node(node.val);
        }

        return search(node);
    }
}