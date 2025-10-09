class Solution {
    public int maxPoints(int[][] points) {
        if(points.length<=2) return points.length;
        int maxi=0;
        for(int i=0;i<points.length-1;i++){
            HashMap<Double,Integer> map=new HashMap<>();
            int currmax=0;
            int duplicate=1;
            for(int j=i+1;j<points.length;j++){
                int dx=points[j][0]-points[i][0];
                int dy=points[j][1]-points[i][1];
                if(dx==0 && dy==0){
                    duplicate++;
                }
                else{
                    double slope;
                    if(dx==0){
                        slope=Double.POSITIVE_INFINITY;
                    }
                    else{
                        slope=(double)dy/dx;
                        if(slope==-0.0) {
                            slope=0.0;
                        }
                    }
                    map.put(slope,map.getOrDefault(slope,0)+1);
                    currmax=Math.max(currmax,map.get(slope));
                }
            }
                maxi=Math.max(maxi,currmax+duplicate);
            }
        return maxi;
    }
}
