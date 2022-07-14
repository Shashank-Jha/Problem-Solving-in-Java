
public class IterativeTraversal {

    class Pair{
        Node node;
        int state;
        
        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
        
    }
    
    ArrayList<Integer> postOrder(Node node) {
        
        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> in = new ArrayList<>();
        ArrayList<Integer> post = new ArrayList<>();
        if(node == null) return post;
        
        Pair curr = new Pair(node,1);
        Stack<Pair> stack = new Stack<>();
        stack.add(curr);
        
        while(!stack.isEmpty()){
            
            Pair n = stack.peek();
            
            
            if(n.state == 1){
                pre.add(n.node.data);
                n.state++;
                if(n.node.left != null) stack.push(new Pair(n.node.left,1));
            }
            
            else if(n.state == 2){
                in.add(n.node.data);
                n.state++;
                if(n.node.right != null) stack.push(new Pair(n.node.right,1));
            }
            
            else if(n.state == 3){
                post.add(n.node.data);
                stack.pop();
            }
            
        }
        return post;
    }
}
