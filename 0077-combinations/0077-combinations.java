class Solution {
    private void solve(int i,List<List<Integer>>ans,List<Integer> temp,int[] arr,int K){
        if(K==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(i==arr.length) return;
        //do
        temp.add(arr[i]);
        //explore
        solve(i+1,ans,temp,arr,K-1);
        //undo
        temp.remove(temp.size()-1);
        solve(i+1,ans,temp,arr,K);
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        int[] arr=new int[n];
        for(int j=0;j<arr.length;j++){
            arr[j]=j+1;
        }
        solve(0,ans,temp,arr,k);
        return ans;
    }
}