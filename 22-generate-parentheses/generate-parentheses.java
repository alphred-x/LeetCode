import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> s = new ArrayList<>();
        backtrack(s, "", 0, 0, n);
        return s;
    }
    void backtrack(List<String> s, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            s.add(cur);
            return;
        }
        if (open < max) {
            backtrack(s, cur + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(s, cur + ")", open, close + 1, max);
        }
    }   
}