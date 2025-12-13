class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        // Define the custom order for businessLine
        Map<String, Integer> order = new HashMap<>();
        order.put("electronics", 0);
        order.put("grocery", 1);
        order.put("pharmacy", 2);
        order.put("restaurant", 3);

        // Store valid coupons as pairs of (code, businessLine)
        List<Coupon> validCoupons = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {
            if (!code[i].isEmpty() && code[i].matches("[a-zA-Z0-9_]+")
                && order.containsKey(businessLine[i])
                && isActive[i]) {
                validCoupons.add(new Coupon(code[i], businessLine[i]));
            }
        }

        // Sort by businessLine order, then by code lex
        Collections.sort(validCoupons, (a, b) -> {
            int cmp = Integer.compare(order.get(a.businessLine), order.get(b.businessLine));
            if (cmp == 0) {
                return a.code.compareTo(b.code);
            }
            return cmp;
        });

        // Extract codes for the answer
        List<String> ans = new ArrayList<>();
        for (Coupon c : validCoupons) {
            ans.add(c.code);
        }
        return ans;
    }

    // Helper class for coupon info
    static class Coupon {
        String code;
        String businessLine;
        Coupon(String code, String businessLine) {
            this.code = code;
            this.businessLine = businessLine;
        }
    }
}