package stack;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import java.util.Stack;

/**
 * <pre>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * </pre>
 */
public class ValidParentheses20 {

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if(isLeft(c)) {
                stack.push(c);
            } else if(isRight(c)) {
                if(stack.isEmpty() || !isMatch(stack.pop(), c)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean isLeft(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    private boolean isRight(char c) {
        return c == ')' || c == '}' || c == ']';
    }

    private boolean isMatch(char a, char b) {
        return (a == '(' && b == ')') ||
                (a == '{' && b == '}') ||
                (a == '[' && b == ']');
    }

    @Test
    public void testIsValid() {
        assertThat(isValid("[{"), equalTo(false));
    }


}
