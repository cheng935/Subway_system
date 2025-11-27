package Main;

import Algorithms.A_Star;
import Station_Data.*;

import java.util.List;

public class test {
    public static void main(String[] args) {
        Station A = new Station(1,"A",-2,0);
        Station B = new Station(2,"B",-1,0);
        Station C = new Station(3,"C",0,0);
        Station D = new Station(4,"D",1,0);
        Station E = new Station(5,"E",0,1);
        Station F = new Station(6,"F",0,-1);
        Station G = new Station(7,"G",0,-2);
        Station H = new Station(8,"H",-1,-3);

        //加入坐标系后，通过I点变化导致的结果变化可以反映h正常工作.-->I(1,-1)时，结果为HGID   I(2,-2)时，结果为HGFCD。
        //Station I = new Station(9,"I",1,-1);
        Station I = new Station(9,"I",2,-2);

        Station J = new Station(10,"J",1,1);
        Station K = new Station(11,"K",0,-3);
        Station L = new Station(12,"L",2,0);

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
        List<Station> path = A_Star.aStarSearch(D, H);

        System.out.println("路径：");
        for (Station s : path) {
            System.out.print(s.name + " ");
        }

    }
}
