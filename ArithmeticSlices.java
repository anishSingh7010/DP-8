// TC: O(n)
// SC: O(n)

// Approach: Bottom up dp by starting from the back.
// At any point i, the number of arithmetic slices depend on
// if the next 2 numbers are equidistant from i and if they are
// then i can make all arithmetic slices from i + 1. Hence, 1 + dp[i + 1]

class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length <= 2) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 0;
        dp[nums.length - 2] = 0;

        int res = 0;

        for (int i = nums.length - 3; i >= 0; i--) {
            // atleast 3 numbers with same diff
            if (nums[i + 1] - nums[i] == nums[i + 2] - nums[i + 1]) {
                dp[i] = 1 + dp[i + 1];
                res += dp[i];
            }
        }

        return res;
    }
}