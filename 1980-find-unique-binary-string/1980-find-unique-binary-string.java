class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb=new StringBuilder();
        int i=0;
        for(String n: nums){
            if(n.charAt(i++)=='1'){
                sb.append('0');
            }
            else {
                sb.append('1');
            }
        }
        return sb.toString();
    }
}