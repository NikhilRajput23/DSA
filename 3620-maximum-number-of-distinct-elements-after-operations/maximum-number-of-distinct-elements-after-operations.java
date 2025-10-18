class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        int ans = 0;
        long occupied = Long.MIN_VALUE;  
        Arrays.sort(nums);
        for (int num : nums) {
            if (occupied < (long)num + k) {
                long start = (long)num - k;
                occupied = Math.max(occupied + 1, start);
                ans++;
            }
        }
        return ans;
    }
}
