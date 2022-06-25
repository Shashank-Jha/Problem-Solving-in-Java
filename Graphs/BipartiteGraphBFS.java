import java.util.*;

public class BipartiteGraphBFS{

    //Successfully Submitted on Leetcode :)
    public static boolean findBipartite(int i, int[][] graph,int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        color[i] = 1;
        
        while(!q.isEmpty()){
            int node = q.poll();
            for(int e : graph[node]){
                if(color[e] == -1){
                    color[e] = 1 - color[node];
                    q.add(e);
                } else if(color[e] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for(int i=0;i<graph.length;i++) color[i] = -1;
        
        for(int i=0; i<graph.length ;i++){
            if(color[i] == -1){
                if(!findBipartite(i,graph,color)) return false;
            }
        }
        return true;
    }
}