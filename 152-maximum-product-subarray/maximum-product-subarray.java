class Solution {
    public int maxProduct(int[] nums) {
     int maxprod=nums[0];
     int minprod=nums[0];
     int ans=nums[0];
     for(int i = 1; i < nums.length; i++){
        int curr=nums[i];
        int temp=Math.max(curr,Math.max(maxprod*curr,minprod*curr));
        minprod=Math.min(curr,Math.min(maxprod*curr,minprod*curr));
        maxprod=temp;
        ans=Math.max(maxprod,ans);
     }
     return ans;
    }
}