class Solution {
    public int maxSumMinProduct(int[] nums) {
        int n=nums.length;
        int[] l=new int[nums.length];
        int[] r=new int[nums.length];
        Stack<Integer> st=new Stack<>();
        long[] pre=new long[n+1];
        int mod=1000000007;
        //prefix sum 
        for(int i=0;i<n;i++){
            pre[i+1]=pre[i]+nums[i];
        }
        //left smaller
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            l[i]=st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        //right smaller
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            r[i]=st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        long ans=0;
        for(int i=0;i<n;i++){
            long sum=pre[r[i]]-pre[l[i]+1];
            ans=Math.max(ans,sum*nums[i]);
        }

        return (int)(ans%mod);

    }
}