// Takes O(n * e) time => O(n**2)
// Takes O(n**3) time in case of complete graph

import java.util.*;
import java.io.*;

class bellmanford{

    public static int[] bellmanFord(ArrayList<HashMap<Integer, Integer>> adj, int n, int src){
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for(int i=0; i<n-1; i++){
            for(int u=0; u<n; u++){
                for(int v: adj.get(u).keySet()){
                    int w = adj.get(u).get(v);
                    if(dist[u]!=Integer.MAX_VALUE && dist[u]+w < dist[v])
                        dist[v] = dist[u] + w;
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        ArrayList<HashMap<Integer, Integer>> adj = new ArrayList<>(n);
        for(int i=0; i<n; i++)
            adj.add(new HashMap<>());
        for(; m>0; m--){
            s = br.readLine().split(" ");
            adj.get(Integer.parseInt(s[0])-1).put(Integer.parseInt(s[1])-1, Integer.parseInt(s[2]));
        }
        int src = Integer.parseInt(br.readLine()) - 1;
        int[] dist = bellmanFord(adj, n, src);
        for(int i: dist)
            System.out.println(i);
    }
}
