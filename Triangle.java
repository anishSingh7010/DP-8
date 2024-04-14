// TC: O(n^2)
// SC: O(n^2)

// Approach: Bottom up dp by starting from the bottom row.
// Keep track of the minimum path you can take at each row at each
// point. As it will converge to a single element at 0 index. Return it

import java.util.List;

class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] dp = new int[size][size];

        // bottom up dp; copy the last row
        for (int i = 0; i < dp[0].length; i++) {
            dp[dp.length - 1][i] = triangle.get(size - 1).get(i);
        }

        for (int i = size - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }

        return dp[0][0];
    }
}