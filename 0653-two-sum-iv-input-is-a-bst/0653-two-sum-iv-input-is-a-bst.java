class Solution {
    public boolean preOrder(TreeNode node, HashSet<Integer> s, int k) {
        if(node == null) {
            return false;
        }

        if(s.contains(k - node.val)) {
            return true;
        }

        s.add(node.val);

        if(preOrder(node.left, s, k)) {
            return true;
        }

        if(preOrder(node.right, s, k)) {
            return true;
        }

        return false;
    }

    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> s = new HashSet<>();
        return preOrder(root, s, k);
    }
}