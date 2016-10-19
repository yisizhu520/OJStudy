import java.util.ArrayList;
import java.util.List;

/**
 * Created by WangJun on 2016/10/19.
 * <pre>
 *     Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * For example,
 * If n = 4 and k = 2, a solution is:
 *
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * </pre>
 */
public class Combinations {

    public static void main(String[] args) {
        new Solution().combine(4,2);
    }

    public static class Solution {

        /**
         * http://blog.csdn.net/ljiabin/article/details/41787957
         * FIXME 这种递归还是无法理解
         * @param n
         * @param k
         * @return
         */
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            combine(result,list,k,1,n);
            return result;
        }



        /**
         * 错的。。。这个list我不知该如何处理
         * @param result
         * @param list
         * @param k
         * @param index
         * @param n
         * @param choose
         */
        public void combine(List<List<Integer>> result, List<Integer> list,int k,int index,int n,boolean choose){

            if(list.size() == k) {
                List<Integer> newList = new ArrayList<>(list);
                result.add(newList);
                return;
            }
            if(index == n) return;

            if(choose){
                list.add(index+1);
                combine(result,list,k,index+1,n,true);
                combine(result,list,k,index+1,n,false);
            }else{
                combine(result,list,k,index+1,n,true);
                combine(result,list,k,index+1,n,false);
            }

        }

        /**
         * MARK 正确的递归解法，有点像8皇后
         * @param result
         * @param list
         * @param k
         * @param index
         * @param n
         */
        public void combine(List<List<Integer>> result, List<Integer> list,int k,int index,int n){
            if(list.size() == k) {
                List<Integer> newList = new ArrayList<>(list);
                result.add(newList);
                return;
            }

            for (int i = index; i <= n; i++) {
                list.add(i);//选中它的情况
                combine(result,list,k,i+1,n);
                list.remove((Integer)i);//不选它的情况
            }

        }

    }

}
