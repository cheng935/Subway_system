package Station_Data;

import java.util.List;

//使用SubwayLine将站点构建成线路后，再调用此类补充线路中各站点的相邻关系和距离
//如何构建关系：调用了Station类中的addNeighbor函数，记录站点的邻居站点和距离（16 17行）。
public class GraphBuilder {
    public static void build(SubwayLine line) {
        List<Station> list = line.line;

        for (int i = 0; i < list.size() - 1; i++) {
            Station s1 = list.get(i);
            Station s2 = list.get(i + 1);
            double distance = Math.sqrt(Math.pow(s1.x - s2.x, 2) + Math.pow(s1.y - s2.y, 2));

            s1.addNeighbor(s2, distance);
            s2.addNeighbor(s1, distance);
        }
    }
}
