class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] largeInterval=new int[intervals.length+1][2];
        for(int i=0;i<intervals.length;i++){
            largeInterval[i][0]=intervals[i][0];
            largeInterval[i][1]=intervals[i][1];
        }
        largeInterval[largeInterval.length-1][0]=newInterval[0];
        largeInterval[largeInterval.length-1][1]=newInterval[1];

        Arrays.sort(largeInterval,(a,b)->a[0]-b[0]);
        

        ArrayList<List<Integer>> l=new ArrayList<>();
        int st=largeInterval[0][0];
        int lastend=largeInterval[0][1];
        boolean flag=true;
        for(int[] x:largeInterval){
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
                lastend=x[1];
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