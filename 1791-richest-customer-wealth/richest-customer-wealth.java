class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxNum = 0;
         for(int i=0;i<accounts.length;i++){
              int num = 0;
            for(int j=0;j<accounts[0].length;j++)
            {  
                num += accounts[i][j];
            }
            if(num > maxNum)
            {
                maxNum = num;
            }
         }
         return maxNum ;
    }
}