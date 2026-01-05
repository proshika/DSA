class Solution {
    public int sumFourDivisors(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            List<Integer> divisors = getdivisor(nums[i]);
            if (divisors.size() == 4) {
                for (int d : divisors) {
                    sum += d;
                }
            }
        }
        return sum;
    }

    List<Integer> getdivisor(int num) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                ans.add(i);
                if (i != num / i) {
                    ans.add(num / i);
                }
            }
        }
        return ans;
    }
}