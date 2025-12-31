class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        List<List<Integer>> l=new ArrayList<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(Map.Entry<Integer,Integer> i:map.entrySet()){
                List<Integer> temp=new ArrayList<>();   
            Integer key=i.getKey();
            Integer val=i.getValue();
            temp.add(key);
            temp.add(val);
            l.add(temp);
        }
        l.sort((a,b)->b.get(1)-a.get(1)); 
        int[] arr=new int[k];
        for(int i=0;i<k;i++){
            arr[i]=l.get(i).get(0);
        } 
        return arr;
    }
}