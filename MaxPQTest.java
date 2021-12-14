/* *****************************************************************************
 *  Name:              Jaya Mukherjee
 *  Coursera User ID:  XXXXXX
 *  Last modified:     October 23, 2021
 **************************************************************************** */

import edu.princeton.cs.algs4.MaxPQ;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MaxPQTest<Key extends Comparable<Key>> implements Iterable<Key> {

    private Key[] pq;
    private int n = 0;


    public MaxPQTest(int max) {
        pq = (Key[]) new Comparable[max + 1];
    }

    public MaxPQTest(Key[] a) {

    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void insert(Key v) {
        pq[++n] = v;
        swim(n);
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, n--);
        pq[n + 1] = null;
        sink(1);
        return max;

    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1))
                j++;
            if (!less(k, j))
                break;
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    public Iterator<Key> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Key> {

        // create a new pq
        private MaxPQ<Key> copy;

        // add all items to copy of heap
        // takes linear time since already in heap order so no keys move
        public HeapIterator() {
            copy = new MaxPQ<Key>(size());
            for (int i = 1; i <= n; i++)
                copy.insert(pq[i]);
        }

        public boolean hasNext() {
            return !copy.isEmpty();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Key next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMax();
        }
    }
}

