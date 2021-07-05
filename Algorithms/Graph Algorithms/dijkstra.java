import java.util.*;

class Dijkstra{

    public static long[] runDisjkastra(ArrayList<HashMap<Integer,Long>> adjList, int n, int src){
        long dist[] = new long[n];
        boolean visited[] = new boolean[n];

        // index, distance
        PriorityQueue<Long[]> pq = new PriorityQueue<>((a,b)->{
            return a[1]-b[1]>0?1:-1;
        });

        for(int i=0;i<n;i++){
            dist[i] = Long.MAX_VALUE;
            visited[i] = false;
        }

        dist[src] = 0;
        pq.add(new Long[]{(long)src,(long)0});

        while(pq.size()>0){
            long temp = pq.poll()[0];
            int u = (int)temp;
            visited[u] = true;
            for(int v:adjList.get(u).keySet()){
                if(!visited[v] && dist[u]!=Long.MAX_VALUE && dist[u]+adjList.get(u).get(v)<dist[v]){
                    dist[v] = dist[u] + adjList.get(u).get(v);
                    pq.add(new Long[]{(long)v,dist[v]});
                }
            }    
        }
        return dist;
    }

    public static void main(String[] args) throws Exception{
        Scanner obj=new Scanner(System.in);
        int n=obj.nextInt();
        int m=obj.nextInt();
        ArrayList<HashMap<Integer,Long>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++)
            adjList.add(new HashMap<Integer,Long>());
        for(int i=0;i<m;i++){
            int a=obj.nextInt()-1;
            int b=obj.nextInt()-1;
            long d=obj.nextLong();
            if(adjList.get(a).containsKey(b))
                adjList.get(a).put(b, Math.min(d, adjList.get(a).get(b)));
            else
                adjList.get(a).put(b,d);
        }
        int s=obj.nextInt()-1;
        int d=obj.nextInt()-1;
        long dist[]=runDisjkastra(adjList,n,s);
        System.out.print(dist[d]==Long.MAX_VALUE?-1:dist[d]);
    }
}