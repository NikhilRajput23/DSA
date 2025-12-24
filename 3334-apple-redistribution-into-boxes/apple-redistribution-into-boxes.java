import java.util.*;
class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int applet=0;
        for(int a:apple){
            applet+=a;
        }
        Arrays.sort(capacity);
        int total=0;
    for(int i=capacity.length-1;i>=0;i--){
        applet-=capacity[i];
        total++;
if(applet<=0){
return total;
}
    }
return total;
    }
}