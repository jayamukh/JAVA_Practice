/* *****************************************************************************
 *  Name:              Jaya Mukherjee
 *  Coursera User ID:  ******
 *  Last modified:     March 07, 2021
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        String champ = null;
        int index = 1;
        if (!StdIn.isEmpty()) {
            champ = StdIn.readString();

        }
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (StdRandom.bernoulli(1.0 / index)) {
                champ = word;
            }
            index++;
        }
        StdOut.println(champ);

    }
}
