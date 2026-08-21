class Solution {
    public double myPow(double x, int n) {
        // Cast to long to handle the Integer.MIN_VALUE overflow edge case
        long N = n;
        // Handle negative powers by inverting the base and making the power positive
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double result = 1.0;
        double currentProduct = x;
        while (N > 0) {
            // If the current power is odd, multiply the extra 'x' into the result
            if (N % 2 == 1) {
                result *= currentProduct;
            }
            // Square the base
            currentProduct *= currentProduct;
            // Halve the power
            N /= 2;
        }
        return result;
    }
}