class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Max-heap based on potential gain of adding a student
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> 
            Double.compare(b[0], a[0])
        );
        
        // Precompute the gain for each class and add to heap
        for (int[] c : classes) {
            int pass = c[0], total = c[1];
            double gain = gain(pass, total);
            pq.offer(new double[]{gain, pass, total});
        }
        
        // Assign each extra student
        for (int i = 0; i < extraStudents; i++) {
            double[] top = pq.poll();
            int pass = (int)top[1] + 1;
            int total = (int)top[2] + 1;
            pq.offer(new double[]{gain(pass, total), pass, total});
        }
        
        // Calculate the final average
        double sum = 0;
        int n = classes.length;
        while (!pq.isEmpty()) {
            double[] cur = pq.poll();
            sum += cur[1] / cur[2];
        }
        return sum / n;
    }
    
    // Helper to compute the gain of adding a passing student
    private double gain(int pass, int total) {
        double before = (double)pass / total;
        double after = (double)(pass + 1) / (total + 1);
        return after - before;
    }
}