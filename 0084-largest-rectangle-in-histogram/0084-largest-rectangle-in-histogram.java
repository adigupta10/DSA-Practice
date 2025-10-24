class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
        int[] left=new int[n];
        int[] right=new int[n];
        //left smaller
        for(int i=0;i<n;i++){
            while(!st.isEmpty()  && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            left[i]=st.isEmpty() ? -1 : st.peek(); 
            st.push(i);
        }
        //empty the stack
        while(!st.isEmpty()){
            st.pop();
        }
        //right smaller
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()  && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            right[i]=st.isEmpty() ? n : st.peek(); 
            st.push(i);
        }
        int ans=0;
        //area calculation
        for(int i=0;i<n;i++){
            int width=right[i]-left[i]-1;
            ans=Math.max(ans,heights[i]*width);

        }
        return ans;
    }
}