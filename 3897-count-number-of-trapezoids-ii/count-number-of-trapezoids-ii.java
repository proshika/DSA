class Solution {
    public int countTrapezoids(int[][] points) {
        int n=points.length;
        int traps=0;
        int parallelograms=0;

        Map<String,Integer> slopecount=new HashMap<>();
        Map<String,Integer> linecount=new HashMap<>();

        Map<String,Integer> slopedistcount=new HashMap<>();
        Map<String,Integer> collineardistcount=new HashMap<>();
        
        for(int i=0;i<n;i++){
            int[] p2=points[i];
            for(int j=0;j<i;j++){
                int[] p1=points[j];

                int dx=p2[0]-p1[0];
                int dy=p2[1]-p1[1];

                String slope=(dx!=0)? frac(dy,dx):"inf";
                String intercept;
                if(!slope.equals("inf")){
                    intercept=frac(p1[1]*dx-dy*p1[0],dx);

                }else{
                    intercept="x=" +p1[0];
                }
                String linekey=slope+"|"+intercept;
                int dist=(dx*dx)+(dy*dy);
                String slopedistkey=slope+"|"+dist;
                String collineardistkey=slope+"|"+ intercept+"|"+dist;
                
                slopecount.put(slope,slopecount.getOrDefault(slope,0)+1);
                linecount.put(linekey,linecount.getOrDefault(linekey,0)+1);

                traps+=slopecount.getOrDefault(slope,0)-linecount.getOrDefault(linekey,0);
                slopedistcount.put(slopedistkey,slopedistcount.getOrDefault(slopedistkey,0)+1);
                collineardistcount.put(collineardistkey,collineardistcount.getOrDefault(collineardistkey,0)+1);

                parallelograms+=slopedistcount.getOrDefault(slopedistkey,0)-collineardistcount.getOrDefault(collineardistkey,0);
            }
        }
        return traps-parallelograms/2;
    }
    private String frac(int a, int b) {
    if (b == 0) return "inf";
    int g = gcd(a, b);
    a /= g;
    b /= g;
    // Ensure denominator is positive
    if (b < 0) {
        a = -a;
        b = -b;
    }
    return a + "/" + b;
}

private int gcd(int a, int b) {
    return b == 0 ? Math.abs(a) : gcd(b, a % b);
}
}