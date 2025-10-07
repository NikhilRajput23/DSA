class Solution {
   private int [] orginal;
                private int [] nums;
        private Random rand;

    public Solution(int[] nums) {
     this.orginal=nums.clone();
     this.nums=nums;
     this.rand=new Random();

    }
    
    public int[] reset() {
        return orginal;
        
    }
    
    public int[] shuffle() {
        for(int i=0;i<nums.length;i++){
            int j=rand.nextInt(i+1);
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
            return nums;
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */