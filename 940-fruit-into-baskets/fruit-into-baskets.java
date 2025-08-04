class Solution {
    public int totalFruit(int[] fruits) {
        int left=0;
        int maxfruit=0;
        int count=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int right=0;right<fruits.length;right++){
           hm.put(fruits[right],hm.getOrDefault(fruits[right],0)+1);
           while(hm.size()>2){
                hm.put(fruits[left],hm.get(fruits[left])-1);
  
              if(hm.get(fruits[left])==0){
                 hm.remove(fruits[left]);
              }
                left++;
           }
          maxfruit=Math.max(maxfruit,right-left+1);
        }
       return maxfruit;

    }
}