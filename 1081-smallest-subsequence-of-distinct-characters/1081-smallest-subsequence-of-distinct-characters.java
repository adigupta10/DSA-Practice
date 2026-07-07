class Solution {
    public String smallestSubsequence(String s) {
       Stack<Character> st=new Stack<>();
        int[] lastidx=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            lastidx[ch-'a']=i;
        }
        boolean[] taken=new boolean[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            int idx=ch-'a';
            if(taken[idx]) continue;

            while(!st.isEmpty() && ch<st.peek() && lastidx[st.peek()-'a'] >i){
                taken[st.peek()-'a']=false;
                st.pop();
            }
            st.push(ch);
            taken[idx]=true;
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString(); 
    }
}