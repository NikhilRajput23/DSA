class Solution {
    public int findLucky(int[] arr) {
        int [] a=new int[501];
        for(int i:arr){
            a[i]++;
        }
        for(int i=500;i>0;i--){
            if(i==a[i]){
                  return i;
            }
            
        }
        return -1;
    }
}