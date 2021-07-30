// Used for finding MST
// Keep selecting the edge with minimum weight
// If the edge with minimum weight forms a cycle then don't select it
// This can be checked using Disjoint Set

import java.util.*;

class kruskalsAlgorithm{

    public static int getParent(int[] parent, int i){
        if(parent[i]==i)
            return i;
        return parent[i] = getParent(parent, parent[i]);
    }
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int n = obj.nextInt();
        int m = obj.nextInt();
        
        int[] parent = new int[n];
        for(int i=0; i<n; i++)
            parent[i] = i;
        
        int[][] edges = new int[m][3];  // v1 v2 w
        for(int i=0; i<m; i++)
            for(int j=0; j<3; j++)
                edges[i][j] = obj.nextInt();

        Arrays.sort(edges, (a,b)->a[2]-b[2]);

        int sum = 0;
        for(int i=0; i<m; i++){
            int p1 = getParent(parent, edges[i][0]);
            int p2 = getParent(parent, edges[i][1]);
            if(p1!=p2){
                sum += edges[i][2];
                parent[p1] = p2;
            }
        }

        System.out.println(sum);

        obj.close();
    }
}