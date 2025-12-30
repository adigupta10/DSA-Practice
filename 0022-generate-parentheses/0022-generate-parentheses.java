class Solution {
    private void solve(int n,int left,int right,StringBuilder temp,List<String> ans){
        if(temp.length()==2*n){
            ans.add(temp.toString());
        }
        if(left<n){
            temp.append("(");
            solve(n,left+1,right,temp,ans);
            temp.deleteCharAt(temp.length()-1);
        }
        if(right<left){
            temp.append(")");
             solve(n,left,right+1,temp,ans);
             temp.deleteCharAt(temp.length()-1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        StringBuilder temp=new StringBuilder();
        solve(n,0,0,temp,ans);
        return ans;
    }
}