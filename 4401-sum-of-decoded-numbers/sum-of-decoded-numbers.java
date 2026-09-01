class Solution {
    // FIXED: Changed the parameter from int[] to long[] 
    public int sumDecoded(long[] nums) {
        long MOD = 1_000_000_007;
        long totalSum = 0;
        // FIXED: Updated the loop variable to match the long[] array
        for (long num : nums) {
            // Extract the width (last digit). Since it's 0-9, casting to int is safe.
            int width = (int) (num % 10);
            // The remaining digits (d) must also be stored as a long
            long d = num / 10;
            // Convert to string to easily split based on the width
            String s = String.valueOf(d);
            // Parse x (first 'width' digits) and y (remaining digits)
            long x = Long.parseLong(s.substring(0, width));
            long y = Long.parseLong(s.substring(width));
            // Calculate x^y % (10^9 + 7) using modular exponentiation
            long decodedValue = power(x, y, MOD);
            // Add to the total sum and apply modulo
            totalSum = (totalSum + decodedValue) % MOD;
        }
        return (int) totalSum;
    }
    // Fast modular exponentiation to calculate (base^exp) % mod
    private long power(long base, long exp, long mod) {
        long res = 1;
        base = base % mod; 
        while (exp > 0) {
            // If exp is odd, multiply the base with the result
            if (exp % 2 == 1) {
                res = (res * base) % mod;
            }
            // Square the base and halve the exponent
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }
}