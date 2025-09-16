import java.util.*;

class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> stack = new ArrayList<>();
        for (int num : nums) {
            while (!stack.isEmpty()) {
                int top = stack.get(stack.size() - 1);
                int g = gcd(top, num);
                if (g > 1) {
                    // Merge with LCM and continue checking
                    num = lcm(top, num, g);
                    stack.remove(stack.size() - 1);
                } else {
                    break;
                }
            }
            stack.add(num);
        }
        return stack;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    private int lcm(int a, int b, int g) {
        return (int) ((long)a * (long)b / g);
    }
}