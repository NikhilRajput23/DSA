class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long low = -10_000_000_000L;
        long high = 10_000_000_000L;

        while (low < high) {
            long mid = low + (high - low) / 2;
      if (countPairs(nums1, nums2, mid) < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private long countPairs(int[] nums1, int[] nums2, long target) {
long count = 0;
        for (int a : nums1) {
            if (a > 0) {
                count += countLessThanOrEqual(a, nums2, target);
      } else if (a < 0) {
              count += countGreaterThanOrEqual(a, nums2, target);
         } else {
                if (target >= 0) {
         count += nums2.length; 
                }
            }
        }
        return count;
    }
    private int countLessThanOrEqual(int a, int[] nums, long target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if ((long) a * nums[mid] <= target) {
       left = mid + 1;
   } else {
                right = mid;
            }
        }
        return left;
    }

    private int countGreaterThanOrEqual(int a, int[] nums, long target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if ((long) a * nums[mid] <= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums.length - left;
    }
}
