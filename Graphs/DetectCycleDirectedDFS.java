import java.util.*;
public class DetectCycleDirectedDFS {
        // Submitted on GFG :)
    public static boolean detectCycle(int node,int V, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] dfsVis){
        
        vis[node] = 1;
        dfsVis[node] = 1;
        for(Integer e : adj.get(node)){
            if(vis[e] == 0){
                if(detectCycle(e,V,adj,vis,dfsVis)) return true;
            }else if(dfsVis[e] == 1){
                return true;
            }
        }
        dfsVis[node] = 0;
        
        return false;
    }
    
    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        
        int[] vis = new int[V+1];
        int[] dfsVis = new int[V+1];
        
        for(int i=0; i<V ;i++){
            if(vis[i] == 0){
                if(detectCycle(i,V,adj,vis,dfsVis)) return true;
            }    
        }
        return false;
    }
}
