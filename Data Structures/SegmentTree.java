public class SegmentTree {
    private int originalSize;
    int size;
    int arr[];

    public SegmentTree(int vals[]){
        originalSize = vals.length;
        // size needed
        size = (int)(Math.ceil(Math.log(originalSize) / Math.log(2)));
        size = 2 * (int)Math.pow(2,size) - 1;
        
        // allocation
        arr = new int[size];

        // construct
        constructSegmentTree(0, originalSize-1, 0, vals);     
    }

    private int constructSegmentTree(int l, int r, int i, int vals[]){
        // leaf node
        if(l==r)
            arr[i] = vals[l];
        
        // internal node
        else{
            int left = i*2+1;
            int right = left+1;
            int mid = (int)((l+r)/2);
            arr[i] = constructSegmentTree(l, mid, left, vals) + constructSegmentTree(mid+1, r, right, vals);
        }

        return arr[i];
    }

    // update
    public void update(int index, int value){
        updateUtil(value, 0, originalSize-1, index, 0);
    }

    private int updateUtil(int value, int l, int r, int i, int at){
        // out of range
        if(i<l || i>r)
            return arr[at];
        
        // leaf node
        else if(l==r) arr[at] = value; 
        
        // internal node
        else{
            int mid = (int)((l+r)/2);
            arr[at] = updateUtil(value, l, mid, i, at*2+1) + updateUtil(value, mid+1, r, i, at*2+2);
        } 
        return arr[at];
    }

    // get sum
    public int getSum(int start, int end){
        if(start<0 || end>=originalSize)
            return 0;
        return getSumUtil(start, end, 0, originalSize-1, 0);
    }

    private int getSumUtil(int start, int end, int l, int r, int i){
        // inside the range
        if(l>=start && r<=end)
            return arr[i];
        
        // outside the range
        else if(r<start || l>end)
            return 0;
        
        // overlaps with range
        int mid = (int)((l+r)/2);
        return getSumUtil(start, end, l, mid, i*2+1) + getSumUtil(start, end, mid+1, r, i*2+2);
    }   
}