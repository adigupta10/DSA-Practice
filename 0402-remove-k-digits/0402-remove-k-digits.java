class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length()==k) return "0";
        Stack<Character> st=new Stack<>();
        for(char ch:num.toCharArray()){
            while(!st.isEmpty() && st.peek()>ch && k!=0){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        while(k-->0){
            st.pop();
        }
        StringBuilder s=new StringBuilder();
        for(char ch : st){
            s.append(ch);
        }
        String x=s.toString();
        int i=0;
        while(i<x.length() && s.charAt(i)=='0') i++;
        if(i==x.length()) return "0";
        return x.substring(i,x.length());
    }
}