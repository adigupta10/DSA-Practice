class Solution {
    public int totalSteps(int[] nums) {
        int ans=0;
        int n=nums.length;
        Stack<int[]> st=new Stack<>();
        st.push(new int[]{nums[n-1],0});
        for(int i=n-2;i>=0;i--){
            int count=0;
            while(!st.isEmpty() && nums[i]>st.peek()[0]){
                count=Math.max(count+1,st.peek()[1]);
                st.pop();
            }
            ans=Math.max(ans,count);
            st.push(new int[]{nums[i],count});
        }
        return ans;
    }
}
        // ArrayList<Integer> l=new ArrayList<>();
        // for(int x:nums) l.add(x);
        // int steps=0;
        // while(true){
        //     ArrayList<Integer> temp=new ArrayList<>();
        //     for(int i=1;i<l.size();i++){
        //         if(l.get(i)<l.get(i-1)){
        //             temp.add(i);
        //         }
        //     }
        //     if(temp.size()==0) break;

        //     for(int j=temp.size()-1;j>=0;j--){
        //         l.remove(temp.get(j));
        //     }
        //     steps++;
        // }
        // return steps;