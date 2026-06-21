class Solution {
    public List<Integer> getRow(int n) {
        List<Integer> l=new ArrayList<>();
        long ans=1;
        l.add(1);
        for(int col=1;col<=n;col++){
            ans*=(n-col+1);
            ans/=col;
            l.add((int)ans);
        }
        return l;
    }
}