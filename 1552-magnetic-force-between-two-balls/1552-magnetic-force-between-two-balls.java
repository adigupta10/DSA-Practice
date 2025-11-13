class Solution {
    public boolean canBePlace(int[] position, int m , int mid){
        int lastpos=position[0];
        int count=1;
        for(int i=1;i<position.length;i++){
            if(position[i]-lastpos >=mid){
                count++;
                lastpos=position[i];
            }
            if(count==m){
                return true;
            }
        }
        return false;
    }
    public int maxDistance(int[] position, int m) {
        int n=position.length;
        Arrays.sort(position);
        int ans=0;
        int maxdis=position[n-1]-position[0];
        int left=1; int right=position[n-1];
        while(left<=right){
            int mid=left+(right-left)/2;
            if(canBePlace(position,m,mid)){
                ans=mid;
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return ans;
    }
}

// class Solution {
//     public int maxDistance(int[] position, int m) {
//         int n=position.length;
//         int ans=0;
//         Arrays.sort(position);
//         int maxdis=position[n-1]-position[0];
//         for(int i=1;i<=maxdis;i++){    // i=[1,2,3,4,5,6]; possible answers;
//             int count=1;
//             int lastpos=position[0];
//             for(int j=1;j<n;j++){
//                 if((position[j]-lastpos)>=i){
//                     lastpos=position[j];
//                     count++;
//                 }

//                 if(count==m){
//                     ans=i;
//                     break;
//                 }
//             }
//         }
//         return ans;
//     }
// }