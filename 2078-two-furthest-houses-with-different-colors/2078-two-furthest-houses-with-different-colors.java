class Solution {
    public int maxDistance(int[] colors) {
        int maxi=0;
        for(int i=0;i<colors.length;i++){
            for(int j=i+1;j<colors.length;j++){
                if(colors[i]!=colors[j]){
                    maxi=Math.max(Math.abs(j-i),maxi);
                }
            }
        }
        return maxi;
    }
}