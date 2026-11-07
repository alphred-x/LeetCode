import java.util.List;
import java.util.ArrayList;

class Solution {
    static final String[] KEYS = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        char digitChar = digits.charAt(index);
        String letters = KEYS[digitChar - '0'];
        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));                    // 1. Choose
            backtrack(digits, index + 1, current, result);         // 2. Explore deeper
            current.deleteCharAt(current.length() - 1);           // 3. Un-choose (Backtrack)
        }
    }
}