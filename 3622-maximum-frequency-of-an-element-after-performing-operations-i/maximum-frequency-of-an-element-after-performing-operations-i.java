import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int first(int[] a, int t) {
        int l = 0, r = a.length - 1;
        int m, idx = a.length;
        while (l <= r) {
            m = (l + r) / 2;
            if (a[m] < t) {
                l = m + 1;
            } else {
                idx = Math.min(m, idx);
                r = m - 1;
            }
        }
        return idx;
    }

    public int last(int[] a, int t) {
        int l = 0, r = a.length - 1;
        int m, idx = a.length;
        while (l <= r) {
            m = (l + r) / 2;
            if (a[m] > t) {
                r = m - 1;
            } else {
                idx = m;
                l = m + 1;
            }
        }
        return idx;
    }

    public int maxFrequency(int[] nums, int k, int numOperations) {
        int max = 0;
        Map<Integer, Integer> m1 = new HashMap<>();
        Map<Integer, Integer> m2 = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            m1.put(nums[i], m1.getOrDefault(nums[i], 0) + 1);
            m2.putIfAbsent(nums[i], i);
        }
        var keys = m1.keySet();
        int cnt, f, l;
        for (var key : keys) {
            cnt = m1.get(key);
            f = first(nums, key - k);
            l = last(nums, key + k);
            if (f != nums.length && l != nums.length) {
                cnt += Math.min(l - f - cnt + 1, numOperations);
                max = Math.max(max, cnt);
            }
            l = last(nums, key + k + k);
            if (l != nums.length) {

                max = Math.max(max, Math.min(l - m2.get(key) + 1, numOperations));
            }
        }
        return max;
    }
}