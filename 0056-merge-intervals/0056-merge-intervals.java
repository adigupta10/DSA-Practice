class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);
        ArrayList<List<Integer>> l=new ArrayList<>();
        int st=intervals[0][0];
        int lastend=intervals[0][1];
        boolean flag=true;
        for(int[] x:intervals){
            ArrayList<Integer> temp=new ArrayList<>();
            if(flag){
                flag=false;
                continue;
            }
            int first=x[0];
            if(first<=lastend){
                lastend=Math.max(x[1],lastend);
            }
            else{
                temp.add(st);
                temp.add(lastend);
                l.add(temp);
                st=x[0];
                lastend=Math.max(x[1],lastend);
            }
        }
        l.add(new ArrayList<>(Arrays.asList(st,lastend)));

        int len=l.size();
        int[][] ans=new int[len][2];
        int idx=0;
        for(List<Integer> x: l){
            ans[idx][0]=x.get(0);
            ans[idx++][1]=x.get(1);
        }
        return ans;
    }
}