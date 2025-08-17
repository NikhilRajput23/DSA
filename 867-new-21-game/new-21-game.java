class Solution {
    public double new21Game(int N, int K, int W) {
        if (K == 0 || N >= K - 1 + W) return 1.0;
        double[] dp = new double[N + 1];
        dp[0] = 1.0;
        double window = 1.0, ans = 0.0;
        for (int i = 1; i <= N; i++) {
            dp[i] = window / W;
            if (i < K) window += dp[i];
            else ans += dp[i];
            if (i - W >= 0) window -= dp[i - W];
        }
        return ans;
    }
}
