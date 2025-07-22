class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int sum = 0;
         int maxSum = 0;
        boolean[] isFound = new boolean[100_001];

        int p1 = 0;
        int p2 = -1;
        while (++p2 < nums.length) {
            while (isFound[nums[p2]]) {
                sum -= nums[p1];
                isFound[nums[p1++]] = false;
            }
            sum += nums[p2];
            isFound[nums[p2]] = true;
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}