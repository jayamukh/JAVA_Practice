/* *****************************************************************************
 *  Name:              Jaya Mukherjee
 *  Coursera User ID:  123456
 *  Last modified:     June 13, 2021
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class ResizingArrayQueueT<T> implements Iterable<T> {

    private T[] a = (T[]) new Object[1];
    private int head = 0;
    private int n = 0;
    private int tail = 0;


    public boolean isEmpty() {

        return n == 0;
    }

    public void enqueue(T item) {
        if (n == a.length) {
            resize(2 * a.length);
        }
        a[tail++] = item;
        if (tail == a.length) tail = 0;          // wrap-around
        n++;
    }

    public T dequeue() {
        T item = a[head];
        a[head] = null;                            // to avoid loitering
        n--;
        head++;
        if (head == a.length) head = 0;           // wrap-around
        // shrink size of array if necessary
        if (n > 0 && n == a.length / 4) resize(a.length / 2);
        return item;
    }

    public void resize(int max) {

        if (max > n) {
            T[] temp = (T[]) new Object[max];
            for (int i = 0; i < n; i++) {
                temp[i] = a[(head + i) % a.length];
            }
            a = temp;
            tail = n;
            head = 0;
        }

    }

    public Iterator<T> iterator() {
        return new ReverseArrayIteratorT();
    }

    private class ReverseArrayIteratorT implements Iterator<T> {
        private int i = n;

        public boolean hasNext() {
            return i > 0;
        }

        public T next() {
            return a[--i];
        }
    }

    public static void main(String[] args) {
        ResizingArrayQueueT<String> q;
        q = new ResizingArrayQueueT<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                q.enqueue(item);
            }
            else if (!q.isEmpty()) {
                StdOut.println(q.dequeue() + " ");
            }
        }
        StdOut.println(q.size() + " left on queue");
    }
}
