class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        for(int curr:asteroids){
             int flag=0;
             while(!st.isEmpty() && curr<0 && st.peek()>0){
                if(Math.abs(curr)>st.peek()){
                    st.pop();
                }
                else if(Math.abs(curr)<st.peek()){
                    flag=1;
                    break;
                }
                else{
                    if(Math.abs(curr)==st.peek()){
                        st.pop();
                        flag=1;
                        break;
                    }
                }
             }  
             if(flag!=1) st.push(curr);
        }
        int[] ans=new int[st.size()];
        for(int i=ans.length-1;i>=0;i--) ans[i]=st.pop();
        return ans; 
    }
}