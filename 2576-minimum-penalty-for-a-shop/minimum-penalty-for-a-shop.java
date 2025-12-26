class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int penalty = 0;
        for (int i = 0; i < n; i++) {
            if (customers.charAt(i) == 'Y') {
                penalty++;
            }
        }
        int minpenalty = penalty;
        int besthour = 0;

        for (int hour = 0; hour < n; hour++) {
            if (customers.charAt(hour) == 'Y') {
                penalty--;
            } else {
                penalty++;
            }
            if (penalty < minpenalty) {
                minpenalty = penalty;
                besthour = hour + 1;
            }
        }
        return besthour;
    }
}