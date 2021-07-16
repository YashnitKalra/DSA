// kahn's algorithm is used to get topological sorting of a graph in O(V + E) time
// 1. Calculate in-degree of each vertex
// 2. Select a vertext with in-degree = 0
// 3. Add vertex to result
// 4. Remove edge from this vertex to its children
// 5. Goto step 2

import java.util.*;

public class kahnsAlgorithm {
    public static ArrayList<Integer> kahns_algorithm(int v, int e, ArrayList<ArrayList<Integer>> adj, int[] indegree){
        ArrayList<Integer> res = new ArrayList<>(v);
        
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=0; i<indegree.length; i++)
            if(indegree[i]==0)
                q.add(i);
        
        while(q.size()>0){
            int cur = q.poll();
            res.add(cur);
            for(int node: adj.get(cur)){
                indegree[node]--;
                if(indegree[node]==0)
                    q.add(node);
            }
        }
        if(res.size()==v)
            return res;
        return null;
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int v = obj.nextInt();
        int e = obj.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<v; i++)
            adj.add(new ArrayList<>());
        int a,b;
        int indegree[] = new int[v];
        for(int i=0; i<e; i++){
            a = obj.nextInt();
            b = obj.nextInt();
            adj.get(a).add(b);
            indegree[b]++;
        }
        ArrayList<Integer> res = kahns_algorithm(v, e, adj, indegree);
        if(res!=null)
            for(int i: res)
                System.out.print(i+" ");
        else
            System.out.println("Valid Topological Sort does not exist");
        obj.close();
    }
}
