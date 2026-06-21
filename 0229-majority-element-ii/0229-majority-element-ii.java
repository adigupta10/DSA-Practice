class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int m1=-1; int m2=-1;
        int c1=0; int c2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==m1){
                c1++;
            }
            else if(nums[i]==m2){
                c2++;
            }
            else if(c1==0){
                c1=1;
                m1=nums[i];
            }
            else if(c2==0){
                c2=1;
                m2=nums[i];
            }
            else{
                c1--;
                c2--;
            }
        }  
        ArrayList<Integer> l=new ArrayList<>();
        int countm1=0;
        int countm2=0;
        for(int i:nums){
            if(i==m1) countm1++;
            if(i==m2) countm2++;
        }  
        if(countm1>(nums.length/3)){
            l.add(m1);
        }
        if(countm2>(nums.length/3)){
            l.add(m2);
        }
        if(m1==m2){
            l.remove(0);
        }
        return l;      
    }
}