import java.util.*;

public class DetectCycleDFS {

    public static boolean isCycle(int node, int par, int[] vis,ArrayList<ArrayList<Integer>>adj){

        vis[node] = 1;
        for(Integer e : adj.get(node)){
            if(vis[e] == 0){
                if(isCycle(e, node, vis, adj))return true;
            } else if(vis[e] == 1 && e!=par){
                return true;
            }   
        }
        return false;
    }

    public static boolean detectCycle(int v,ArrayList<ArrayList<Integer>>adj){
        int[] vis = new int[v+1];
        for(int i=1;i<=v;i++){
            if(vis[i] == 0){
                if(isCycle(i,-1,vis,adj)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int v = 8;
        for(int i=0;i<=v;i++){
            adj.add(new ArrayList<Integer>());
        }
        // node 1
        adj.get(1).add(3);

        //node 2
        adj.get(2).add(5);
        
        //node 3
        adj.get(3).add(1);
        adj.get(3).add(4);

        //node 4
        adj.get(4).add(3);

        //node 5
        adj.get(5).add(2);
        adj.get(5).add(6);
        adj.get(5).add(8);

        //node 6
        adj.get(6).add(5);
        adj.get(6).add(7);
        //node 7
        adj.get(7).add(6);
        adj.get(7).add(8);

        //node 8
        // adj.get(8).add(7);
        adj.get(8).add(7);
        adj.get(8).add(5);

        System.out.println(detectCycle(v,adj));
        
    }
}
