package Main;

import Algorithms.A_Star;
import station_database.*;

import java.util.List;

public class test {
    public static void main(String[] args) {
        Station A = new Station(1,"A");
        Station B = new Station(2,"B");
        Station C = new Station(3,"C");
        Station D = new Station(4,"D");
        Station E = new Station(5,"E");
        Station F = new Station(6,"F");
        Station G = new Station(7,"G");
        Station H = new Station(8,"H");
        Station I = new Station(9,"I");
        Station J = new Station(10,"J");
        Station K = new Station(11,"K");
        Station L = new Station(12,"L");

        SubwayLine line1 = new SubwayLine(1,"一号线");
        line1.addStation(A);
        line1.addStation(B);
        line1.addStation(C);
        line1.addStation(D);
        line1.addStation(E);

        SubwayLine line2 = new SubwayLine(2,"二号线");
        line2.addStation(E);
        line2.addStation(C);
        line2.addStation(F);
        line2.addStation(G);
        line2.addStation(K);

        SubwayLine line3 = new SubwayLine(3,"三号线");
        line3.addStation(H);
        line3.addStation(G);
        line3.addStation(I);
        line3.addStation(D);
        line3.addStation(J);

        // 3. 建图（必须每条线都 build）
        GraphBuilder.build(line1);
        GraphBuilder.build(line2);
        GraphBuilder.build(line3);

        // 4. A* 搜索
        List<Station> path = A_Star.aStarSearch(H, D);

        System.out.println("路径：");
        for (Station s : path) {
            System.out.print(s.name + " ");
        }

    }
}
