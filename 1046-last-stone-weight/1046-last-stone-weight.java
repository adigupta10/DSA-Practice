class Solution {
    public static int solve(ArrayList<Integer> l){
        int ans=0;
        for(int i=1;i<l.size();i++){
            if(l.get(i)>=l.get(ans)){
                ans=i;
            }
        }
        return ans;

    }
    public int lastStoneWeight(int[] stones) {
        ArrayList<Integer> l=new ArrayList<>();
        for(int x:stones){
            l.add(x);
        }
        if(l.size()==1) return 1;
        while(l.size()>1){
            int m1=solve(l);
            int x=l.get(m1);
            l.remove(m1);
            int m2=solve(l);
            int y=l.get(m2);
            l.remove(m2);

            if(x!=y){
               l.add(x-y);
            }
        }
        return l.size()==0 ? 0 : l.get(0);
    }
}