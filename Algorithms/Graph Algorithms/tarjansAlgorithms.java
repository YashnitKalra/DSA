// used to find strongly connected component
// same as finding bridges except that
// low-link value is updated from the childNode if childNode is in the active-list (stack)
// create another array to keep track of nodes that are on the stack
// if the low-link value and inTime of a node are same then keep popping from stack
// till current node is popped
// all these nodes belong to a strongly connected component
// mark them as false in the array (on the stack)

import java.util.*;

public class tarjansAlgorithms {
    
    static int timer;
    static ArrayList<ArrayList<Integer>> adj;
    static int[] inTime, low;
    static Stack<Integer> st;
    static boolean[] onStack;
    static ArrayList<ArrayList<Integer>> res;
    

    static void dfs(int src){
        st.push(src);
        onStack[src] = true;
        inTime[src] = low[src] = timer++;

        for(int child: adj.get(src)){
            if(inTime[child]==0){  // not visited
                dfs(child);

                if(onStack[child])               
                    low[src] = Math.min(low[src], low[child]);   // check if source can also reach the ancestor
            }
            else if(onStack[child])
                low[src] = Math.min(low[src], inTime[child]);    // check if child is an ancestor
        }

        // all children are explored
        if(inTime[src] == low[src]){
            ArrayList<Integer> temp = new ArrayList<>();
            while(st.peek()!=src){
                onStack[st.peek()] = false;     // removing from active list
                temp.add(st.pop());
            }
            onStack[st.peek()] = false;
            temp.add(st.pop());
            res.add(temp);
        }
    }

    public static void main(String[] args) throws Exception{
        Scanner obj = new Scanner(System.in);
        int v = obj.nextInt();
        int e = obj.nextInt();
        adj = new ArrayList<>(v);
        for(int i=0; i<v; i++)
            adj.add(new ArrayList<>());
        for(int i=0; i<e; i++){
            int a = obj.nextInt()-1;
            int b = obj.nextInt()-1;
            adj.get(a).add(b);
        }

        inTime = new int[v];   // when a node enters
        low = new int[v];      // low[i] indicates earliest visited vertex that is reachable from i

        st = new Stack<>();
        onStack = new boolean[v];

        low[0] = 0;
        res = new ArrayList<>();
        timer = 1;

        for(int i=0; i<v; i++)
            if(inTime[i]==0)    // not visited
                dfs(i);

        for(int i=0; i<res.size(); i++){
            for(int j: res.get(i))
                System.out.print(j+1 + " ");
            System.out.println();
        }

        obj.close();
    }

}