class Solution {
    public String makeGood(String s) {
        Stack<Character> st=new Stack<>();
        int n=s.length();
        st.push(s.charAt(0));
        int i=1;
        while(i<n){
            char f=s.charAt(i);
            if(!st.isEmpty() && Math.abs(st.peek()-f)==32){
                st.pop();
            }
            else{
                st.push(s.charAt(i));
            }
            i++;
        }
        StringBuilder ans=new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        ans.reverse();
        return ans.toString();
    }
}