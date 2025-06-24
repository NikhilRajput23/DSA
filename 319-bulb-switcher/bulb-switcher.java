class Solution {
    public int bulbSwitch(int n) {
        for(int i=0;i*i<=n;i++){
           System.out.println(i);
        }
        return (int)Math.sqrt(n);
    }
}