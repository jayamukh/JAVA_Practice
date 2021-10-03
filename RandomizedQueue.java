/* *****************************************************************************
 *  Name:              Jaya Mukherjee
 *  Coursera User ID:  123456
 *  Last modified:     June 13, 2021
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] a;
    private int size;

    // construct an empty randomized queue
    public RandomizedQueue() {
        a = (Item[]) new Object[1];
        size = 0;
    }

    private void resize(int max) {
        if (max > size) {
            Item[] temp = (Item[]) new Object[max];
            for (int i = 0; i < size; i++) {
                temp[i] = a[i];
            }
            a = temp;
        }
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        if (size == a.length) {
            resize(2 * a.length);
        }
        a[size++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("there are no more items!");
        }

        int r = StdRandom.uniform(0, size);
        Item item = a[r];
        a[r] = a[size - 1];
        a[size - 1] = null;
        size--;
        if (size > 0 && size == a.length / 4) resize(a.length / 2);
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (size == 0) {
            throw new NoSuchElementException("there are no more items!");
        }
        int r = StdRandom.uniform(0, size);
        Item item = a[r];
        return item;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new ReverseArrayIteratorItem();
    }

    private class ReverseArrayIteratorItem implements Iterator<Item> {
        private int i;
        private Item[] iter;

        ReverseArrayIteratorItem() {
            i = size;
            iter = (Item[]) new Object[size];
            for (int j = 0; j < size; j++) {
                iter[j] = a[j];
            }
        }

        public boolean hasNext() {
            return i > 0;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (i <= 0) {
                throw new NoSuchElementException("there are no more items!");
            }
            int r = StdRandom.uniform(0, i);
            Item item = iter[r];
            iter[r] = iter[i - 1];
            iter[i - 1] = item;
            i--;
            return item;
        }
    }

    public static void main(String[] args) {
        RandomizedQueue<String> queue = new RandomizedQueue<String>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");
        queue.dequeue();
        StdOut.println(queue.size);
        Iterator<String> iter1 = queue.iterator();
        Iterator<String> iter2 = queue.iterator();
        while (iter1.hasNext()) {
            StdOut.println(iter1.next() + ",");
        }
        StdOut.println();
        while (iter2.hasNext()) {
            StdOut.println(iter2.next() + ",");
        }
        StdOut.println();
    }
}
