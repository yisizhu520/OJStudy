import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 公交换乘算法
 * <pre>
 *     有1到n一共n个公交站点，k条公交线路，小明要从站点1到站点n，求最少换乘次数。
 * <pre/>
 */
public class BusTransfer {

    public static void main(String[] args) {
        int n = 6;
        int k = 4;
        int[][] routes = new int[][]{
                {1, 2, 3},
                {2, 4, 5},
                {1, 3, 5},
                {4, 5, 6},
                {3, 6, 2}
        };
        List<Route> routesList = new ArrayList<>();
        routesList.add(new Route(1, 2, 3));
        routesList.add(new Route(2, 4, 5));
        routesList.add(new Route(1, 3, 5));
        routesList.add(new Route(4, 5, 6));
        routesList.add(new Route(3, 6, 2));

    }

    private static class Route {
        List<Integer> stations = new ArrayList<>();

        Route(List<Integer> stationList) {
            stations = stationList;
        }

        Route(Integer... stationList) {
            stations.addAll(Arrays.asList(stationList));
        }

        boolean contains(Integer station) {
            return stations.contains(station);
        }

    }

    private static int getMinTransferCount(int start, int end, List<Route> routesList) {
        // 1. 分别找出经过出发站点和到达站点的线路集合lstart = {r1,r3},lend = {r4,r5}
        // 2. 如果两个集合有交集，则最小换乘次数min为1
        // 3. 如果没有交集，则遍历lstart的每条线路，找出每条线路出发站点1之后的所有站点，去重加入集合lnext = {2,3,5}
        //    找出lnext里所有站点经过的路线，加入lstart
        //    遍历lend找出每条线路到达站点6之前的所有站点lpre = {3,4,5},找到lpre里所有站点经过的路线
        // 4. 如果两者有交集，则最小换乘次数min为2
        // 5. 如果没有，则重复第1步
        Set<Route> startSet = new HashSet<>();
        Set<Route> endSet = new HashSet<>();
        int startStation = start;
        int endStation = end;
        for (Route route : routesList) {
            if (route.contains(startStation)) {
                startSet.add(route);
            }
            if (route.contains(endStation)) {
                endSet.add(route);
            }
        }
        if (intersect(startSet, endSet)){

        }
        return -1;
    }

//    private static boolean intersect(Set<Integer> a, Set<Integer> b) {
//        for (Integer i : a) {
//            if (b.contains(i)) {
//                return true;
//            }
//        }
//        return false;
//    }

    private static boolean intersect(Set<Route> a, Set<Route> b) {
        for (Route i : a) {
            if (b.contains(i)) {
                return true;
            }
        }
        return false;
    }

}
