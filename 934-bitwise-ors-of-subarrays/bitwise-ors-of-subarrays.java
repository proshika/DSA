import java.util.*;
class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> curr=new HashSet<>();
        Set<Integer> unique=new HashSet<>();

        if(arr==null || arr.length==0){
            return 0;
        }
        for(int num:arr){
            Set<Integer> nextOr=new HashSet<>();
            nextOr.add(num);

            for(int prev:curr){
                nextOr.add(prev|num);
            }
            unique.addAll(nextOr);
            curr=nextOr;
        }
        return unique.size();
    }
}