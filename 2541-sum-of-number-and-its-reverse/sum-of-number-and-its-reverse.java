class Solution {
    public boolean sumOfNumberAndReverse(int num) {
    for(int i=0;i<=num;i++){
    if(i+reverse(i)==num){
        return true;
    }
    }
    return false;
    }
    private int reverse (int n){
        int d=0;
        while(n>0){
            d=d*10+n%10;
            n=n/10;
        }
        return d;
    }
}