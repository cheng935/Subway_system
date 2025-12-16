package Main;

import Algorithms.A_Star;
import Algorithms.BFSSearching;
import Station_Data.*;

import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //下方注释的站点是换乘站
        Station a1 = new Station(101,"1a",-8.5,1);
        Station b1 = new Station(102,"1b",-7,0);
        //c1
        Station d1 = new Station(104,"1d",0,0);
        //e1
        //f1
        //g1
        Station h1 = new Station(108,"1h",-9.5,-1);


        //a2
        //b2
        Station c2 = new Station(203,"2c",4,-3);
        //d2
        Station e2 = new Station(205,"2e",-3,-2.5);
        //f2
        Station g2 = new Station(207,"2g",0,4);


        Station a3 = new Station(301,"3a",7,4.5);
        //b3
        Station c3 = new Station(303,"3c",7,-3);
        //d3
        Station e3 = new Station(305,"3e",0,-8);
        Station f3 = new Station(306,"3f",-5,-8);
        Station g3 = new Station(307,"3g",-5,-7.5);
        Station h3 = new Station(308,"3h",-6,-7.5);
        //i3
        //j3
        //k3
        Station l3 = new Station(312,"3l",7,6);


        Station a4 = new Station(401,"4a",-3.5,11);
        Station b4 = new Station(402,"4b",0,8);
        //c4
        Station d4 = new Station(404,"4d",2,5);
        //e4


        Station a5 = new Station(501,"5a",-4.5,7.5);
        //b5
        Station c5 = new Station(503,"5c",-4.5,3.5);
        //d5
        Station e5 = new Station(505,"5e",1.5,3);
        //f5
        //g5
        Station h5 = new Station(508,"5h",2,-6);
        //i5
        Station j5 = new Station(510,"5j",4.5,-10);

        //换乘站
        Station A = new Station(1,"A(1c/3i)", -6,0);
        Station B = new Station(2,"B(3j/5b)", -4.5,6);
        Station C = new Station(3,"C(3k/4c)", 0,6);
        Station D = new Station(4,"D(2f/5d)", 1.5,3);
        Station E = new Station(5,"E(2a/4e)", 2,4);
        Station F = new Station(6,"F(1e/5f)", 1.5,0);
        Station G = new Station(7,"G(1f/2b)", 4,0);
        Station H = new Station(8,"H(1g/3b)", 7,0);
        Station I = new Station(9,"I(2d/5g)", 1.5,-3);
        Station J = new Station(10,"J(3d/5i)", 4.5,-8);

        //线路
        SubwayLine line1 = new SubwayLine(1,"一号线",false);
        line1.addStation(a1);
        line1.addStation(b1);
        line1.addStation(A);//
        line1.addStation(d1);
        line1.addStation(F);//
        line1.addStation(G);//
        line1.addStation(H);//
        line1.addStation(h1);

        SubwayLine line2 = new SubwayLine(2,"二号线",true);
        line2.addStation(E);//
        line2.addStation(G);//
        line2.addStation(c2);
        line2.addStation(I);//
        line2.addStation(e2);
        line2.addStation(D);//
        line2.addStation(g2);

        SubwayLine line3 = new SubwayLine(3,"三号线",true);
        line3.addStation(a3);
        line3.addStation(H);//
        line3.addStation(c3);
        line3.addStation(J);//
        line3.addStation(e3);
        line3.addStation(f3);
        line3.addStation(g3);
        line3.addStation(h3);
        line3.addStation(A);//
        line3.addStation(B);//
        line3.addStation(C);//
        line3.addStation(l3);

        SubwayLine line4 = new SubwayLine(4,"四号线",false);
        line4.addStation(a4);
        line4.addStation(b4);
        line4.addStation(C);//
        line4.addStation(d4);

        SubwayLine line5 = new SubwayLine(5,"五号线",false);
        line5.addStation(a5);
        line5.addStation(B);//
        line5.addStation(c5);
        line5.addStation(D);//
        line5.addStation(e5);
        line5.addStation(F);//
        line5.addStation(I);//
        line5.addStation(h5);
        line5.addStation(J);//
        line5.addStation(j5);


        //建图（必须每条线都 build）
        GraphBuilder.build(line1);
        GraphBuilder.build(line2);
        GraphBuilder.build(line3);
        GraphBuilder.build(line4);
        GraphBuilder.build(line5);

/*
        //switch-case实现用户交互。
        Station start;
        Station goal;

        System.out.println("Enter your start station: ");
        String inputStart = sc.next().toUpperCase();

        switch (inputStart) {
            case "A": start = A; break;
            case "B": start = B; break;
            case "C": start = C; break;
            case "D": start = D; break;
            case "E": start = E; break;
            case "F": start = F; break;
            case "G": start = G; break;
            case "H": start = H; break;
            case "I": start = I; break;
            case "J": start = J; break;
            case "K": start = K; break;
            case "L": start = L; break;
            default:
                System.out.println("Invalid input! / Station dose not exists!");
                return;
        }

        System.out.println("Enter your goal station: ");
        String inputGoal = sc.next().toUpperCase();

        switch (inputGoal) {
            case "A": goal = A; break;
            case "B": goal = B; break;
            case "C": goal = C; break;
            case "D": goal = D; break;
            case "E": goal = E; break;
            case "F": goal = F; break;
            case "G": goal = G; break;
            case "H": goal = H; break;
            case "I": goal = I; break;
            case "J": goal = J; break;
            case "K": goal = K; break;
            case "L": goal = L; break;
            default:
                System.out.println("Invalid input! / Station dose not exists!");
                return;
        }
*/


        //使用HashMap实现用户交互,与switch-case相比更易维护且速度更快。更符合课程要求。
        HashMap<String, Station> stationList = new HashMap<>();

        stationList.put("1a", a1);
        stationList.put("1b", b1);
        stationList.put("1c", A);//
        stationList.put("1d", d1);
        stationList.put("1e", F);//
        stationList.put("1f", G);//
        stationList.put("1g", H);//
        stationList.put("1h", h1);

        stationList.put("2a", E);//
        stationList.put("2b", G);
        stationList.put("2c", c2);
        stationList.put("2d", I);
        stationList.put("2e", e2);
        stationList.put("2f", D);//
        stationList.put("2g", g2);

        stationList.put("3a", a3);
        stationList.put("3b", H);//
        stationList.put("3c", c3);
        stationList.put("3d", J);//
        stationList.put("3e", e3);
        stationList.put("3f", f3);
        stationList.put("3g", g3);
        stationList.put("3h", h3);
        stationList.put("3i", A);//
        stationList.put("3j", B);//
        stationList.put("3k", C);//
        stationList.put("3l", l3);

        stationList.put("4a", a4);
        stationList.put("4b", b4);
        stationList.put("4c", C);//
        stationList.put("4d", d4);
        stationList.put("4e", E);//

        stationList.put("5a", a5);
        stationList.put("5b", B);//
        stationList.put("5c", c5);
        stationList.put("5d", D);//
        stationList.put("5e", e5);
        stationList.put("5f", F);//
        stationList.put("5g", I);//
        stationList.put("5h", h5);
        stationList.put("5i", J);//
        stationList.put("5j", j5);

        stationList.put("a", A);
        stationList.put("b", B);
        stationList.put("c", C);
        stationList.put("d", D);
        stationList.put("e", E);
        stationList.put("f", F);
        stationList.put("g", G);
        stationList.put("h", H);
        stationList.put("i", I);
        stationList.put("j", J);


        try {
            //测试可选：B到2c
            System.out.print("Enter your start station: ");
            Station start = stationList.get(sc.next().toLowerCase());

            System.out.print("Enter your goal station: ");
            Station goal = stationList.get(sc.next().toLowerCase());

            //A* 搜索
            List<Station> path = A_Star.aStarSearch(start, goal);

            System.out.print("A*算法路径(路程最短)：");
            for (Station s : path) {
                if (!s.equals(path.get(path.size()  - 1)))
                    System.out.print(s.name + "-");
                else
                    System.out.print(s.name);
            }

            List<Station> pathBFS = BFSSearching.BFSSearchPath(start, goal);

            System.out.print("\nBFS算法路径(站点最少)：");
            for (Station s : pathBFS) {
                if (!s.equals(pathBFS.get(pathBFS.size() - 1)))
                    System.out.print(s.name + "-");
                else
                    System.out.print(s.name);
            }
        } catch (NullPointerException e){
            System.out.println("Hahaha! there's a bug in your code!");
        }

    }
}
