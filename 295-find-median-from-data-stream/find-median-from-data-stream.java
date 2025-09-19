class MedianFinder {
    private List<Integer> nums;
    public MedianFinder() {
        nums=new ArrayList<>();
    }
    
    public void addNum(int num) {
        int idx=Collections.binarySearch(nums,num);
        if(idx<0) idx=-idx-1;
        nums.add(idx,num);
    }
    
    public double findMedian() {
        int n=nums.size();
       if(n%2==1) return nums.get(n/2);
       else{
        return (nums.get(n/2-1)+nums.get(n/2))/2.0;
       }
    }
}//TC=O(n);
//SC=O(n);
