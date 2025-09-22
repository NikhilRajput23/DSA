class Solution {
    public int maxFrequencyElements(int[] nums) {
        int [] freq=new int[101];
        for(int num:nums){
            freq[num]++;
        }
        
        int max=0;int result=0;
        for(int i=0;i<=100;i++){
            if(freq[i]>max){
                max=freq[i];
            }
        }
  for(int i=0;i<=100;i++){
    if(freq[i]==max){
    result+=max;

    }
  }
  return result;

}
}