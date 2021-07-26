// strongly connected component:
// subset of vertices such that there exists a path between any 2 vertices in directed graph

// 1. Start DFS of unvisited vertices
// 2. Push unvisited vertex to stack
// 3. Create a reversed graph (edges are reversed)
// 4. Pop vertex from stack
// 5. Visit all the nodes you can from that node in reversed graph
// 6. These nodes form a strongly connected component
// 7. Keep popping next vertex from stack and perform DFS if the popped node is not visited.

import java.util.*;

public class kosaraju {
    
    public static ArrayList<ArrayList<Integer>> getTranspose(ArrayList<ArrayList<Integer>> adj, int v){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>(v);
        for(int i=0; i<v; i++)
            res.add(new ArrayList<>());
        for(int i=0; i<v; i++){
            for(int j: adj.get(i))
                res.get(j).add(i);
        }
        return res;
    }

    public static void dfs(int src, boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> res){
        res.add(src);
        visited[src] = true;
        for(int i: adj.get(src))
            if(!visited[i])
                dfs(i, visited, adj, res);
    }

    public static void dfsFill(ArrayList<ArrayList<Integer>> adj, Stack<Integer> st, int src, boolean[] visited){
        visited[src] = true;
        for(int i: adj.get(src))
            if(!visited[i])
                dfsFill(adj, st, i, visited);
        st.push(src);
    }

    public static ArrayList<ArrayList<Integer>> scc(ArrayList<ArrayList<Integer>> adj, int v){
        Stack<Integer> st = new Stack<>();
        
        boolean visited[] = new boolean[v];
        for(int i=0; i<v; i++)
            if(!visited[i])
                dfsFill(adj, st, i, visited);

        ArrayList<ArrayList<Integer>> adjT = getTranspose(adj, v);
        Arrays.fill(visited, false);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp;

        while(!st.empty()){
            int src = st.pop();
            if(!visited[src]){
                temp = new ArrayList<>();
                dfs(src, visited, adjT, temp);
                res.add(temp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int v = obj.nextInt();
        int e = obj.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
        for(int i=0; i<v; i++)
            adj.add(new ArrayList<>());
        for(int i=0; i<e; i++){
            int a = obj.nextInt()-1;
            int b = obj.nextInt()-1;
            adj.get(a).add(b);
        }
        ArrayList<ArrayList<Integer>> components = scc(adj, v);
        for(int i=0; i<components.size(); i++){
            for(int j=0; j<components.get(i).size();  j++)
                System.out.print(components.get(i).get(j)+1 + " ");
            System.out.println();
        }
        obj.close();
    }
}
