class Solution {
    public int calPoints(String[] op) {
        Stack<String> st=new Stack<>();
        for(String s:op){
            if(st.isEmpty()){
                st.push(s);
            }
            else if(s.equals("C")){
                st.pop();
            }
            else if(s.equals("D")){
                int old=Integer.parseInt(st.pop());
                int newly=2*old;
                st.push(String.valueOf(old));
                st.push(String.valueOf(newly));
            }
            else if(s.equals("+")){
                int v1=Integer.parseInt(st.pop());
                int v2=Integer.parseInt(st.peek());
                int ans=v1+v2;
                st.push(String.valueOf(v1));
                st.push(String.valueOf(ans));
            }
            else{
                st.push(s);
            }
        }
        int sum=0;
        while(!st.isEmpty()){
            sum+=Integer.parseInt(st.pop());
        }
        return sum;
    }
}