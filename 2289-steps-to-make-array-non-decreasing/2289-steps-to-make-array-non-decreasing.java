class Solution{
    public int totalSteps(int[] nums){
        Stack<int[]> st=new Stack<>();
        int ans=0;

        for(int i=0;i<nums.length;i++){
            int steps=0;

            while(!st.isEmpty()&&nums[i]>=st.peek()[0]){
                steps=Math.max(steps,st.pop()[1]);
            }

            if(!st.isEmpty()){
                steps++;
            }

            ans=Math.max(ans,steps);
            st.push(new int[]{nums[i],steps});
        }
        return ans;
    }
}

    //     ArrayList<Integer> l=new ArrayList<>();
    //     while(!st.isEmpty()){
    //       l.add(st.pop());
    //     }
    //     System.out.print(l);
    // }