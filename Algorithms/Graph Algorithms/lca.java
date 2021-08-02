
// lowest common ancestor of two nodes
// store parent of every node
// store level of every node
// select the node at lower level and move up until level of both nodes are not same
// if nodes are same the LCA found
// else move both up one by one
// Space: O(n)
// Time: O(n)

// Binary Lifting
// Make jumps in power of 2
// Difference b/w level is 13
// Make jumps of -> 8, 4, 1
// Store parent of every node for powers of 2
// Time: O(log(n))
// Space: O(n log(n)), each node will have log(n) parents
// LCA[i][j] = 2**j parent of i
// calulate 2**0=1 parent for each i
// rest can calculated by:
// 2**j parent of i = 2**(j-1) parent of [ 2**(j-1) parent of i ]

// can be used for distance b/w two nodes in tree

import java.io.*;
import java.util.*;

class lca{

    static int[][] LCA;
    static ArrayList<ArrayList<Integer>> adj;
    static int n, size, level[];

    static int getLCA(int a, int b){
        if(level[a] > level[b]){
            a^=b; b^=a; a^=b;
        }
        int d = level[b]-level[a];
        while(d > 0){
            int i = (int)(Math.log(d)/Math.log(2));
            b = LCA[b][i];
            d -= (1<<i);
        }

        if(a==b)
            return a;
        
        for(int i=size-1; i>=0; i--){
            // check if parent exists and LCA is not skipped
            // if LCA is skipped then the parent of both nodes will be same
            if(LCA[a][i]!=-1 && LCA[a][i]!=LCA[b][i]){
                a = LCA[a][i];
                b = LCA[b][i];
            }
        }

        return LCA[a][0];
    }

    static void dfs(int node, int parent, int lvl){
        LCA[node][0] = parent;
        level[node] = lvl;
        for(int child: adj.get(node))
            if(parent!=child)
                dfs(child, node, lvl+1);
    }

    static void fillLCA(){
        dfs(0, -1, 0);
        for(int j=1; j<=size; j++){
            for(int i=0; i<n; i++){
                if(LCA[i][j-1] != -1){
                    int parent = LCA[i][j-1];
                    LCA[i][j] = LCA[parent][j-1];
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s;
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        size = (int)(Math.log(n)/Math.log(2));  // max in skewed tree

        LCA = new int[n][size+1];
        level = new int[n];
        adj = new ArrayList<>(n);
        for(int i=0; i<n; i++){
            Arrays.fill(LCA[i], -1);
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0])-1;
            int b = Integer.parseInt(s[1])-1;
            adj.get(a).add(b);
        }
        fillLCA();

        int q = Integer.parseInt(br.readLine());
        while(q-->0){
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0])-1, b = Integer.parseInt(s[1])-1;
            int lca = getLCA(a, b);
            System.out.println("LCA: " + (lca + 1));
            int dist = level[a]-level[lca] + level[b]-level[lca]; 
            System.out.println("Distance: " + dist);
        }

    }
}