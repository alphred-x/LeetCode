import java.util.Arrays;
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        // A permutation cannot be longer than the string it's supposedly inside
        if (len1 > len2) {
            return false;
        }
        int[] s1Count = new int[26];
        int[] windowCount = new int[26];
        // Step 1: Initialize the frequency arrays for the first window
        for (int i = 0; i < len1; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            windowCount[s2.charAt(i) - 'a']++;
        }
        // Step 2: Check if the very first window is a match
        if (Arrays.equals(s1Count, windowCount)) {
            return true;
        }
        // Step 3: Slide the window across the rest of s2
        for (int i = len1; i < len2; i++) {
            // Add the new character entering the window
            windowCount[s2.charAt(i) - 'a']++;
            // Remove the old character exiting the window
            windowCount[s2.charAt(i - len1) - 'a']--;
            // Check if the updated window matches s1's frequencies
            if (Arrays.equals(s1Count, windowCount)) {
                return true;
            }
        }
        return false;
    }
}