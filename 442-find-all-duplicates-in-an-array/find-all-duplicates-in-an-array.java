import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> d = new ArrayList<>();
        int[] count = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
            if (count[nums[i]] == 2) {
                d.add(nums[i]);
            }
        }

        return d;
    }
}
