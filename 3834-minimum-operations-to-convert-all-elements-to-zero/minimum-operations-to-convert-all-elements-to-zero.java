class Solution {
    public int minOperations(int[] nums) {
        int count=0;
        Stack<Integer> s=new Stack<>();
        for(int n:nums){
            while(!s.isEmpty() && s.peek()>n){
                s.pop();
            }
            if(n==0) continue;

            if(s.isEmpty() || s.peek()<n){
                count++;
                s.push(n);
            }
        }
        return count;
    }
}