import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();

        // Step 1: Duplicate array (to simulate circular behavior)
        for (int num : nums) list.add(num);
        for (int num : nums) list.add(num); // duplicate once

        int[] res = new int[n];

        // Step 2: Find next greater for each element
        for (int i = 0; i < n; i++) {
            res[i] = -1;
            for (int j = i + 1; j < i + n; j++) { // look ahead n elements
                if (list.get(j) > nums[i]) {
                    res[i] = list.get(j);
                    break;
                }
            }
        }

        return res;
    }
}
