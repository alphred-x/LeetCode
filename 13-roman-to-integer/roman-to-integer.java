class Solution {
    public int romanToInt(String s) {
        int total = 0;
        int prevValue = 0;
        
        // Traverse the string from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue;
            
            // Fast lookup for Roman numeral values
            switch (s.charAt(i)) {
                case 'I': currentValue = 1; break;
                case 'V': currentValue = 5; break;
                case 'X': currentValue = 10; break;
                case 'L': currentValue = 50; break;
                case 'C': currentValue = 100; break;
                case 'D': currentValue = 500; break;
                case 'M': currentValue = 1000; break;
                default: currentValue = 0;
            }
            
            // If the current value is less than the previous, subtract it
            if (currentValue < prevValue) {
                total -= currentValue;
            } else {
                // Otherwise, add it
                total += currentValue;
            }
            
            // Update prevValue for the next iteration
            prevValue = currentValue;
        }
        
        return total;
    }
}