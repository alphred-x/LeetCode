class Solution {
    public int rob(int[] nums) {
        // These act exactly like your prev2 and prev1 from Climbing Stairs!
        // rob1 tracks the max money if we robbed the house before the previous one (i-2)
        // rob2 tracks the max money if we robbed the previous house (i-1)
        int rob1 = 0; 
        int rob2 = 0; 

        for (int n : nums) {
            // The DP decision: Rob THIS house (n + rob1) OR skip it and keep the previous max (rob2)
            int currentMax = Math.max(n + rob1, rob2);
            
            // Shift our variables forward for the next iteration (just like Climbing Stairs)
            rob1 = rob2;
            rob2 = currentMax;
        }

        return rob2;
    }
}