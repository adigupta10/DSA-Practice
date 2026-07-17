class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<Integer> l=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        int n=arr.length;
        Arrays.sort(arr);
        int mini=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            int min=arr[i]-arr[i-1];
            mini=Math.min(mini,min);
        }
        for(int i=0;i<n;i++){
            if(i<n-1 && (arr[i+1]-arr[i])==mini){
                ans.add(Arrays.asList(arr[i],arr[i+1]));
            }
        }
        return ans;
    }
}