import java.util.*;

class BFS{

    public static ArrayList<Integer> findBFS(int v, ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[v+1];

        for(int i=1;i<=v;i++){
            if(vis[i] == false){
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                vis[i] = true;
                
                while(!(q.isEmpty())){
                   Integer node = q.poll();
                    bfs.add(node);
                    for(Integer e : adj.get(node)){
                        if(vis[e] == false){
                            q.add(e);
                            vis[e] = true;
                        }
                    }
                }
            }
        }
        
        return bfs;
    }

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int v = 7;
        for(int i=0;i<=v;i++){
            adj.add(new ArrayList<Integer>());
        }
        // node 1
        adj.get(1).add(2);

        //node 2
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(2).add(7);

        //node 3
        adj.get(3).add(2);
        adj.get(3).add(4);

        //node 4
        adj.get(4).add(3);

        //node 5
        adj.get(5).add(6);

        //node 6
        adj.get(6).add(5);

        //node 7
        adj.get(7).add(2);

        System.out.println(findBFS(v,adj));
        
    }


}