class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currmax=0;
        int currmin=0;int maxsum=nums[0];
   int  minsum=nums[0];
    int total=0;
    for(int n:nums){
         total+=n;
         currmax=Math.max(n,currmax+n);
         maxsum=Math.max(currmax,maxsum);
         currmin=Math.min(n,currmin+n);
         minsum=Math.min(currmin,minsum);
    }
         if(maxsum<0){
            return maxsum;
         }
                     maxsum=Math.max(maxsum,total-minsum);

         return maxsum;
    }
}