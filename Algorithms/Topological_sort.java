//      7           5 --------> 0
//      |           |           |
//      |           |           |
//      |           V           |
//      |---------> 4           |
//                  |           |
//                  |           |  
//                  V           V
//      6 <-------- 3 --------> 1 ------> 2

// add the vertex to stack if all its children are explored

import java.util.*;

class Topological_sort{

    public static void startTraversing(ArrayList<Integer>[] adjList, int src, Stack<Integer> st, boolean[] visited){
        for(int vertex: adjList[src]){
            if(!visited[vertex]){
                visited[vertex] = true;
                startTraversing(adjList, vertex, st, visited);
                st.add(vertex);
            }
        }
    }
    
    public static void topological_sort(ArrayList<Integer>[] adjList, int n){
        Stack<Integer> st = new Stack<>();
        boolean visited[] = new boolean[n];
        for(int i=0;i<n;i++)
            if(!visited[i]){
                visited[i] = true;
                startTraversing(adjList, i, st, visited);
                st.add(i);
            }
        while(st.size()>0)
            System.out.print(st.pop() + " ");
    }
    
    public static void main(String[] args) {
        int n = 8;
        ArrayList<Integer>[] adjList = new ArrayList[n];
        for(int i=0;i<n;i++)
            adjList[i] = new ArrayList<Integer>();
        adjList[0].add(1);
        adjList[1].add(2);
        adjList[3].add(1); adjList[3].add(6);
        adjList[4].add(3);
        adjList[5].add(0); adjList[5].add(4);
        adjList[7].add(4);
        topological_sort(adjList, n);
    }
}