/**
 * Created by WangJun on 2016/10/14.
 * <pre>
 *     Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * </pre>
 */
public class ExcelSheetColumnNumber {

    public class Solution {

        public int titleToNumber(String s) {
            int sum = 0;
            int column = 1;
            for (int i = s.length() - 1; i >= 0; i--) {
                sum += (s.charAt(i) - 'A' + 1) * column;
                column = column * 26;
            }
            return sum;
        }

    }

}
