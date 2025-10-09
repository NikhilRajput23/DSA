class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        long finishTime[] = new long [n];
        for(int j=0;j<m;j++){
            finishTime[0]+=mana[j]*skill[0];

            for(int i=1;i<n;i++){
                finishTime[i]=(long)mana[j]*skill[i] + Math.max(finishTime[i-1],finishTime[i]);
            }


            for(int i=n-2;i>=0;i--){
                finishTime[i]=finishTime[i+1]- (long)mana[j]*skill[i+1];
            }
        }

        return finishTime[n-1];
    }
}