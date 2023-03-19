class BrowserHistory {

    private class Node {

        private Node prev;
        private Node next;
        private String page;

        public Node() {
        }

        public Node(Node prev, Node next, String page) {
            this.prev = prev;
            this.next = next;
            this.page = page;
        }
    }

    private Node head;
    private Node cursor;

    public BrowserHistory(String homepage) {

        head = new Node();
        head.next = new Node(head, null, homepage);
        cursor = head.next;
    }

    public void visit(String url) {
        cursor.next = new Node(cursor, null, url);
        cursor = cursor.next;
    }

    public String back(int steps) {
        while (cursor.prev != head && steps > 0) {
            cursor = cursor.prev;
            steps--;
        }

        return cursor.page;
    }

    public String forward(int steps) {
        while (cursor.next != null && steps > 0) {
            cursor = cursor.next;
            steps--;
        }

        return cursor.page;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */