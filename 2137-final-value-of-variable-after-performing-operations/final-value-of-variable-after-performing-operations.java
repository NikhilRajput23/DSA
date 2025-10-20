class Solution {
    public int finalValueAfterOperations(String[] op) {
        int x=0;
        for(String po:op){
         if(po.contains("+")){
            x++;
         }else{
            x--;
         }
        }
        return x;
        
    }
}