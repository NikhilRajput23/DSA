class Solution {
    public int finalValueAfterOperations(String[] op) {
        int X=0;
        for(String po:op){
         if(po.contains("+")){
            X++;
         }else{
            X--;
         }
        }
        return X;
        
    }
}