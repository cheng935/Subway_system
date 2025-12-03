package Station_Data;

//相邻站点类
public class Neighbor{
    public Station station;
    public double distance;

    public Neighbor prev, next;

    public Neighbor(Station station, double distance){
        this.station = station;
        this.distance = distance;
    }
}
