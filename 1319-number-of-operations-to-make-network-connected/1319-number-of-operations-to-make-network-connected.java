class Solution {
        static int[] rank;
        static int[] parent;
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1) return -1;
        rank=new int[n]; 
        parent=new int[n]; 
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }
        int components=n;
        for(int[] x:connections){
            int f=x[0];
            int s=x[1];

            int f_par=find(f,parent);
            int s_par=find(s,parent);

            if(f_par!=s_par){
                union(f_par,s_par);
                components--;
            }
        }
        return components-1;
    }
    //find and union
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