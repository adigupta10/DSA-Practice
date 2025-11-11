class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int[] i : nums1){
            map.put(i[0],i[1]);
        }
        for(int[] k : nums2){
               if(map.containsKey(k[0])){
                map.put(k[0],map.get(k[0])+k[1]);
               }
               else{
                map.put(k[0],k[1]);
               }
            }
            int m=0;
        int[][] arr=new int[map.size()][2];
        for(int x:map.keySet()){
            arr[m][0]=x;
            arr[m][1]=map.get(x);
            m++;
        }
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        return arr;
    }
}