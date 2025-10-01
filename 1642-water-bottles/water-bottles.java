class Solution {
    public int numWaterBottles(int numb, int nume) {
        int fullbottle=numb;
        int empty=numb;
        while(empty>=nume){
            int newbottle = empty/nume;
              fullbottle=fullbottle+newbottle;
              empty=newbottle+(empty%nume);
        }
        return fullbottle;
        
    }
}