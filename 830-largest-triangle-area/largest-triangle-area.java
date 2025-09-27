class Solution {
    public double largestTriangleArea(int[][] points) {
        double ans = 0;        
        int n = points.length; 

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    ans = Math.max(ans, area(points[i], points[j], points[k]));
                }
            }
        }
        return ans; 
    }

    private double area(int[] a, int[] b, int[] c) {
        return Math.abs(
            a[0] * (b[1] - c[1]) +
            b[0] * (c[1] - a[1]) +
            c[0] * (a[1] - b[1])
        ) / 2.0;
    }
}
