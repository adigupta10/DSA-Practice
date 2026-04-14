class Solution {
     static int[] rank;
        static int[] parent;
    public int removeStones(int[][] stones) {
        int n=stones.length;
       rank=new int[n]; 
        parent=new int[n]; 
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(stones[i][0]==stones[j][0] ||stones[i][1]==stones[j][1] ){
                    int x=find(i,parent);
                    int y=find(j,parent);
                    if(x!=y) union(x,y);
                }
            }
        }
        int grp=0;
        for(int i=0;i<n;i++){
            if(parent[i]==i) grp++;
        }
        return n-grp;
    }
    //union and find
    public static int find(int x,int[] parent){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x],parent); 
    }
    public static void union(int x,int y){
        if(rank[x]>rank[y]){
            parent[y]=x;
        }
        else if(rank[y]>rank[x]){
            parent[x]=y;
        }
        else{
            parent[x]=y;
            rank[y]+=1;
        }
    }
}