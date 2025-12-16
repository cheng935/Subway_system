package Station_Data;

import java.util.ArrayList;
import java.util.List;


//站点本身类
public class Station {
    public int id;
    public String name;

    //为建系做准备
    public double x;
    public double y;

    public NeighborList neighborList = new NeighborList();

    public Station(int id, String name, double x, double y){
        this.id = id;
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public void addNeighbor(Station station, double distance){
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

