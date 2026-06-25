class Solution {
    public int findKthPositive(int[] arr, int k) {
        HashSet<Integer> set=new HashSet<>();
        for(int x:arr) set.add(x);
        ArrayList<Integer> l=new ArrayList<>();
        int i=1;
        while(l.size()<=k){
            if(set.contains(i)){
                set.remove(i);
            }
            else{
                l.add(i);
            }
            i++;
        }
        return l.get(k-1);
    }
}