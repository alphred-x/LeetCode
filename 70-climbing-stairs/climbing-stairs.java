class Solution {
    public int climbStairs(int n) {
        // Base cases: 1 way to reach step 1, 2 ways to reach step 2
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        // Track the previous two steps
        int prev2 = 1; // Ways to reach (n-2)
        int prev1 = 2; // Ways to reach (n-1)
        int currentWays = 0;
        // Calculate from step 3 up to n
        for (int i = 3; i <= n; i++) {
            // The ways to reach the current step is the sum of the previous two
            currentWays = prev1 + prev2;
            
            // Shift our variables forward for the next iteration
            prev2 = prev1;
            prev1 = currentWays;
        }
        
        return currentWays;
    }
}