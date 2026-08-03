class Solution {
    public int minCost(String s, int[] neededTime) {
        Stack<Integer> st=new Stack<>();
        int cost=0;
        for(int i=0;i<neededTime.length;i++){
            if(st.isEmpty()){
                st.push(i);
            }
            else{
                int top=st.peek();
                if(s.charAt(top)!=s.charAt(i)){
                    st.push(i);
                }
                else{
                    if(neededTime[i]>neededTime[top]){
                        cost+=neededTime[top];
                        st.pop();
                        st.push(i);
                    }
                    else{
                        cost+=neededTime[i];
                    }
                }
            }
        }
        return cost;
    }
}