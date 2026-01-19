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
        StringBuilder s=new StringBuilder();
        for(char ch : st){
            s.append(ch);
        }
        int right=s.length()-1;
        while(k!=0){
            s.deleteCharAt(right);
            right--;
            k--;
        }
        while(s.charAt(0)=='0' && s.length()!=1){
           s.deleteCharAt(0);
        }    
        return s.toString();
    }
}