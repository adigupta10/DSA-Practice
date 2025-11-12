class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        //converting the 2D array in flaten array
        int row=grid.length;
        int col=grid[0].length;
        int[] arr=new int[row*col];
        int index1=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                arr[index1++]=grid[i][j];
            }
        }
        int size=arr.length;
        k=k%size;
        int[] newArray=new int[size];
        //operations on flaten array
        for(int i=0;i<arr.length;i++){
            newArray[(i+k)%size]=arr[i];
        }
        int index2=0;
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<row;i++){
            List<Integer> temp=new ArrayList<>();
            for(int j=0;j<col;j++){
                temp.add(newArray[index2++]);
            }
            l.add(temp);
        }
        return l;
    }
}