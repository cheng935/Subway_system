package Station_Data;

import java.util.List;

//使用SubwayLine将站点构建成线路后，再调用此类补充线路中各站点的相邻关系和距离
//如何构建关系：调用了Station类中的addNeighbor函数，记录站点的邻居站点和距离（16 17行）。
public class GraphBuilder {
    public static void build(SubwayLine line) {
        List<Station> list = line.line;

        for (int i = 0; i < list.size() - 1; i++) {
            connect(list.get(i), list.get(i + 1));
        }

        //如果地铁线路是环形，则首尾相连
        if (line.isLoop && list.size() > 1) {
            connect(list.get(0), list.get(list.size() - 1));
        }
    }

    private static void connect(Station s1, Station s2){
        double distance = Math.sqrt(Math.pow(s1.x - s2.x, 2) + Math.pow(s1.y - s2.y, 2));
        s1.addNeighbor(s2, distance);
        s2.addNeighbor(s1, distance);
    }
}
