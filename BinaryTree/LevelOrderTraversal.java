public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
       if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<Integer>();
            while(size-- > 0){
                TreeNode rn = q.poll();
                level.add(rn.val);
                if(rn.left != null) q.add(rn.left);
                if(rn.right != null) q.add(rn.right);
            }
             
            ans.add(level);
        }
        return ans;
    }
}
