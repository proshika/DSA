class Solution {
    public int findKthPositive(int[] arr, int k) {
        Set<Integer> s = new HashSet<>();
        for (int num : arr) {
            s.add(num);
        }
        int count = 0;
        int num = 1;
        while (true) {
            if (!s.contains(num)) {
                count++;
                if (count == k) {
                    return num;
                }
            }
            num++;
        }
    }
}