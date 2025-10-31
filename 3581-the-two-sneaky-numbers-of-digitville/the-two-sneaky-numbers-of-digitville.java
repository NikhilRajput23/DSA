class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] count = new int[101];  
        int[] ans = new int[2];
        int j = 0;

        for (int x : nums) {
            count[x]++;
            if (count[x] == 2) { 
                ans[j++] = x;
            }
        }
        return ans;
    }
}
