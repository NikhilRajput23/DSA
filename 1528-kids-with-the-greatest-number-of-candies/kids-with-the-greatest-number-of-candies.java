class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max=candies[0];
        for(int i=1;i<candies.length;i++){
            if(candies[i]>max){
                max=candies[i];
            }
        }
        List<Boolean>li=new ArrayList<>();
         for(int i=0;i<candies.length;i++){
            if(candies[i]+extraCandies>=max){
                li.add(true);
            }else{
                li.add(false);
            }
         }
  return li;
    }
}