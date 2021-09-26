// Find max of subarrays of size k
// Create deque
// Add only greater elements to end
// Get max from front

import java.util.*;

class Max_of_subarrays{
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int n = obj.nextInt();
        int k = obj.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = obj.nextInt();

        int[] ans = new int[n-k+1];
        Deque<Integer> d = new LinkedList<>();
        for(int i=0; i<k-1; i++){
            while(d.size()>0 && arr[d.peekLast()] < arr[i])
                d.pollLast();
            d.add(i);
        }
        for(int i=0; i<n-k+1; i++){
            while(d.size()>0 && d.peekFirst() < i)
                d.pollFirst();
            while(d.size()>0 && arr[d.peekLast()] <= arr[i+k-1])
                d.pollLast();
            d.add(i+k-1);
            ans[i] = arr[d.peekFirst()];
        }
        for(int i: ans)
            System.out.print(i + " ");
        System.out.println();
    }
}