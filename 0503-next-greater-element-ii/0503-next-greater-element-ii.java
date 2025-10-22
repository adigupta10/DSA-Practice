class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);
        for (int num : nums) list.add(num);

        int[] res = new int[n];
        for (int i=0;i<n;i++) {
            res[i]=-1;
            for (int j=i+1;j<i+n;j++){
                if(list.get(j)>nums[i]) {
                    res[i]=list.get(j);
                    break;
                }
            }
        }
        return res;
    }
}
