package station_database;

import java.util.ArrayList;
import java.util.List;


//站点本身类
public class Station {
    public int id;
    public String name;

    public NeighborList neighborList = new NeighborList();

    public Station(int id, String name){
        this.id = id;
        this.name = name;
    }

    public void addNeighbor(Station station, int distance){
        neighborList.addNeighbor(station, distance);
    }

    public Iterable<Neighbor> getNeighbors() {
        List<Neighbor> list = new ArrayList<>();
        Neighbor curr = neighborList.head;
        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }
        return list;
    }
}

