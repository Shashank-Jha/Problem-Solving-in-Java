public class BipartiteGraphDFS {
    
    // Successfully submitted on Leetcode :)
    public static boolean findBipartite(int i, int[][] graph,int[] color){
        if(color[i] == -1) color[i] = 1;
        for(int e : graph[i]){
            if(color[e] == -1){
                 color[e] = 1 - color[i];
                 if(!findBipartite(e,graph,color)) return false;
            } else if(color[e] != -1){
                if(color[e] == color[i]) return false;
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
