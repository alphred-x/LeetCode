class Solution {
    public int removeElement(int[] nums, int val) {
        // k will act as our "writer" pointer
        int k = 0;
        // i is our "reader" pointer checking every element
        for (int i = 0; i < nums.length; i++) {
            // If the current element is not the value we want to remove
            if (nums[i] != val) {
                // Place it at the 'k' index and move 'k' forward
                nums[k] = nums[i];
                k++;
            }
        }
        // k now represents the length of the array without the removed elements
        return k;
    }
}