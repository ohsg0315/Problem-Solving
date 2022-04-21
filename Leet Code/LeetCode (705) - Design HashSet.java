class MyHashSet {
    private boolean[] isContain;

    public MyHashSet() {
        isContain = new boolean[1_000_001];
    }

    public void add(int key) {
        isContain[key] = true;
    }

    public void remove(int key) {
        isContain[key] = false;
    }

    public boolean contains(int key) {
        return isContain[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */