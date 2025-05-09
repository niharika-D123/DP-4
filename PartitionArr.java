// Time Complexity : O(k*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];

        for (int i = 1; i < n; i++) {
            int maxInCurrPartition = arr[i];

            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                maxInCurrPartition = Math.max(maxInCurrPartition, arr[i - j + 1]);

                int currResult = maxInCurrPartition * j;
                if (i - j >= 0) {
                    currResult += dp[i - j];
                }

                dp[i] = Math.max(dp[i], currResult);
            }
        }

        return dp[n - 1];
    }
}

