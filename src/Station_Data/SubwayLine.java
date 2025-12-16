package Station_Data;

import java.util.LinkedList;

public class SubwayLine {
    LinkedList<Station> line = new LinkedList<>();
    boolean isLoop;
    int id;
    String name;

    public SubwayLine(int id, String name, boolean isLoop){
        this.id = id;
        this.name = name;
        this.isLoop = isLoop;
    }

    public void addStation(Station station){
        line.add(station);
    }
}
