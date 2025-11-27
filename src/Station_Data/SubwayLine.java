package Station_Data;

import java.util.LinkedList;

public class SubwayLine {
    LinkedList<Station> line = new LinkedList<>();
    int id;
    String name;

    public SubwayLine(int id, String name){
        this.id = id;
        this.name = name;
    }

    public void addStation(Station station){
        line.add(station);
    }
}
