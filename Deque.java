/* *****************************************************************************
 *  Name:              Jaya Mukherjee
 *  Coursera User ID:  123456
 *  Last modified:     June 13, 2021
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int size;

    private class Node {
        Item item;
        Node next;
        Node preVious;
    }

    // construct an empty deque
    public Deque() {
        size = 0;
        first = null;
        last = null;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null)
            throw new IllegalArgumentException("The item can't be null");
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.preVious = null;
        if (isEmpty()) {
            last = first;
            first.next = null;
        }
        else {
            first.next = oldFirst;
            oldFirst.preVious = first;
        }
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null)
            throw new IllegalArgumentException("The item can't be null");
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            last.preVious = null;
            first = last;
        }
        else {
            oldLast.next = last;
            last.preVious = oldLast;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("the deque is empty!");
        }
        Item item = first.item;
        size--;
        if (isEmpty()) {
            first = null;
            last = null;
        }
        else {
            first = first.next;
            first.preVious = null;
        }

        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("the deque is empty!");
        }
        Item item = last.item;
        size--;
        if (isEmpty()) {
            first = null;
            last = null;
        }
        else {
            last = last.preVious;
            last.next = null;
        }
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();

    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (current == null) {
                throw new NoSuchElementException("there are no more items!");
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<String> queue = new Deque<String>();
        queue.addFirst("a");
        queue.addFirst("b");
        queue.addLast("c");
        queue.addFirst("d");
        queue.addLast("e");
        queue.removeLast();
        queue.removeFirst();
        StdOut.println(queue.size);
        Iterator<String> iter = queue.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next() + ",");
        }

    }

}
