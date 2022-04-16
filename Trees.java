/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import java.util.ArrayList;

class Trees {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // int min;
    // int max;
    public void rec(TreeNode root, int level, int[] minMax) {
        if (root == null) return;

        minMax[0] = Math.min(minMax[0], level);
        minMax[1] = Math.max(minMax[1], level);

        // min=Math.min(min,level);
        // max=Math.max(max,level);

        rec(root.left, level - 1, minMax);
        rec(root.right, level + 1, minMax);
    }

    public void fill_vo(ArrayList<ArrayList<Integer>> ans, TreeNode root, int level, int min) {
        if (root == null) return;

        int index = level - min;

        ans.get(index).add(root.val);

        fill_vo(ans, root.left, level - 1, min);
        fill_vo(ans, root.right, level + 1, min);
    }

    public void vertical_order(TreeNode root) {
        int[] minMax = new int[2];
        //{min,max}
        rec(root, 0, minMax);

        int width = minMax[1] - minMax[0] + 1;

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < width; i++) {
            // ArrayList<Integer> curr=new ArrayList<>();
            // ans.add(curr);

            ans.add(new ArrayList<>());
        }

        fill_vo(ans, root, 0, minMax[0]);
    }

    public void rec(TreeNode root, int hl, ArrayList<Integer> al) {
        if (root == null) return;

        if (al.size() == hl) {
            al.add(root.val);
        }

        rec(root.left, hl + 1, al);
        rec(root.right, hl + 1, al);
    }

    ArrayList<Integer> leftView(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<>();

        rec(root, 0, al);

        return al;
    }


    // morris Traversal ==============================================================
    public TreeNode rightMost(TreeNode node, TreeNode curr) {
        while (node.right != null && node.right != curr) {
            node = node.right;
        }

        return node;
    }

    public ArrayList<Integer> inorderMorrisTraversal(TreeNode root) {
        TreeNode curr = root;
        ArrayList<Integer> ans = new ArrayList<>();

        while (curr != null) {
            TreeNode left = curr.left;

            if (left == null) {
                ans.add(curr.val);
                curr = curr.right;
            }
            else {
                TreeNode rm = rightMost(left, curr);

                if (rm.right == null) { // thread creation
                    rm.right = curr;
                    curr = left;
                }
                else {// thread break
                    rm.right = null;

                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return ans;
    }

    public ArrayList<Integer> preorderMorrisTraversal(TreeNode root) {
        TreeNode curr = root;
        ArrayList<Integer> ans = new ArrayList<>();

        while (curr != null) {
            TreeNode left = curr.left;

            if (left == null) {
                ans.add(curr.val);
                curr = curr.right;
            }
            else {
                TreeNode rm = rightMost(left, curr);

                if (rm.right == null) { // thread creation
                    rm.right = curr;

                    ans.add(curr.val); // adding before moving towards left
                    curr = left;
                }
                else {// thread break
                    rm.right = null;

                    curr = curr.right;
                }
            }
        }

        return ans;
    }

    // leet 98 using recursive space =============================================================
    TreeNode prev;
    boolean ans;

    public void traversal(TreeNode root) {
        if (root == null) return;

        traversal(root.left);

        if (prev != null) {
            if (prev.val >= root.val) {
                ans = false;
            }
        }

        prev = root;

        traversal(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        prev = null;
        ans = true;

        traversal(root);
        return ans;
    }

    // leet 98 in O(1) space =====================================================

    public boolean isValidBST2(TreeNode root) {
        TreeNode curr = root;
        TreeNode prev = null;
        // ArrayList<Integer> ans=new ArrayList<>();

        while (curr != null) {
            TreeNode left = curr.left;

            if (left == null) {
                // ans.add(curr.val);
                if (prev != null && prev.val >= curr.val) {
                    return false;
                }
                prev = curr;
                curr = curr.right;
            }
            else {
                TreeNode rm = rightMost(left, curr);

                if (rm.right == null) { // thread creation
                    rm.right = curr;
                    curr = left;
                }
                else {// thread break
                    rm.right = null;

                    // ans.add(curr.val);
                    if (prev != null && prev.val >= curr.val) {
                        return false;
                    }
                    prev = curr;
                    curr = curr.right;
                }
            }
        }

        return true;
    }

    // leet 173 =====================================================

    ArrayList<Integer> inorder;
    int i = -1;

    public void rec(TreeNode root, ArrayList<Integer> inorder) {
        if (root == null) return;

        rec(root.left, inorder);
        inorder.add(root.val);
        rec(root.right, inorder);

    }

    public void BSTIterator(TreeNode root) {
        inorder = new ArrayList<>();

        rec(root, inorder);
    }

    public int next() {
        i++;
        return inorder.get(i);
    }

    public boolean hasNext() {
        return i + 1 < inorder.size();
    }

}
