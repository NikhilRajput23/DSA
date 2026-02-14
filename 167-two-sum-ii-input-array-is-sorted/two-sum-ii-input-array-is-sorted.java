class Solution {
    public int[] twoSum(int[] num, int target) {
        int left=0;
        int right=num.length-1;
   while(left<right){
    int curr=num[left]+num[right];
    if(curr==target){
        return new int[]{left+1,right+1};
    }else if(curr<target){
       left++;
    }else{
        right--;
    }
   }
   return new int[]{-1,-1};
    }
}