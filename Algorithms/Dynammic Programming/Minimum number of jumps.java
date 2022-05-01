// Get minimum number of jumps to reach the end of array
// arr = [2, 1, 3, 2]
// 2 -> 3 -> 2
// min jumps = 2

// keep track of max_reach

class min_number_of_jumps{

    public static int getMinJumps(int[] arr){
        if(arr.length <= 1)
            return 0;
        
        if(arr[0] == 0)
            return -1;
        
        int max_reach = arr[0];
        int jumps = 1;
        int steps = arr[0]; // how many steps can be taken before next jump

        for(int i=1; i<arr.length; i++){
            if(i==arr.length-1)
                return jumps;
            max_reach = Math.max(max_reach, i+arr[i]);
            steps--;

            if(steps==0){   // next jump required
                jumps++;
                if(i > max_reach)
                    return -1;
                steps = max_reach - i;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        int[] arr = new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(getMinJumps(arr));
    }
} 