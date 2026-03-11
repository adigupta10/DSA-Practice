class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            if(a[1]!=b[1]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });
        for(int key:map.keySet()){
            pq.offer(new int[]{key,map.get(key)});
            if(pq.size()>k) pq.poll();
        }
        int[] ans=new int[k];
        int index=0;
        while(!pq.isEmpty()){
            ans[index++]=pq.poll()[0];
        }
        return ans;
    }
}