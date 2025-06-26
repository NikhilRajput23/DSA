class Solution{
    public int  reverse(int x){
        long r=0;
        while(x!=0){
            int d=x%10;
            r=r*10+d;
            x=x/10;

        }
        if(r<Integer.MIN_VALUE || r>Integer.MAX_VALUE){
            return 0;

        }
    else{
        return (int) r;
    }
    }
}