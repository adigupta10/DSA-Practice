class Solution {
    static int n;
    static int m;
    public int largestIsland(int[][] grid) {
        int[][] dir={{0,1},{1,0},{-1,0},{0,-1}};
        n=grid.length;
        m=grid[0].length;
        int largest=0;
        int id=2;   // marking ke liye becaz 0,1 is already present
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int x=0;x<n;x++){
            for(int y=0;y<m;y++){
                if(grid[x][y]==1){
                    int size=dfs(x,y,grid,id);
                    largest=Math.max(size,largest);
                    map.put(id,size);
                    id++;
                }
            }
        }


        for(int x=0;x<n;x++){
            for(int y=0;y<m;y++){
                if(grid[x][y]==0){
                    HashSet<Integer> set=new HashSet<>();
                   for(int[] d:dir){
                        int xdash= x+d[0];
                        int ydash= y+d[1];
                        if(xdash>=0 && ydash>=0 && xdash<n && ydash<m && grid[xdash][ydash]>1){
                            set.add(grid[xdash][ydash]);
                        }
                   }
                   int sum=1;
                   for(int key:set){
                    sum+=map.get(key);
                   } 
                   largest=Math.max(largest,sum);
                }
            }
        }

        return largest;
    }
    public static int dfs(int i, int j, int[][] grid,int id){
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]!=1){   // 1 ke alawa kuch bhi ho return 0 ,as we have to find only 1 in dfs
            return 0;
        }
        grid[i][j]=id;

        int count=1;
        count+=dfs(i+1,j,grid,id);
        count+=dfs(i-1,j,grid,id);
        count+=dfs(i,j+1,grid,id);
        count+=dfs(i,j-1,grid,id);

        return count;
    }
}