class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        List<Integer> missingList = Allmissing(nums);
        if (missingList.size() > 0) {
            return missingList.get(0);
        } else {
            return nums.length + 1;
        }
    }

    private List<Integer> Allmissing(int nums[]) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }
}