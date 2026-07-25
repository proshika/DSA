class Solution {
    public int maxProduct(int n) {
        List<Integer> list=new ArrayList<>();
        int max=0;
        while(n>0){
            list.add(n%10);
            n=n/10;
        }
        Collections.sort(list);

        if(list.size()<2) return 0;

        for(int i=1;i<list.size();i++){
            int mult=list.get(i)*list.get(i-1);
            max=Math.max(max,mult);
        }
        return max;
    }
}