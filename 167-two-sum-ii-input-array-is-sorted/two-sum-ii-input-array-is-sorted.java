import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] num, int target) {
         
      ArrayList<Integer> arr=new ArrayList<>();
      int[]res=new int[2];
     int right=num.length-1;
      int left=0;
      while(left<right){
        int sum=num[left]+num[right];
        if(sum==target){
            arr.add(left+1);
            arr.add(right+1);
            res[0]=arr.get(0);
            res[1]=arr.get(1);
            return res;
        }else if(sum<target){
            left++;
        }else{
            right--;
        }
      }
      return res;
    }
}
