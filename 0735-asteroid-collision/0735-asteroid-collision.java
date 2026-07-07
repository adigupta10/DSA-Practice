class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                st.push(arr[i]);
                continue;
            }
            boolean flag=true;
            while(!st.isEmpty() && (arr[i]<0 && st.peek()>0)){
                int sum=arr[i]+st.peek();
                if(sum<0){
                    st.pop();
                }
                else if(sum==0){
                    st.pop();
                    flag=false;
                    break;
                }
                else{
                    flag=false;
                    break;
                }
            }
            if(flag){
                st.push(arr[i]);
            }
        }
        int[] ans=new int[st.size()];
        for(int i=ans.length-1;i>=0;i--) ans[i]=st.pop();
        return ans;
    }
}