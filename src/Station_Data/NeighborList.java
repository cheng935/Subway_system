package Station_Data;

//当前站点的相邻站点集
public class NeighborList{
    public Neighbor head = null;
    public Neighbor tail = null;

    //将新的相邻站点添加到相邻站点集
    public void addNeighbor(Station station, double distance){
        Neighbor newNeighbor = new Neighbor(station, distance);

        if (head == null){
            head = tail = newNeighbor;
        } else {
            tail.next = newNeighbor;
            newNeighbor.prev = tail;
            tail = newNeighbor;
        }
    }
}
