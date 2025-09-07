import java.util.Scanner;

class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int index = 0;
        for (int i = 1; i <= n / 2; i++) {
            ans[index++] = i;
            ans[index++] = -i;
        }
        if (n % 2 == 1) {
            ans[index] = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Solution obj = new Solution();
        int[] result = obj.sumZero(n);
        System.out.print("[ ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.print("]");
    }
}
