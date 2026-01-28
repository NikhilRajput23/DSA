class Solution {
    public int mostWordsFound(String[] sentences) {
        int max=0;
        for(String word:sentences){
            max=Math.max(max,word.split(" ").length);
        }
        return max;
    }
}