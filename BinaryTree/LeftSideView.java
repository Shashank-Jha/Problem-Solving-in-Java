public class LeftSideView {
    // GFG : https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1
    ArrayList<Integer> leftView(Node root)
    {
        if(root == null) return new ArrayList<>();
      Queue<Node> q = new LinkedList<>();
      ArrayList<Integer> ans = new ArrayList<>();
      q.add(root);
      
      while(!q.isEmpty()){
          int size = q.size();
          ans.add(q.peek().data);
          while(size-- > 0){
              Node parNode = q.poll();
              if(parNode.left != null) q.add(parNode.left);
              if(parNode.right != null) q.add(parNode.right);
          }
          
      }
      return ans;
    }
}
