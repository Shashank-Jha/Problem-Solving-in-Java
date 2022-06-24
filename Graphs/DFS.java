import java.util.*;

class DFS{

    public static void callDFS(int i,int[] vis,
     ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs){

        vis[i] = 1;
        dfs.add(i);
        for(Integer e : adj.get(i)){
            if(vis[e]==0){
                callDFS(e, vis, adj, dfs);
            }  
        }

    }

    public static ArrayList<Integer> findDFS(int v, ArrayList<ArrayList<Integer>> adj){

        ArrayList<Integer> dfs = new ArrayList<>();
        int[] vis = new int[v+1];
        for(int i=1;i<=v;i++){
            if(vis[i]==0){
                callDFS(i,vis,adj,dfs);
            }
        }

        return dfs;
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

        System.out.println(findDFS(v,adj));
        
    }


}