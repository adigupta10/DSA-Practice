class Solution {

    private void findSubsets(int[] arr, int idx, List<List<Integer>> ans, List<Integer> list) {
        ans.add(new ArrayList<>(list));
        for(int i=idx; i<arr.length; i++) {
            if(i != idx && arr[i] == arr[i-1]) continue;
            list.add(arr[i]);
            findSubsets(arr, i+1, ans, list);
            list.remove(list.size()-1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        findSubsets(nums, 0, ans, new ArrayList<>());

        return ans;
    }
} 