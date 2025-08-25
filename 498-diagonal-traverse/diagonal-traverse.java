import java.util.*;

public class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) return new int[0];

        int m = mat.length;        
        int n = mat[0].length;     
        int[] result = new int[m * n];

        int row = 0, col = 0;     
        int dir = 1;               

        for (int i = 0; i < m * n; i++) {
            result[i] = mat[row][col];  

          
            if (dir == 1) {
                if (col == n - 1) {   
                    row++;
                    dir = -1;        
                } else if (row == 0) { 
                    col++;
                    dir = -1;
                } else {
                    row--; col++;
                }
            } 
            else {
                if (row == m - 1) {   
                    col++;
                    dir = 1;         
                } else if (col == 0) {
                    row++;
                    dir = 1;
                } else {
                    row++; col--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] mat = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[] ans = sol.findDiagonalOrder(mat);
        System.out.println(Arrays.toString(ans)); 
    }
}
