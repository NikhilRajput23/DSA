class Solution {
    public int candy(int[] ratings) {
         int n = ratings.length;
        int[] Left = new int[n];
        int[] Right = new int[n];

        for (int i = 0; i < n - 1; i++) {
            if (ratings[i] < ratings[i + 1]) {
                Right[i + 1] = Right[i] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
            Left[i] = Left[i + 1] + 1;
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            count += 1 + Math.max(Left[i], Right[i]);
        }

        return count;
    }
}