/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import java.util.HashMap;

public class hashKeyIndeed {


    /*
    Your friends are finding it inconvenient having to make messages that fit neatly into a 2D grid.

    You decide to create a substitution cipher. The cipher alphabet is based on a key shared amongst those of your friends who don't mind spoilers.

    Suppose the key is:
    "The quick onyx goblin, Grabbing his sword ==}-------- jumps over the 1st lazy dwarf!".

    We use only the unique letters in this key to set the order of the characters in the substitution table.

    T H E Q U I C K O N Y X G B L R A S W D J M P V Z F

    (spaces added for readability)

    We then align it with the regular alphabet:
    A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
    T H E Q U I C K O N Y X G B L R A S W D J M P V Z F

    Which gives us the substitution mapping: A becomes T, B becomes H, C becomes E, etc.

    Write a function that takes a key and a string and encrypts the string with the key.

    Example:
    key = "The quick onyx goblin, Grabbing his sword ==}-------- jumps over the 1st lazy dwarf!"
    encrypt("It was all a dream.", key) -> "Od ptw txx t qsutg."
    encrypt("Would you kindly?", key) -> "Pljxq zlj yobqxz?"
    */

    private static String encrypt(String key, String msg) {
        HashMap<Integer, Character> map = new HashMap<>();
        int i = 65;
        for (int s = 0; s < key.length(); s++) {
            if (Character.isLetter(key.charAt(s))) {
                if (!map.containsValue(Character.toUpperCase(key.charAt(s)))) {
                    map.put(i++, Character.toUpperCase(key.charAt(s)));
                }
            }
        }

        StringBuilder res = new StringBuilder();
        for (int s = 0; s < msg.length(); s++) {
            if (Character.isLetter(msg.charAt(s))) {
                char val = map.get((int) Character.toUpperCase(msg.charAt(s)));
                res.append(val);
            }
            else {
                res.append(msg.charAt(s));
            }
        }
        return res.toString();
    }

    /*private static <K, V> K getKey(Map<K, V> map, V value) {
        return map.keySet()
                  .stream()
                  .filter(key -> value.equals(map.get(key)))
                  .findFirst().get();
    }*/

    public static void main(String[] argv) {
        String key
                = "The quick onyx goblin, Grabbing his sword ==}-------- jumps over the 1st lazy dwarf!";
        String message = "It was all a dream.";
        String message2 = "Would you kindly?";

        System.out.println(encrypt(key, message));
        System.out.println(encrypt(key, message2));

    }
}
