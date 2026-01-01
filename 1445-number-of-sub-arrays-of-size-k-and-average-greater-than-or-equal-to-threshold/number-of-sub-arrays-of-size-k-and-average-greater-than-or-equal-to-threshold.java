class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n=arr.length;
        int target=threshold*k;
      int sum=0;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        int count=0;
        if(sum>=target){
            count++;
        }
        for(int i=1;i<=n-k;i++){
            sum=sum-arr[i-1]+arr[i+k-1];
    if(sum>=target){
        count++;
    }
        }
        return count;
    }
}