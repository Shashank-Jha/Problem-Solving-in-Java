import java.io.*;
import java.util.*;

public class ConnectedComponents {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }
   
   public static void getPath(ArrayList<Edge>[] graph,int src,int[] vis, ArrayList<Integer> ans){
    
       vis[src] = 1;
       ans.add(src);
       for(Edge e : graph[src]){
           if(vis[e.nbr] == 0){
               getPath(graph,e.nbr,vis,ans);
           }
       }
      

   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        
      int[] visited = new int[vtces];
      for(int i=0;i<vtces;i++){
          
          if(visited[i]==0){
              ArrayList<Integer> path = new ArrayList<>();
              getPath(graph,i,visited,path);
                comps.add(path);
          }
            
      }
        
        
      System.out.println(comps);
   }
}
