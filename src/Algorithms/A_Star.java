package Algorithms;

import Station_Data.*;
import java.util.*;

//A* 算法的核心算式是 f(n) = g(n) + h(n). 其中g为该站点到起点的距离，
//h为该站点到目标站点的预估距离，只可低估不可高估，可直接算直线距离或曼哈顿距离，设为零时就是Dijkstra算法，精度相同但时间复杂度更高。
//f即为判断站点走向的数，站点f值越小，其预测距离终点就越近。将每次处理的f最小的站点排列，就可得出最优顺序。
public class A_Star {

    //启发函数，现在我通过建系，用于计算直线距离作为h。
    private static double heuristic(Station a, Station b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    public static List<Station> aStarSearch(Station start, Station goal) {

        //open：优先队列，其中f(n)最小的站点优先提出进行处理
        PriorityQueue<Node> open = new PriorityQueue<>(Comparator.comparingDouble(n -> n.f));

        //gScore：起点到某节点的当前最短距离,即为g(n)
        Map<Station, Integer> gScore = new HashMap<>();

        //用于路径回溯
        Map<Station, Station> cameFrom = new HashMap<>();

        gScore.put(start, 0);
        open.add(new Node(start, 0, heuristic(start, goal)));

        while (!open.isEmpty()) {

            Node current = open.poll();

            //如果已经到达终点
            if (current.station == goal) {
                return reconstructPath(cameFrom, goal);
            }

            //遍历当前 station 的所有邻居（通过NeighborList获取）
            Neighbor neighborNode = current.station.neighborList.head;
            while (neighborNode != null) {

                Station neighbor = neighborNode.station;
                int tentativeG = gScore.get(current.station) + neighborNode.distance;

                //若首次访问或找到更优路径
                if (!gScore.containsKey(neighbor) || tentativeG < gScore.get(neighbor)) {

                    cameFrom.put(neighbor, current.station);
                    gScore.put(neighbor, tentativeG);
                    double f = tentativeG + heuristic(neighbor, goal);

                    open.add(new Node(neighbor, tentativeG, f));
                }

                neighborNode = neighborNode.next;
            }
        }

        return null; //无路径
    }


    //回溯最终路径
    private static List<Station> reconstructPath(Map<Station, Station> cameFrom, Station current) {
        List<Station> path = new ArrayList<>();
        path.add(current);

        while (cameFrom.containsKey(current)) {
            current = cameFrom.get(current);
            path.add(current);
        }

        Collections.reverse(path);
        return path;
    }
}


