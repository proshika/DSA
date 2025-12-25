class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Integer[] arr = Arrays.stream(happiness).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());
        long ans = 0;
        for (int i = 0; i < k; i++) {
            ans += Math.max(arr[i] - i, 0);
        }
        return ans;
    }
}