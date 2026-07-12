class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] ans=Arrays.copyOf(arr,arr.length);
        Arrays.sort(ans);
        HashMap<Integer,Integer> map=new HashMap<>();
        int rank=1;
        for(int i=0;i<ans.length;i++){
            if(!map.containsKey(ans[i])){
                map.put(ans[i],rank++);
            }
        }
        int[] res=new int[arr.length];
        for(int j=0;j<arr.length;j++){
            int temp=map.get(arr[j]);
            res[j]=temp;
        }
        return res;
    }
}