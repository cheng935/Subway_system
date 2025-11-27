package Station_Data;

import java.util.List;

public class GraphBuilder {
    public static void build(SubwayLine line) {
        List<Station> list = line.line;

        for (int i = 0; i < list.size() - 1; i++) {
            Station s1 = list.get(i);
            Station s2 = list.get(i + 1);

            s1.addNeighbor(s2, 1);
            s2.addNeighbor(s1, 1);
        }
    }
}
