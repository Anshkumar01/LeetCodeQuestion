/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class FindElements {
    private Set<Integer> recoveredValues;

    public FindElements(TreeNode root) {
        recoveredValues = new HashSet<>();
        recoverTree(root, 0);
    }

    private void recoverTree(TreeNode node, int value) {
        if (node == null){
         return;
         } 
        node.val = value;
        recoveredValues.add(value); 
        recoverTree(node.left, 2 * value + 1); // Recover left child
        recoverTree(node.right, 2 * value + 2); // Recover right child
    }

    public boolean find(int target) {
        return recoveredValues.contains(target); 
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */