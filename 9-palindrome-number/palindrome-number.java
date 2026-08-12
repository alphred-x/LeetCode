class Solution {
    public boolean isPalindrome(int x) {
        //Rule out negative numbers and numbers ending in 0 (except 0 itself)
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        
        int revertedNumber = 0;
        
        //Revert the second half of the number
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        
        //Check for equality
        // (x == revertedNumber) handles even digit lengths
        // (x == revertedNumber / 10) handles odd digit lengths
        return x == revertedNumber || x == revertedNumber / 10;
    }
}