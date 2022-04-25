// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
    private Integer now;
    private boolean isFinish;
    private Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        this.now = iterator.next();
        this.isFinish = false;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return this.now;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int res = this.now;
        this.isFinish = !iterator.hasNext();
        this.now = this.isFinish ? -1 : this.iterator.next();
        return res;
    }

    @Override
    public boolean hasNext() {
        return !this.isFinish;
    }
}