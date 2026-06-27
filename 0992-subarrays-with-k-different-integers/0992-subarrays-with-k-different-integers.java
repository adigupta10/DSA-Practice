class Solution {
    public static int solve(int[] arr,int k){
        HashMap<Integer,Integer> map=new HashMap<>();
        int j=0;
        int i=0;
        int count=0;
        while(j<arr.length){
            map.put(arr[j],map.getOrDefault(arr[j],0)+1);
            while(map.size()>k){
                map.put(arr[i],map.get(arr[i])-1);
                if(map.get(arr[i])==0){
                    map.remove(arr[i]);
                }
                i++;
            }
            count+=j-i+1;
            j++;
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return solve(nums,k)-solve(nums,k-1);
    }
}