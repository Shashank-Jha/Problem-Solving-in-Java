import java.util.*;

// GFG : https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1
public class VerticalOrderTraversal {
    static class Pair{
        Node node;
        int hl;
        
        Pair(Node node, int hl){
            this.node = node;
            this.hl = hl;
        }
    }
    
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(Node root)
    {
       HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        LinkedList<Pair> q = new LinkedList<Pair>();
        int minL = 0,maxL = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        q.addLast(new Pair(root,0));
        
        while(!q.isEmpty()){
            
            int size = q.size();
            
            while(size-- >0){
                Pair removedPair = q.removeFirst();
                
                minL = Math.min(minL,removedPair.hl);
                maxL = Math.max(maxL,removedPair.hl);
                
                map.putIfAbsent(removedPair.hl,new ArrayList<Integer>());
                map.get(removedPair.hl).add(removedPair.node.data);
                
                if(removedPair.node.left != null) 
                    q.addLast(new Pair(removedPair.node.left,removedPair.hl - 1));
                
                if(removedPair.node.right != null)
                    q.addLast(new Pair(removedPair.node.right,removedPair.hl + 1));
            }
            
        }
        
        for(int i=minL; i<= maxL ;i++){
            ArrayList<Integer> inner = map.get(i);
            for(Integer e : inner) ans.add(e);
        }
        
        return ans;
    }
}
