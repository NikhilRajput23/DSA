class Solution {
    public int maxIncreasingSubarrays(List<Integer> numsList) {
        int n = numsList.size();
      int ans = 0, pre = 0, cur = 0;
for (int i = 0; i < n; i++) {
      cur++;
  if (i == n - 1 || numsList.get(i) >= numsList.get(i + 1)) {
           ans = Math.max(ans, Math.max(cur / 2, Math.min(pre, cur)));
         pre = cur;
             cur = 0;
            }
        }
 return ans;
    }
}
