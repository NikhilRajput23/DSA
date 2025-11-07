import java.util.*;

public class Solution {
    public long maxPower(int[] stations, int r, long k) {
        int n = stations.length;
        long[] power = new long[n];
        long[] diff = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            int L = Math.max(0, i - r);
            int R = Math.min(n - 1, i + r);
            diff[L] += stations[i];
            diff[R + 1] -= stations[i];
        }
        long cur = 0, minP = Long.MAX_VALUE, maxP = Long.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            cur += diff[i];
            power[i] = cur;
            minP = Math.min(minP, power[i]);
            maxP = Math.max(maxP, power[i]);
        }
        long lo = minP, hi = maxP + k;
        while (lo < hi) {
            long mid = lo + (hi - lo + 1) / 2;
            if (canMake(power, r, k, mid)) lo = mid;
            else hi = mid - 1;
        }
        return lo;
    }

    private boolean canMake(long[] power, int r, long k, long target) {
        int n = power.length;
        long[] addDiff = new long[n + 1];
        long used = 0, curAdd = 0;
        for (int i = 0; i < n; ++i) {
            curAdd += addDiff[i];
            long total = power[i] + curAdd;
            if (total < target) {
                long need = target - total;
                used += need;
                if (used > k) return false;
                int pos = Math.min(n - 1, i + r);
                int L = Math.max(0, pos - r);
                int R = Math.min(n - 1, pos + r);
                addDiff[L] += need;
                addDiff[R + 1] -= need;
                curAdd += need;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] stations = {1, 2, 4, 5, 0};
        System.out.println(s.maxPower(stations, 1, 2));
    }
}
