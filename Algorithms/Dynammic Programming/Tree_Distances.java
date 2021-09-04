// to find sum of distance from a node to every other node
//      0-----------1-----------4
//      |           |           
//      |           |
//      |           |
//      2           3
// Sum of distance from 0 = 1 + 1 + 2 + 2 = 6
// Distances = [6, 5, 9, 8, 8]

// Re-rooting DP
// changing the root of tree/graph changes the solution

// When 1 is root distance = 5
// When 0 is root:
// 1. Consider subtree rooted at 1
// 2. The distance sum = (Sum of distance of 1 from all nodes in subtree) + (number of nodes in subtree) = 2 + 3 = 5
// 3. Consider subtree rooted at 2
// 4. Sum = 0, nodes = 1 in the subtree
// Total distance from 0 = 5 + 1 = 6

// Steps:
// 1. Calculate subtree size and distance sum of each node using dfs
// 2. To calculate result of a node:
//      (result(parent) - subDist(node) - subSize(node)) + (total_nodes - subSize(node)) + subDist[node]

import java.util.*;

class Tree_Distances{
    
    static int v;
    static int[] subDist, subSize, res;
    static ArrayList<ArrayList<Integer>> adj;

    static void dfs1(int node, int par){
        subSize[node] = 1;
        
        for(int child: adj.get(node))
            if(child!=par){
                dfs1(child, node);
                subSize[node] += subSize[child];
                subDist[node] += subSize[child] + subDist[child];
            }
    }

    static void dfs(int node, int par){
        res[node] = res[par] - subSize[node] - subDist[node] + v - subSize[node] + subDist[node];

        for(int child: adj.get(node))
            if(child != par)
                dfs(child, node);
    }
    
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        v = obj.nextInt();
        int n = obj.nextInt();
        adj = new ArrayList<>(v);
        for(int i=0; i<v; i++)
            adj.add(new ArrayList<>());
        for(int i=0; i<n; i++){
            int a = obj.nextInt(), b = obj.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        obj.close();

        subDist = new int[v];
        subSize = new int[v];
        res = new int[v];

        dfs1(0, -1);
        res[0] = subDist[0];

        for(int child: adj.get(0))
            dfs(child, 0);
        
        for(int i: res)
            System.out.print(i + " ");
        System.out.println();
    }
}