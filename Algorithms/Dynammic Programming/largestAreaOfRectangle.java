// calculate maximum histogram each row
// 1. If value is 1 increase the value in hist array
// 2. If value is 0 update the value to 0 in hist array

// maximum histogram area
// 1. Add index to stack if current value is bigger than top of stack
// 2. Otherwise keep removing from stack till a number which is smaller or equal than current is found.
// 3. Calculate area everytime you pop -> area from [top index, current index)

import java.util.*;

class largestAreaOfRectangle{

    public static int getMaxHistogramArea(int[] arr){
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();
        int i = 0;
        int top;
        while(i < arr.length){
            if(st.empty() || arr[st.peek()] <= arr[i])
                st.add(i++);
            else{
                top = st.pop();
                maxArea = Math.max(maxArea, arr[top] * (st.empty() ? i : (i-st.peek()-1) ));
            }
        }
        while(!st.empty()){
            top = st.pop();
            maxArea = Math.max(maxArea, arr[top] * (st.empty()?i:(i-st.peek()-1)) );
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
            {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1},
            {1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
            {1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0},
            {1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1},
            {1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1},
            {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1}
          };
        int hist[] = new int[arr[0].length];
        int maxArea = 0;
        for(int[] row: arr){
            for(int i=0; i<row.length; i++)
                hist[i] = (row[i]==0 ? 0 : hist[i]+1);
            maxArea = Math.max(maxArea, getMaxHistogramArea(hist));
        }
        System.out.println(maxArea);
    }
}