class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> list = new ArrayList<>();
        // Flatten the grid into a list
        for (int[] row : grid) {
            for (int val : row) {
                list.add(val);
            }
        }

        // Check if all elements can be made equal
        int base = list.get(0);
        for (int num : list) {
            if (Math.abs(num - base) % x != 0) {
                return -1;
            }
        }

        // Sort to find the median
        Collections.sort(list);
        int median = list.get(list.size() / 2);
        int ops = 0;
        for (int num : list) {
            ops += Math.abs(num - median) / x;
        }
        return ops;
    }
}