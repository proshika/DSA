class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n=energy.length;
        for(int i=k;i<n;i++){
            energy[i]=Math.max(energy[i],energy[i-k]+energy[i]);
        }
        int max=Integer.MIN_VALUE;
        for(int i=n-1;i>n-k-1;i--){
            max=Math.max(energy[i],max);
        }
        return max;
    }
}