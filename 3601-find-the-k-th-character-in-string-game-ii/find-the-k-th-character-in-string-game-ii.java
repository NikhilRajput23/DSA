class Solution {
    public char kthCharacter(long k, int[] operations) {
        int opCount = (int) Math.ceil(Math.log(k) / Math.log(2));
        int increment = 0;

        for (int i = opCount - 1; i >= 0; i--) {
            long half = 1L << i;
            if (k > half) {
                k -= half;
                if (operations[i] == 1) {
                    increment++;
                }
            }
        }

        return (char) ('a' + (increment % 26));
    }
}
