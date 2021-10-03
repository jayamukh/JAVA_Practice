/* *****************************************************************************
 *  Name:              Jaya Mukherjee
 *  Coursera User ID:  123456
 *  Last modified:     June 24, 2021
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class Permutation {
    public static void main(String[] args) {

        if (args[0] != null) {
            int num = Integer.parseInt(args[0]);

            RandomizedQueue<String> r = new RandomizedQueue<String>();

            int index = 0;
            while (!StdIn.isEmpty() && num > 0) {
                String input = StdIn.readString();
                index++;

                if ((index > num) && StdRandom.bernoulli((double) num / index)) {
                    r.dequeue();
                }
                else if (index > num) {
                    continue;
                }
                r.enqueue(input);
            }

            int i = 0;
            Iterator<String> iter = r.iterator();
            while (iter.hasNext() && (i < num)) {
                StdOut.println(iter.next() + " ");
                i++;
            }
        }
    }
}
