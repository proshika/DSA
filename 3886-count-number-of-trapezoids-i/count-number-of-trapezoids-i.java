class Solution {
    public int countTrapezoids(int[][] points) {
        long MOD=1000000007;
        Map<Integer,Integer> countBy=new HashMap<>();
        for(int[] p:points){
            countBy.put(p[1],countBy.getOrDefault(p[1],0)+1);
        }
        List<Integer> yCord=new ArrayList<>(countBy.keySet());
        Collections.sort(yCord);

        List<Long> hPlanes=new ArrayList<>();
        for(int y:yCord){
            long c=countBy.get(y);

            if(c>=2){
                hPlanes.add(c*(c-1)/2);

            }else{
                hPlanes.add(0L);
            }
        }
        long prefix=0;
        long result=0;

        for(long h:hPlanes){
            result=(result+prefix*(h%MOD))%MOD;
            prefix=(prefix+h)%MOD;
        }
        return (int)result;
    }
}