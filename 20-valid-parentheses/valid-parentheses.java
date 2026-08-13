import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

// Iterate through each character in the string
        for (char c : s.toCharArray()) {
// If it's an open bracket, push the expected closing bracket
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } 

// If it's a closing bracket, check for a match
            else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

// If the stack is empty, all brackets were matched correctly
        return stack.isEmpty();
    }
}