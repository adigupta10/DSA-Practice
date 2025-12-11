class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 =new HashSet<>();
        HashSet<Integer> set2 =new HashSet<>();
        List<Integer> temp=new ArrayList<>();
        List<Integer> temp2=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        for(int i:nums1){
            set1.add(i);
        }
        for(int j:nums2){
            set2.add(j);
        }
        for(int i:set1){
            if(!set2.contains(i)){
                temp.add(i);
            }
        }
        ans.add(temp);
        for(int j:set2){
            if(!set1.contains(j)){
                temp2.add(j);
            }
        }
        ans.add(temp2);
        return ans;
    }
}