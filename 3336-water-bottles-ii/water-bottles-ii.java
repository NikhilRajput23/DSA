class Solution {
    public int maxBottlesDrunk(int numb, int nume) {
        int full=numb;
        int empty=numb;
        while(empty>=nume){
           empty=empty-nume;
           nume++;
           full++;
           empty++;
    
        }
        return full;
        
    }
}