class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int srow=0,scol=0,erow=n-1,ecol=m-1;
        ArrayList<Integer> l=new ArrayList<>();
        // srow erow scol ecol
        int idx=0;
        while(srow<=erow && scol<=ecol){
            //right
            for(int i=scol ;i<=ecol;i++){
                l.add(arr[srow][i]);
            }
            //down
            for(int i=srow+1 ;i<=erow;i++){
                l.add(arr[i][ecol]);
            }
            //right
            for(int i=ecol-1 ;i>=scol;i--){
                if(srow==erow) break;
                l.add(arr[erow][i]);
            }
            //up
            for(int i=erow-1 ;i>=srow+1;i--){
                if(scol==ecol) break;
                l.add(arr[i][scol]);
            }
            srow++;
            scol++;
            erow--;
            ecol--;
        }
        return l;
    }
}