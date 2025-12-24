class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int count = 0;
        int totalapple=0;  
        Integer[] cap = Arrays.stream(capacity).boxed().toArray(Integer[]::new);
        Arrays.sort(cap, Collections.reverseOrder());
        for (int i = 0; i < apple.length; i++) {
            totalapple += apple[i];
        }
         for (int j = 0; j < cap.length; j++) {
                totalapple=totalapple-cap[j];
                count++;
                if(totalapple<=0){
                    break;
                }
            }
        return count;
    }
}