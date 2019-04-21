package recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * <pre>
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * // TODO https://www.jianshu.com/p/79b05c2bfdbc
 * </pre>
 */
public class CombinationSum39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> buff = new ArrayList<>();
        Arrays.sort(candidates);
        generate(result, candidates, target, buff);
        return result;
    }

    private void generate(List<List<Integer>> result, int[] candidates, int target, List<Integer> buff) {
        int sum = sum(buff);
        if (sum == target) {
            result.add(new ArrayList<>(buff));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int number : candidates) {
            // MARK 避免重复搜索，我们搜索的时候只搜索当前或之后的数，不搜索之前的元素
            if ((buff.size() == 0 || buff.get(buff.size() - 1) <= number) && sum + number <= target) {
                buff.add(number);
                generate(result, candidates, target, buff);
                buff.remove((Integer) number);
            }
        }

    }

    private int sum(List<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum;
    }

    @Test
    public void testCombinationSum() {
        List<List<Integer>> result = combinationSum(new int[]{2, 3, 5}, 8);
        assertThat(result, equalTo(Arrays.asList(
                Arrays.asList(2, 2, 2, 2),
                Arrays.asList(2, 3, 3),
                Arrays.asList(3, 5))));
    }


}
