class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> temp=new ArrayList<>();
            for(int j=0;j<=i;j++){
                temp.add(1);
            }
            for(int j=1;j<i;j++){
                temp.set(j,ans.get(i-1).get(j)  + ans.get(i-1).get(j-1));
            }
            ans.add(temp);
        }
        return ans;
    }
}