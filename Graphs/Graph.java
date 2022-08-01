import java.util.*;
public class Graph {

    /* undirected weighted graph */

    private static class Edge{
        int src;
        int dest;
        int weight;

        Edge(int src, int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void main(String[] args){
        int vtce = 7;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for(int i=0; i <= vtce ; i++){
            graph.add(i,new ArrayList<Edge>());
        }

       
        /**
         *  Structure of Graph ====>
         *  
         *                     0️⃣<=======> 3️⃣ <===>4️⃣ 
         *                      ↑           ↑    ↗  ↑ ↖
         *                      ↓           ↓ ↙     ↓  ↘
         *                     1️⃣<=======> 2️⃣      5️⃣←→6️⃣
         * 
         */         


        /**
         * Adjacency List Representation of the graph
         * 
         *      0 -> [ (0 to 1 @ 10), (0 to 3 @ 40) ]
         *      1 -> [ (1 to 0 @ 10), (1 to 2 @ 10) ]
         *      2 -> [ (2 to 1 @ 10), (2 to 3 @ 10) ]
         *      3 -> [ (3 to 0 @ 40), (3 to 2 @ 10), (3 to 4 @ 2) ]
         *      4 -> [ (4 to 3 @ 2),  (4 to 5 @ 3),  (4 to 6 @ 8) ]
         *      5 -> [ (5 to 4 @ 3), (5 to 6 @ 3) ]
         *      6 -> [ (6 to 5 @ 3), (6 to 4 @ 10) ]
         * 
         */

          /* statically assigning value, instead of taking from the user*/ 

        // 0 -> [ (0 to 1 @ 10), (0 to 3 @ 40) ]
        graph.get(0).add(new Edge(0,1,10));
        graph.get(0).add(new Edge(0,3,40));

        // 1 -> [ (1 to 0 @ 10), (1 to 2 @ 10) ]
        graph.get(1).add(new Edge(1,0,10));
        graph.get(1).add(new Edge(1,2,10));

        // 2 -> [ (2 to 1 @ 10), (2 to 3 @ 10) ]
        graph.get(2).add(new Edge(2,1,10));
        graph.get(2).add(new Edge(2,3,10));

        // 3 -> [ (3 to 0 @ 40), (3 to 2 @ 10), (3 to 4 @ 2) ]
        graph.get(3).add(new Edge(3,0,40));
        graph.get(3).add(new Edge(3,2,10));
        graph.get(3).add(new Edge(3,4,2));

        // 4 -> [ (4 to 3 @ 2),  (4 to 5 @ 3),  (4 to 6 @ 8) ]
        graph.get(4).add(new Edge(4,3,2));
        graph.get(4).add(new Edge(4,5,3));
        graph.get(4).add(new Edge(4,6,8));

        // 5 -> [ (5 to 4 @ 3), (5 to 6 @ 3) ]
        graph.get(5).add(new Edge(5,4,3));
        graph.get(5).add(new Edge(5,6,3));

        // 6 -> [ (6 to 5 @ 3), (6 to 4 @ 10) ]
        graph.get(6).add(new Edge(6,5,3));
        graph.get(6).add(new Edge(6,4,8));


        display(graph);
    }

    public static void display(ArrayList<ArrayList<Edge>> graph){
        for(ArrayList<Edge> list : graph){
            for(Edge e : list){
                System.out.println(e.src + "->" + e.dest + "@" + e.weight);
            }
        }
    }

}
