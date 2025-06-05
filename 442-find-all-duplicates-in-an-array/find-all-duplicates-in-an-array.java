import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> d = new ArrayList<>();
        int[] count = new int[nums.length + 1];
        
        for (int num : nums) {
            count[num]++;
            if (count[num] == 2) { 
                d.add(num);
            }
        }
        
        return d;
    }
}
