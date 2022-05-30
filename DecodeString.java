/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.Stack;

public class DecodeString {

    public static String decode(String s) {

        Stack<String> sc = new Stack<>();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                //st.push(c - '0');
                StringBuilder val = new StringBuilder();
                while (c != '[') {
                    val.append(c);
                    i++;
                    c = s.charAt(i);
                }
                sc.push(c + "");
                int num = Integer.parseInt(val.toString());
                st.push(num);

            }
            else if (c == ']') {
                String ch = sc.peek();
                StringBuilder str = new StringBuilder();
                while (!ch.equals("[")) {
                    str.insert(0, sc.pop());
                    ch = sc.peek();
                }
                sc.pop();
                // String str = str1.reverse().toString();
                //sc.push(str);
                StringBuilder ans = new StringBuilder();
                int num = st.pop();
                for (int idx = 0; idx < num; idx++) {
                    ans.append(str.toString());
                }

                sc.push(ans.toString());
            }
            else {
                sc.push(c + "");
            }

        }

        if (sc.size() == 1) {
            return sc.pop();
        }

        StringBuilder decode = new StringBuilder();


        while (!sc.isEmpty()) {
            String st1 = sc.pop();
            decode.insert(0, st1);

        }

        return decode.toString();

    }


    public static void main(String[] args) {

        String input = "100[Leetcode]";
        System.out.println(decode(input));
    }
}
