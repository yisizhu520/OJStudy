package recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * <pre>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 * </pre>
 * // FIXME 1 知道用递归，但是还是找不出递归的细节
 */
public class GenerateParentheses22 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        char[] buff = new char[n * 2];
        generateV2(result, n, n, buff, 0);
        return result;
    }

    private void generate(List<String> result, int leftRemainNum, int rightRemainNum, char[] buff, int buffIndex) {
        if (leftRemainNum == 0) {
            if (rightRemainNum == 0) {
                return;
            }
            for (int i = 0; i < rightRemainNum; i++) {
                buff[buffIndex] = ')';
                buffIndex++;
            }
            result.add(String.valueOf(buff));
            return;
        }
        if (leftRemainNum < rightRemainNum) {
            buff[buffIndex] = '(';
            generate(result, leftRemainNum - 1, rightRemainNum, buff, buffIndex + 1);
            buff[buffIndex] = ')';
            generate(result, leftRemainNum, rightRemainNum - 1, buff, buffIndex + 1);
        } else if (leftRemainNum == rightRemainNum) {
            buff[buffIndex] = '(';
            generate(result, leftRemainNum - 1, rightRemainNum, buff, buffIndex + 1);
        }
    }

    // 优化逻辑，让代码更清晰
    private void generateV2(List<String> result, int leftRemainNum, int rightRemainNum, char[] buff, int buffIndex) {
        if (leftRemainNum == 0 && rightRemainNum == 0) {
            result.add(String.valueOf(buff));
            return;
        }
        if (leftRemainNum > rightRemainNum) {
            return;
        }
        if (leftRemainNum != 0) {
            buff[buffIndex] = '(';
            generate(result, leftRemainNum - 1, rightRemainNum, buff, buffIndex + 1);
        }
        if (leftRemainNum < rightRemainNum) {
            buff[buffIndex] = ')';
            generate(result, leftRemainNum, rightRemainNum - 1, buff, buffIndex + 1);
        }
    }

    // TODO 将递归改成迭代

    @Test
    public void testGenerateParenthesis() {
        List<String> result = generateParenthesis(3);
        assertThat(result, equalTo(Arrays.asList("((()))",
                "(()())",
                "(())()",
                "()(())",
                "()()()")));
    }

}
