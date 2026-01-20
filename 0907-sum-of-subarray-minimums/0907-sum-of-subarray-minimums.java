class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod=1_000_000_007;
        int n=arr.length;
        int[] l=new int[n];
        int[] r=new int[n];
        Stack<Integer> st=new Stack<>();
        //left subarray (contains index)
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            l[i]=st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        //right subarray (contains index)
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            r[i]=st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        long sum=0;
        for(int i=0;i<n;i++){
            long a=(i-l[i]);
            long b=(r[i]-i);
            sum=(sum + ((a*b)%mod) *arr[i]%mod) %mod;
            
        }

        return (int) sum;
    }
}