class Solution {
    public int fib(int n) {
        // Handle the base cases directly
        if (n == 0) return 0;
        if (n == 1) return 1;
        
        // Variables to store the two previous Fibonacci numbers
        int a = 0; // F(0)
        int b = 1; // F(1)
        int currentSum = 0;
        
        // Calculate from bottom up to n
        for (int i = 2; i <= n; i++) {
            currentSum = a + b; // F(i) = F(i-1) + F(i-2)
            
            // Shift variables for the next iteration
            a = b;
            b = currentSum;
        }
        
        return currentSum;
    }
}