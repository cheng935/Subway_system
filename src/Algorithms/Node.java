package Algorithms;

import station_database.Station;

public class Node {
    public Station station;
    public int g;  // 起点到当前点的代价
    public int f;  // f = g + h

    public Node(Station station, int g, int f) {
        this.station = station;
        this.g = g;
        this.f = f;
    }
}
