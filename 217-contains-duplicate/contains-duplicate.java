class Solution {
    public boolean containsDuplicate(int[] n) {
        Arrays.sort(n);
        for(int i=1;i<n.length;i++){
                     if(n[i]==n[i-1]){
                        return true;
                     }
            
        }
        return false;
    }
}