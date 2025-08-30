/**
 There are two arrays nums1 and nums2.
 Count all pairs such that:
 nums1[i] - nums[j] <= nums2[i] - nums1[j] + diff.
 Constraint: i < j
*/

import java.util.Arrays;

public class mergeSort {
    static long count;
    static int d;

    public static void main(String[] args) {
        int[] nums1 = new int[]{3, 2, 5};
        int[] nums2 = new int[]{2, 2, 1};

        long pairs = numberOfPairs(nums1, nums2, 1);
        System.out.printf("Number of Pairs: %d\n", pairs);
    }

    private static long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        count = 0;
        d = diff;
        int n = nums1.length;
        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = nums1[i]-nums2[i];

        runMergeSort(nums, 0, n-1);

        return count;
    }

    private static void runMergeSort(int[] nums, int l, int r){
        if(l<r){
            int mid = l + (r-l)/2;
            runMergeSort(nums, l, mid);
            runMergeSort(nums, mid+1, r);

            for(int i=l, j=mid+1; i<=mid && j<=r; ){
                if(nums[i] <= nums[j] + d){
                    count += r-j+1;
                    i++;
                }
                else
                    j++;
            }

            Arrays.sort(nums, l, r+1);
        }
    }
}
