class Solution {
    public int minimumBeautifulSubstrings(String s) {
        int result = solve(s, 0);
        return result >= 1000 ? -1 : result;
    }
    int solve(String s, int index) {
        if (index == s.length()) {
            return 0;
        }
        if (s.charAt(index) == '0') {
            return 1000; 
        }
        int minSubstrings = 1000;
        int currentDecimalValue = 0;
        for (int i = index; i < s.length(); i++) {
            currentDecimalValue = (currentDecimalValue * 2) + (s.charAt(i) - '0');
            if (isPowerOfFive(currentDecimalValue)) {
                int cutsForRestOfString = 1 + solve(s, i + 1);
                minSubstrings = Math.min(minSubstrings, cutsForRestOfString);
            }
        }

        return minSubstrings;
    }
    boolean isPowerOfFive(int n) {
        if (n <= 0) return false;
        while (n % 5 == 0) {
            n /= 5;
        }
        return n == 1;
    }
}