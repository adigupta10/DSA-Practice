class Solution {
    public int calculate(String s) {
        Stack<Integer> st=new Stack<>();
        int num=0;
        int result=0;
        int sign=1;
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                num=num*10 + ch-'0';
            }
            else if(ch=='+'){
                result+=num*sign;
                sign=1;
                num=0;
            }
            else if(ch=='-'){
                result+=num*sign;
                sign=-1;
                num=0;
            }
            else if(ch=='('){
                st.push(result);
                st.push(sign);
                result=0;
                num=0;
                sign=1;
            }
            else if(ch==')'){
                result+=num*sign;
                int symbol=st.pop();
                int stValue=st.pop();
                result*=symbol;
                result+=stValue;
                num=0;
            }
        }
        result+=num*sign;
        return result;
    }
}