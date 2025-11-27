package Algorithms;

import Station_Data.Station;

//注：该Node类用于存储open中站点的g，f值。
public class Node {
    public Station station;
    public double g;  // 起点到当前点的代价
    public double f;  // f = g + h

    public Node(Station station, double g, double f) {
        this.station = station;
        this.g = g;
        this.f = f;
    }
}
