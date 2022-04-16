import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Trees1 {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                }
                else {
                    top.node.left = null;
                }

                top.state++;
            }
            else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                }
                else {
                    top.node.right = null;
                }

                top.state++;
            }
            else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static Node add(Node node, int data) {
        if (node == null) {
            Node bn = new Node(data, null, null);
            bn.data = data;

            return bn;
        }
        if (node.data > data) {
            node.left = add(node.left, data);
        }
        else if (node.data < data) {
            node.right = add(node.right, data);
        }
        else {
            return node;
        }
        return node;
    }

    public static void Width(Node root, int level, int[] minmax) {
        if (root == null)
            return;
        minmax[0] = Math.min(minmax[0], level);
        minmax[1] = Math.max(minmax[1], level);
        Width(root.left, level - 1, minmax);
        Width(root.right, level + 1, minmax);

    }

    public static ArrayList<ArrayList<Integer>> vertical_order(Node root) {
        int[] minmax = new int[2];
        Width(root, 0, minmax);

        int width = minmax[1] - minmax[0] + 1;

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < width; i++) {
            arr.add(new ArrayList<>());
        }

        fill_vo(arr, root, 0, minmax[0]);


        return arr;
    }

    public static void fill_vo(ArrayList<ArrayList<Integer>> arr, Node root, int level, int min) {
        if (root == null)
            return;

        int index = level - min;
        arr.get(index).add(root.data);

        fill_vo(arr, root.left, level - 1, min);
        fill_vo(arr, root.right, level + 1, min);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            }
            else {
                arr[i] = null;
            }
        }

        int data = Integer.parseInt(br.readLine());

        Node root = construct(arr);
        root = add(root, data);

        display(root);

        ArrayList<ArrayList<Integer>> list = vertical_order(root);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

}
