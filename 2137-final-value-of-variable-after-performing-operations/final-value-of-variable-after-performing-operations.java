class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int X=0;//start with X=0;
        for(String po:operations){
         if(po.contains("+")){
            X++;
         }else{
            X--;
         }
        }
        return X ;
        
    }
}