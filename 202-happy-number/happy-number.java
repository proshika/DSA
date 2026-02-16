class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen=new HashSet<>();
        while(n!=1 && !seen.contains(n)){
            seen.add(n);
            int sum=0;
            int curr=n;
            while(curr>0){
                int digit=curr%10;
                sum+=digit*digit;
                curr/=10;
            }
            n=sum;
        }
        if(n==1){
           return true;
        }else{
            return false;
        }
    }
}