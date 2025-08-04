import java.util.*;

public class Solution {
    public int totalFruit(int[] fruits) {
        int maxLen = 0;
        int start = 0;
        Map<Integer, Integer> basket = new HashMap<>();

        for (int end = 0; end < fruits.length; end++) {
            int fruit = fruits[end];
            basket.put(fruit, basket.getOrDefault(fruit, 0) + 1);

            while (basket.size() > 2) {
                int startFruit = fruits[start];
                basket.put(startFruit, basket.get(startFruit) - 1);
                if (basket.get(startFruit) == 0) {
                    basket.remove(startFruit);
                }
                start++;
            }

            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
