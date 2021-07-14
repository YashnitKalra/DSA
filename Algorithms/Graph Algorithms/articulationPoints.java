// refer "bridges" first
// the "vertex" removing which, the number of connected components increases

import java.util.*;

public class articulationPoints {
    static int timer;

    static void dfs(int src, int parent, ArrayList<ArrayList<Integer>> adj, int[] inTime, int[] low, boolean[] visited){
        visited[src] = true;
        inTime[src] = low[src] = timer++;
        int subtrees = 0;
        for(int child: adj.get(src)){
            if(child == parent)
                continue;
            else if(visited[child])  // back edge
                low[src] = Math.min(low[src], inTime[child]);    // check if child is an ancestor
            else{
                dfs(child, src, adj, inTime, low, visited);
                low[src] = Math.min(low[src], low[child]);   // check if source can also reach the ancestor
                if(low[child] >= inTime[src] && parent!=-1)    // child is not connected to any of the ancestors and src is not root
                    System.out.printf("Articulation Point: %d\n", src);
                subtrees++;
            }
        }
        if(parent == -1 && subtrees>1)
            System.out.printf("Articulation Point: %d\n", src);
    }
    public static void main(String[] args) {
        // create graph
        int vertices = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<vertices; i++)
            adj.add(new ArrayList<>());
        adj.get(0).add(1); adj.get(1).add(0);
        adj.get(1).add(2); adj.get(2).add(1);
        adj.get(1).add(3); adj.get(3).add(1);
        adj.get(2).add(3); adj.get(3).add(2);

        int[] inTime = new int[vertices];   // when a node enters
        int[] low = new int[vertices];      // low[i] indicates earliest visited vertex that is reachable from i
        low[0] = 0;
        timer = 0;
        boolean[] visited = new boolean[vertices];
        for(int i=0; i<vertices; i++)
            if(!visited[i])
                dfs(i, -1, adj, inTime, low, visited);
    }
}
