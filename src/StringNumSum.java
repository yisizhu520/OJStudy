import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public interface StringNumSum {

    public static void main(String[] args) {
        Executors.newFixedThreadPool(3);
        LinkedList ll = new LinkedList();
        String input = "9fil3dj11P0jAsf11";
        int n = input.length();
        //使用一个map来存储对应的数字和出现的次数
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        String old = null;
        for (int i = 0; i < n; i++) {
            char ch = input.charAt(i);
            if ('0' <= ch && ch <= '9') {
                if (old == null) {
                    old = "" + ch;
                } else {
                    old = old + ch;
                }
            } else {
                if (old != null) {
                    Integer key = Integer.parseInt(old);
                    Integer value = map.get(key);
                    map.put(key, value == null ? 1 : value + 1);
                    old = null;
                }
            }
        }
        if (old != null) {
            Integer key = Integer.parseInt(old);
            Integer value = map.get(key);
            map.put(key, value == null ? 1 : value + 1);
            old = null;
        }
        //遍历map来获取最大值
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        int maxValue = 0;
        int maxKey = 0;
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            int value = entry.getValue();
            int key = entry.getKey();
            if (value > maxValue) {
                maxValue = value;
                maxKey = key;
            }
        }
        System.out.print(maxValue * maxKey);
    }


}
