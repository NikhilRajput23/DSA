class Solution {
    public int totalMoney(int n) {
        int t=0;
        int week=1;
        while(n>0){
            int days=Math.min(n,7);
            for(int i=0;i<days;i++){
                t+=week+i;
               }
            week++;
            n-=7;
        }
        return t;
    }
}