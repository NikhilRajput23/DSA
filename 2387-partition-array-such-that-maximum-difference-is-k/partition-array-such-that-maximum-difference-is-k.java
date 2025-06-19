class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int a=1;
        int b=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[b]>k){
                a++;
                b=i;
            }
        }
        return a;
    }
}