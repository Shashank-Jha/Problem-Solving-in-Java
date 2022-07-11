public class TopView {

    //GFG : https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
    static class Pair{
        Node node;
        int hl;
        
        Pair(Node node, int hl){
            this.node = node;
            this.hl = hl;
        }

    }
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        int minL = 0;
        int maxL = 0;
        q.add(new Pair(root,0));
        
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-- > 0){
               Pair rp = q.poll();
                
                
                minL = Math.min(minL,rp.hl);
                maxL = Math.max(maxL,rp.hl);
                
                map.putIfAbsent(rp.hl,new ArrayList<Integer>());
                map.get(rp.hl).add(rp.node.data);
                
                if(rp.node.left != null) q.add(new Pair(rp.node.left,rp.hl - 1));
                if(rp.node.right != null) q.add(new Pair(rp.node.right,rp.hl + 1));
                
                
            }
        }
            for(int i=minL;i<=maxL;i++){
                for(Integer e : map.get(i)){
                    ans.add(e);
                    break;
                }
            }
        return ans;
    }
}
