class Solution {
  public int[] maxSubsequence(int[] nums, int k) {
    int[] ans = new int[k];
    int[] arr = nums.clone();
    Arrays.sort(arr);
    int threshold = arr[arr.length - k];
    long larger = Arrays.stream(nums).filter(num -> num > threshold).count();
    int equal = k - (int) larger;

    int idx = 0;
    for (int num : nums) {
      if (num > threshold || (num == threshold && equal-- > 0))
        ans[idx++] = num;
    }
    return ans;
  }
}
