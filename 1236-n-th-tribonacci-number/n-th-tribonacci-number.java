class Solution {
    public int tribonacci(int n) {
        // Base cases defined by the problem
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        // Track the previous three numbers in the sequence
        int t0 = 0;
        int t1 = 1;
        int t2 = 1;
        int current = 0;
        // Calculate from step 3 up to n
        for (int i = 3; i <= n; i++) {
            // The current number is the sum of the previous three
            current = t0 + t1 + t2;
            // Shift our variables forward for the next iteration
            t0 = t1;
            t1 = t2;
            t2 = current;
        }
        return current;
    }
}