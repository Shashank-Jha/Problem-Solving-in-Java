import java.util.*;
public class DetectCycleBFS {

    static class Pair{
        int node;
        int par;

        Pair(){}
        Pair(int node,int par){
            this.node = node;
            this.par = par;
        }
    }

    public static boolean isCycle(int node, int[] vis,ArrayList<ArrayList<Integer>>adj){
        
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(node,-1));
        vis[node] = 1;
         
        while(!q.isEmpty()){
            Pair nodePair = q.poll();
            for(Integer e : adj.get(nodePair.node)){
                if(vis[e]==0){
                    q.add(new Pair(e,nodePair.node));
                    vis[e] = 1;
                }
                else if(vis[e] == 1 && e != nodePair.par) return true;
              
            }
        }
        return false;
    }
    public static boolean detectCycle(int v,ArrayList<ArrayList<Integer>>adj){
        int[] vis = new int[v+1];
        for(int i=1;i<=v;i++){
            if(vis[i] == 0){
                if(isCycle(i,vis,adj)) return true;
            }
        }

        return false;
    }


    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int v = 11;
        for(int i=0;i<=v;i++){
            adj.add(new ArrayList<Integer>());
        }
        // node 1
        adj.get(1).add(2);

        //node 2
        adj.get(2).add(1);
        adj.get(2).add(4);

        //node 3
        adj.get(3).add(5);

        //node 4
        adj.get(4).add(2);

        //node 5
        adj.get(5).add(3);
        adj.get(5).add(10);
        adj.get(5).add(6);

        //node 6
        adj.get(6).add(5);
        adj.get(6).add(7);
        //node 7
        adj.get(7).add(6);
        // adj.get(7).add(8);

        //node 8
        // adj.get(8).add(7);
        adj.get(8).add(9);
        adj.get(8).add(11);

        //node 9
        adj.get(9).add(10);
        adj.get(9).add(8);

        //node 10
        adj.get(10).add(5);
        adj.get(10).add(9);

        //node 11
        adj.get(11).add(8);



        System.out.println(detectCycle(v,adj));
        
    }
}
