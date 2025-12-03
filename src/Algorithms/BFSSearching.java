package Algorithms;

import Station_Data.Neighbor;
import Station_Data.Station;

import java.util.*;

//可选，汇报时可以把这个和A*算法对比，应该算加分项。
//BFS不仅没有A*效率高，而且只能处理站点间距离相等的情况，也可以说BFS找的是起点到终点经过站点最少的路，而不是路程最近的。可以满足特殊需求（想经过最少站点）
public class BFSSearching {

    public static List<Station> BFSSearchPath(Station start, Station goal){
        //待处理队列
        Queue<Station> open = new LinkedList<>();

        //处理过的队列
        Set<Station> closed = new HashSet<>();

        //记录路径便于回溯
        Map<Station, Station> cameFrom = new HashMap<>();

        open.add(start);
        closed.add(start);

        //循环遍历待处理的站点
        while(!open.isEmpty()){
            Station current = open.poll();

            if (current == goal){
                return reconstructPath(cameFrom, goal);
            }
            Neighbor p = current.neighborList.head;
            while (p != null) {
                Station neighbor = p.station;

                if (!closed.contains(neighbor)) {
                    closed.add(neighbor);
                    cameFrom.put(neighbor, current);
                    open.add(neighbor);
                }
                p = p.next;
            }
        }
        return null;
    }

    private static List<Station> reconstructPath(Map<Station, Station> cameFrom, Station goal){
        List<Station> path = new ArrayList<>();
        Station current = goal;

        while (current != null) {
            path.add(current);
            current = cameFrom.get(current);
        }

        Collections.reverse(path);
        return path;
    }
}
