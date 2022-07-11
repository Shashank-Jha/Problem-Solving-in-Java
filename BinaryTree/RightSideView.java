
// LEETCODE : https://leetcode.com/problems/binary-tree-right-side-view/
public class RightSideView {

    // EASY & BEST APPROACH
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        q.add(root);

        while(!q.isEmpty()){
             int size = q.size();
             ans.add(q.peek().val);
             while(size-- > 0){
                 TreeNode parNode = q.poll();
                 if(parNode.right != null) q.add(parNode.right);
                 if(parNode.left != null) q.add(parNode.left);
             }
         }
            return ans;
       }

    //My Approach - using map similar to top view and Vertical order 
    public class Pair{
        TreeNode node;
        int level;
        Pair(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    } 


    public List<Integer> rightSideView_MapApproach(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        q.add(new Pair(root,0));
        int maxLevel = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int level = 0;
                Pair rp = q.poll();
                
                maxLevel = Math.max(maxLevel,rp.level);
                
                map.putIfAbsent(rp.level,new ArrayList<>());
                map.get(rp.level).add(rp.node.val);
                
                if(rp.node.right != null || rp.node.left != null) level = rp.level+1;
                if(rp.node.right != null) q.add(new Pair(rp.node.right,level));
                if(rp.node.left != null) q.add(new Pair(rp.node.left, level));
                
            }
            
            
        }
        
        for(int i=0;i<=maxLevel;i++){
            for(Integer e : map.get(i)){
                ans.add(e);
                break;
            }
        }
        
        return ans;
    }public class RightSideView {
        
    }
    
}