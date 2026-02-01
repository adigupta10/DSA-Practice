class Solution {
    public String removeOccurrences(String s, String part) {
        Stack<Character> st=new Stack<>();
        int k=part.length();
        int n=s.length();
        for(int i=0;i<n;i++){
            st.push(s.charAt(i));
            if(st.size()>=k){
                int j=k-1;
                boolean found=true;

               for(int a=0;a<k;a++){
                    if(st.get(st.size()-1-a)!=part.charAt(j)){  //we are not using st.peek() because it never moves , it will check only the first element
                        found=false;
                        break;
                    }
                    
                    j--;
                    
               }
               if(found){
                for(int d=0;d<k;d++){
                    st.pop();
                }
               }
            }
        }
        String ans="";
        while(!st.isEmpty()){
            ans=st.pop()+ans;
        }
        return ans;
    }
}