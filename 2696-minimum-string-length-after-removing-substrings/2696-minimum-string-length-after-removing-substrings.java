class Solution {
    public int minLength(String s) {
        Stack<Character> st=new Stack<>();
        int n=s.length();
        st.push(s.charAt(0));
        int i=1;
        while(i<n){
            if(!st.isEmpty() && (st.peek()=='A'  && s.charAt(i)=='B' ||
               st.peek()=='C'  && s.charAt(i)=='D')
            ){
                st.pop();
            }
            else{
                st.push(s.charAt(i));
            }
            i++;
        }
            return st.size();
    }
}