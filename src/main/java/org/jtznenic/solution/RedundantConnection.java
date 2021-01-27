package org.jtznenic.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> satrtMap = new HashMap<>(edges.length);
        Map<Integer, List<Integer>> endMap = new HashMap<>(edges.length);

        int[] result = null;

        for(int[] tmp : edges) {
            boolean flag = isRing(satrtMap, tmp[0], tmp[1], false);

            if (!flag) {
                flag = isRing(endMap, tmp[0], tmp[1], false);
            }

             if (flag) {
                result = tmp;
                continue;
            }
            List<Integer> values = satrtMap.get(tmp[0]);
            if (values == null) {
                 values = new ArrayList<>();
                 satrtMap.put(tmp[0], values);
            }
            values.add(tmp[1]);

            values = endMap.get(tmp[1]);
            if (values == null) {
                values = new ArrayList<>();
                 endMap.put(tmp[1], values);
            }
            values.add(tmp[0]);
        }

        return result;
    }

    /**
    *
    * 查找线段起点开始查找，看有没有终点是否已经被连接过，如果连结过，则形成环
    * @param map 线段集合
    * @param start 线段终点
    * @param end 线段重点
    * @param isFind 是否找到
    */
    public boolean isRing(Map<Integer, List<Integer>> map, int start, int end, boolean isFind) {
        if (isFind) {
            return true;
        }

        List<Integer> values = map.get(start);

        if (values == null) {
            return false;
        }

        for (Integer value : values) {
            if (value.equals(end)) {
                return true;
            }

            return isRing(map, value, end, false);
        }

        return false;
    }
}
