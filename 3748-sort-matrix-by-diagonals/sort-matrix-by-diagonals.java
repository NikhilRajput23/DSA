import java.util.*;

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n][n];

        Map<Integer, List<Integer>> diag = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int key = i - j;
                diag.computeIfAbsent(key, k -> new ArrayList<>()).add(grid[i][j]);
            }
        }

        for (Map.Entry<Integer, List<Integer>> e : diag.entrySet()) {
            List<Integer> v = e.getValue();
            if (e.getKey() < 0) {
                v.sort(Collections.reverseOrder()); 
            } else {
                Collections.sort(v);                
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int key = i - j;
                List<Integer> v = diag.get(key);
                ans[i][j] = v.remove(v.size() - 1);
            }
        }

        return ans;
    }
}
