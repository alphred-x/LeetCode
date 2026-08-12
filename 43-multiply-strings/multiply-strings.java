class Solution {
    public String multiply(String num1, String num2) {
        // Base case: if either number is zero, the result is zero
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        
        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[m + n];
        
        // Iterate from right to left for both numbers
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // Convert characters to integer values and multiply
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                
                // Indices in the pos array where this multiplication contributes
                int p1 = i + j;
                int p2 = i + j + 1;
                
                // Add the multiplication result to the existing value at p2
                int sum = mul + pos[p2];
                
                // Update the carry at p1 and the single digit at p2
                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }
        
        // Build the final string, skipping leading zeros
        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }
        
        return sb.toString();
    }
}