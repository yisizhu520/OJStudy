package recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * <pre>
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * <img src="http://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png"/>
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * </pre>
 */
public class LetterCombinationsOfAPhoneNumber17 {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        char[] chars = digits.toCharArray();
        if (digits.length() == 0) {
            return result;
        }
        char[] buff = new char[chars.length];
        generate(result, chars, buff, 0);
        return result;
    }

    // MARK 迭代方法实现
    public List<String> letterCombinationsV2(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        result.add("");
        String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 0; i < digits.length(); ++i) {
            List<String> t = new ArrayList<>();
            String str = dict[digits.charAt(i) - '0'];
            for (int j = 0; j < str.length(); ++j) {
                for (String s : result) t.add(s + str.charAt(j));
            }
            result = t;
        }
        return result;
    }

    private void generate(List<String> result, char[] digits, char[] buff, int index) {
        if (index == digits.length) {
            result.add(String.valueOf(buff));
            return;
        }
        char[] chars = getCharsForNumber(digits[index]);
        for (char c : chars) {
            buff[index] = c;
            generate(result, digits, buff, index + 1);
        }
    }

    // 可以不用char数组，而直接用String[] = {"abc", "def", ...};
    private char[] getCharsForNumber(char number) {
        if (number <= '6') {
            char base = (char) ((number - '2') * 3 + 'a');
            return new char[]{base, (char) (base + 1), (char) (base + 2)};
        }
        if (number == '7') {
            return new char[]{'p', 'q', 'r', 's'};
        }
        if (number == '8') {
            return new char[]{'t', 'u', 'v'};
        }
        if (number == '9') {
            return new char[]{'w', 'x', 'y', 'z'};
        }
        return new char[]{};
    }

    @Test
    public void testGetCharsForNumber() {
        char[] chars = getCharsForNumber('3');
        assertThat(chars, equalTo(new char[]{'d', 'e', 'f'}));
    }

    @Test
    public void testLetterCombinations() {
        List<String> result = letterCombinations("23");
        assertThat(result, equalTo(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")));
    }

    @Test
    public void testLetterCombinationsV2() {
        List<String> result = letterCombinationsV2("23");
        assertThat(new HashSet<>(result), equalTo(new HashSet<>(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"))));
    }


}
