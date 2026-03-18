class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<List<Integer>> l=new ArrayList<>();
        ArrayList<List<Integer>> ans=new ArrayList<>();
        for(int[] x: intervals){
           l.add(new ArrayList<>(Arrays.asList(x[0],x[1])));
        }
        l.add(new ArrayList<>(Arrays.asList(newInterval[0],newInterval[1])));
        Collections.sort(l,(a,b)-> a.get(0) - b.get(0));
        int st=l.get(0).get(0);
        int ed=l.get(0).get(1);
        for(int i=1;i<l.size();i++){
            int currst=l.get(i).get(0);
            int curred=l.get(i).get(1);
            if(currst<=ed){
                ed=Math.max(ed,curred);
            }
            else{
                ans.add(new ArrayList<>(Arrays.asList(st,ed)));
                st=currst;
                ed=curred;
            }
        }

       ans.add(new ArrayList<>(Arrays.asList(st,ed)));

        int[][] arr = new int[ans.size()][2];
        int idx=0;
        for(List<Integer> x :ans){
            arr[idx][0]=x.get(0);
            arr[idx][1]=x.get(1);
            idx++;
        }
        return arr;
    }
}