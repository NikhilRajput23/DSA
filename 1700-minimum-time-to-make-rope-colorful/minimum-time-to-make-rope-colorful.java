class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int result = 0;

        int i = 0;
        while (i < n) {
            char c = colors.charAt(i);
            int sum = 0;
            int maxTime = 0;

            while (i < n && colors.charAt(i) == c) {
                int t = neededTime[i];
                sum += t;
                if (t > maxTime) maxTime = t;
                i++;
            }

            result += (sum - maxTime);
        }

        return result;
    }
}
