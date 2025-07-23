class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> s=new Stack<>();
        for(String token:tokens){
            if(isOperator(token)){
            int nums2=Integer.parseInt(s.pop());
            int nums1=Integer.parseInt(s.pop());
            int result=0;
            if(token.equals("+")){
                result=nums1+nums2;
            }
            else if(token.equals("-")){
                result=nums1-nums2;
            }
            else if(token.equals("*")){
                result=nums1*nums2;
            }
            else if(token.equals("/")){
                result=nums1/nums2;
            }
            s.push(Integer.toString(result));
            }
            else{
                s.push(token);
            }
        }
        return Integer.parseInt(s.peek());
    }
    private boolean isOperator(String str){
        if(str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/")){
            return true;
        }
        return false;
    }
}