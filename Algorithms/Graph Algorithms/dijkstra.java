import java.util.*;

class Dijkstra{

    static ArrayList<ArrayList<Node>> adjList;

    static class Node{
        int dest;
        long weight;
        Node(int d, long w){
            dest = d;
            weight = w;
        }
    }

    public static long[] runDisjkastra(int n, int src){
        long dist[] = new long[n];

        // index, distance
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->{
            return a.weight>b.weight?1:-1;
        });
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[src] = 0;
        pq.add(new Node(src,(long)0));

        while(pq.size()>0){
            int u = pq.peek().dest;
            long w = pq.poll().weight;
            for(Node node: adjList.get(u)){
                if(w + node.weight < dist[node.dest]){
                    dist[node.dest] = w + node.weight;
                    pq.add(new Node(node.dest, dist[node.dest]));
                }
            }    
        }
        return dist;
    }

    public static void main(String[] args) throws Exception{
        Scanner obj=new Scanner(System.in);
        int n=obj.nextInt();
        int m=obj.nextInt();
        adjList = new ArrayList<>();
        for(int i=0;i<n;i++)
            adjList.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            int a=obj.nextInt()-1, b=obj.nextInt()-1, w=obj.nextInt();
            adjList.get(a).add(new Node(b, w));
            adjList.get(b).add(new Node(a, w));
        }
        int s=obj.nextInt()-1;
        int d=obj.nextInt()-1;
        long dist[]=runDisjkastra(n,s);
        System.out.print(dist[d]==Long.MAX_VALUE?-1:dist[d]);
        obj.close();
    }
}