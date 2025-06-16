class Solution {
    public int maximumDifference(int[] nums) {
        int n=nums.length;
      int a=-1;
      int p=nums[0] ;
       for(int i=0; i<n;i++){
        if(nums[i]>p){
            a=Math.max(a,nums[i]-p);
        }else{
            p=nums[i];
        }
       }
       return a;
    }
}