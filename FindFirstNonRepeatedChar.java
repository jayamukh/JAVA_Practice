/* *****************************************************************************
 *  Name:              Jaya Mukherjee
 *  Coursera User ID:  xxxxx
 *  Last modified:     October 3, 2021
 **************************************************************************** */

import java.util.HashMap;

public class FindFirstNonRepeatedChar {
    public FindFirstNonRepeatedChar(String str) {
        HashMap<Integer, Object> charhash = new HashMap<Integer, Object>();
        Object seenOnce = new Object();
        Object seenMul = new Object();
        Object seen;

        final int length = str.length();
        for (int i = 0; i < length; ) {
            final int cp = str.codePointAt(i);
            i += Character.charCount(cp);
            seen = charhash.get(cp);
            if (seen == null) {
                charhash.put(cp, seenOnce);
            }
            else if (seen.equals(seenOnce)) {
                charhash.put(cp, seenMul);
            }
        }
        for (int i = 0; i < length; ) {
            final int cp = str.codePointAt(i);
            i += Character.charCount(cp);
            if (charhash.get(cp).equals(seenOnce)) {
                System.out.println(new String(Character.toChars(cp)));
            }
        }

    }

    public static void main(String[] args) {
        if (args != null) {

            FindFirstNonRepeatedChar ff = new FindFirstNonRepeatedChar(args[0]);
        }
    }
}
