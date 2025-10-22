class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] arr=new int[nums1.length];
        int index=0;
        for(int i=0;i<nums1.length;i++){
            int currelement=nums1[i];
            int currindex=-1;
            for(int j=0;j<nums2.length;j++){
                if(nums2[j]==currelement){
                    currindex=j;
                    break;
                }
            }
            int count=-1;
            for(int k=currindex+1;k<nums2.length;k++){
                if(nums2[k]>currelement){
                    count=nums2[k];
                    break;
                }
            }
            arr[index++]=count;
        }
        return arr;
    }
}