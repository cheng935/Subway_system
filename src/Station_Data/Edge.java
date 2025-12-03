/*
package station_database;

public class Edge {
    public Station target;
    public int cost;

    public Edge(Station target, int cost) {
        this.target = target;
        this.cost = cost;
    }
}
*/

//该类在之前使用单链表时使用于存储站点距离
//后来我发现改为双链表，neighbor类中可以定义distance，已经能完成存储任务
//A*只需相邻节点和节点距离，neighbor完全满足需求，edge淘汰.