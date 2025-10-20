class Solution {
    public int finalValueAfterOperations(String[] op) {
        int x=0;
        for(String po:op){
         if("X++".equals(po)||"++X".equals(po)){
            x++;
         }else{
            x--;
         }
        }
        return x;
        
    }
}