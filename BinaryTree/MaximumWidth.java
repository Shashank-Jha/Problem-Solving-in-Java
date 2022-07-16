public class MaximumWidth {
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

 // LEETCODE - IMP
class Solution {
    public class Pair{
        TreeNode node;
        int idx;
        
        Pair(TreeNode node,int idx){
            this.node = node;
            this.idx = idx;
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        
        int max = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            int minL = q.peek().idx;
            int maxL = q.peek().idx;
            while(size-- > 0){
                Pair rn = q.poll();
                maxL = rn.idx;
                
                if(rn.node.left != null ){
                    q.add(new Pair(rn.node.left,2*rn.idx + 1));
                }
                
                if(rn.node.right != null ){
                    q.add(new Pair(rn.node.right,2*rn.idx + 2));
                }
                
            }
            max = Math.max(max,maxL - minL + 1);
        }
        return max;
    }
}

}
