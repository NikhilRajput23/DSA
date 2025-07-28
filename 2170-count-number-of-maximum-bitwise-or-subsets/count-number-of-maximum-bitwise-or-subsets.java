class Solution {
    private int maxOr = 0;
    private int count = 0;

    public int countMaxOrSubsets(int[] nums) {
      for (int x : nums) {
    maxOr |= x;
        }
        dfs(nums, 0, 0);
        return count;
    }

    private void dfs(int[] nums, int index, int currOr) {
        if (index == nums.length) {
            if (currOr == maxOr) {
                count++;
            }
            return;
        }
        dfs(nums, index + 1, currOr);
        dfs(nums, index + 1, currOr | nums[index]);
    }
}
