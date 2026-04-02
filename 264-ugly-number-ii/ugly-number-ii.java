class Solution {
    public int nthUglyNumber(int n) {
        int ans[]=new int[n];
        ans[0]=1;
        int a=0,b=0,c=0;
        for(int i=1;i<n;i++){
            int l1=ans[a]*2;
            int l2=ans[b]*3;
            int l3=ans[c]*5;
            int next=Math.min(l1,Math.min(l2,l3));
            ans[i]=next;

            if(next==l1) a++;
            if(next==l2) b++;
            if(next==l3) c++;
        }
        return ans[n-1];
    }
}