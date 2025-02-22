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
class Solution {
    int idx = 0;
    int dash = 0;
    public TreeNode recoverFromPreorder(String traversal) {
       return build(traversal, 0);
    }
    public TreeNode build(String s, int dep){
       
        if(dep>dash){
            return null;
        }
        int num = 0;
        while(idx<s.length() && s.charAt(idx)!='-'){
            num = (num*10) + (s.charAt(idx)-'0');
            idx++;
        }
        TreeNode n = new TreeNode(num);
     
        dash = 0;
        while(idx<s.length() && s.charAt(idx)=='-'){
            idx++;
            dash++;

        }
        n.left = build(s, dep+1);
        n.right = build(s, dep+1);

        return n;

    }
}