class Solution {
    public boolean isPalindrome(int x) {
      if(x<0){
        return false;

      }
      int n=x;
      int b=0;
      while(n>0){
        int d=n%10;
        b=b*10+d;
        n=n/10;

      }
      if(b==x){
        return true;

      }
      return false;
    }
}