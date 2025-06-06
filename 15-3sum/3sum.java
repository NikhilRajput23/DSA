import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            HashMap<Integer, Integer> a= new HashMap<>();

            for (int j = i + 1; j < nums.length; j++) {
                int complement = target - nums[j];

if (a.containsKey(complement)) {
         int n = nums[i];
          int m = nums[j]; 
          int k = complement;
     int[] t = new int[]{n, m, k};
     Arrays.sort(t); 

      result.add(Arrays.asList(t[0], t[1], t[2]));
                }

               a.put(nums[j], j);
            }
        }

        return new ArrayList<>(result);
    }
}
