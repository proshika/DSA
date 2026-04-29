class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] found = new boolean[3];
        for (int[] t : triplets) {
            if (t[0] <= target[0] && t[1] <= target[1] && t[2] <= target[2]) {
                if (t[0] == target[0]) found[0] = true;
                if (t[1] == target[1]) found[1] = true;
                if (t[2] == target[2]) found[2] = true;
            }
        }
        return found[0] && found[1] && found[2];
    }
}