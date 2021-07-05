/*
    bridge:         the edge, removing which increases the number of connected components
    forward edge:   edges traversed during dfs
    backward edge:  edge not traversed during dfs
    
    backward edge points to one of its ancestor which is not the direct parent
    backward edge can never be a bridge
*/

import java.util.*;

class bridges{

    static int timer = 0;

    static void dfs(int src, int parent, ArrayList<ArrayList<Integer>> adj, int[] inTime, int[] low, boolean[] visited){
        visited[src] = true;
        inTime[src] = low[src] = timer++;
        for(int child: adj.get(src)){
            if(child == parent)
                continue;
            else if(visited[child])  // back edge
                low[src] = Math.min(low[src], inTime[child]);    // check if child is an ancestor
            else{
                dfs(child, src, adj, inTime, low, visited);
                if(low[child] > inTime[src])    // child is not connected to any of the ancestors
                    System.out.printf("%d - %d is a bridge\n", src, child);
                low[src] = Math.min(low[src], low[child]);   // check if source can also reach the ancestor
            }
        }
    }

    public static void main(String[] args) throws Exception{
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
        dfs(0, -1, adj, inTime, low, new boolean[vertices]);
    }
}

//         0
//         |
//         |
//         1---------3
//         |         |
//         |         |
//         2---------|