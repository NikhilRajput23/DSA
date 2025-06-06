import java.util.*;

public class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> a= new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int count = a.getOrDefault(nums[i], 0) + 1;
            a.put(nums[i], count);
            if (count > n / 2) 
            return nums[i];
        }
        return 1;
    }
}
