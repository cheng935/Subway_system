package Main;

import Algorithms.A_Star;
import Algorithms.BFSSearching;
import Station_Data.*;

import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        Station A = new Station(1,"A",-2,0);
        Station B = new Station(2,"B",-1,0);
        Station C = new Station(3,"C",0,0);
        Station D = new Station(4,"D",1,0);
        Station E = new Station(5,"E",0,1);
        Station F = new Station(6,"F",0,-1);
        Station G = new Station(7,"G",0,-2);
        Station H = new Station(8,"H",-1,-3);

        //加入坐标系后，I点坐标变化导致的结果变化可以反映启发值h正常工作.-->I(1,-1)时，从H到D，结果为HGID   I(2,-2)时，结果为HGFCD。
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
        line1.addStation(L);

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

        //建图（必须每条线都 build）
        GraphBuilder.build(line1);
        GraphBuilder.build(line2);
        GraphBuilder.build(line3);

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

        stationList.put("A", A);
        stationList.put("B", B);
        stationList.put("C", C);
        stationList.put("D", D);
        stationList.put("E", E);
        stationList.put("F", F);
        stationList.put("G", G);
        stationList.put("H", H);
        stationList.put("I", I);
        stationList.put("J", J);
        stationList.put("K", K);
        stationList.put("L", L);

        try {
            System.out.print("Enter your start station: ");
            Station start = stationList.get(sc.next().toUpperCase());

            System.out.print("Enter your goal station: ");
            Station goal = stationList.get(sc.next().toUpperCase());

            //A* 搜索
            List<Station> path = A_Star.aStarSearch(start, goal);

            System.out.print("A*算法路径：");
            for (Station s : path) {
                if (!s.equals(path.get(path.size()  - 1)))
                    System.out.print(s.name + "-");
                else
                    System.out.print(s.name);
            }

            List<Station> pathBFS = BFSSearching.BFSSearchPath(start, goal);

            System.out.print("\nBFS算法路径：");
            for (Station s : pathBFS) {
                if (!s.equals(path.get(pathBFS.size() - 1)))
                    System.out.print(s.name + "-");
                else
                    System.out.print(s.name);
            }
        } catch (NullPointerException e){
            System.out.println("Invalid input / Station dose not exists!");
        }

    }
}
