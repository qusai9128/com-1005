/*
*	State in a map search
*	Phil Green 2013 version
* Heidi Christensen (heidi.christensen@sheffield.ac.uk) 2021 version
*/

import java.util.*;

public class RamblersState extends SearchState {

  // Variables for each point
  private Coords point;
  private int hight;

  // constructor
  public RamblersState(Coords cname,int hig, int lc) {
    point = cname;
    hight = hig;
    localCost = lc;
  }

  // accessor
  public Coords getPoint() {
    return point;
  }

  // goalPredicate
  public boolean goalPredicate(Search searcher) {
    RamblersSearch msearcher = (RamblersSearch) searcher;
    Coords tar = msearcher.getGoal(); // get target city
    return (point.getx()==tar.getx() && point.gety()==tar.gety());
  }

  // getSuccessors
  public ArrayList<SearchState> getSuccessors(Search searcher) {
    RamblersSearch msearcher = (RamblersSearch) searcher;
    TerrainMap map = msearcher.getMap();
    ArrayList<SearchState> succs = new ArrayList<SearchState>();
    int max_x_coord = map.getWidth();
    int max_y_coord = map.getDepth();

       if (point.gety() > 0) {
           Coords suC = new Coords(point.gety()-1,point.getx());
           int suCH = map.getTmap()[suC.gety()][suC.getx()];
           int SuLoC;
           if (suCH <= hight) {
               SuLoC = 1;
           } else {
               SuLoC = 1+(suCH-hight);
           }
           succs.add(new RamblersState(suC, suCH,SuLoC));
       }

       if (point.getx() > 0) {
        Coords suC = new Coords(point.gety(),point.getx()-1);
        int suCH = map.getTmap()[suC.gety()][suC.getx()];
        int SuLoC;
        if (suCH <= hight) {
            SuLoC = 1;
        } else {
            SuLoC = 1+(suCH-hight);
        }
        succs.add(new RamblersState(suC, suCH,SuLoC));
    }

    if (point.gety() < max_y_coord - 1 ) {
        Coords suC = new Coords(point.gety()+1,point.getx());
        int suCH = map.getTmap()[suC.gety()][suC.getx()];
        int SuLoC;
        if (suCH <= hight) {
            SuLoC = 1;
        } else {
            SuLoC = 1+(suCH-hight);
        }
        succs.add(new RamblersState(suC, suCH,SuLoC));
    }

    if (point.gety() < max_x_coord - 1) {
        Coords suC = new Coords(point.gety(),point.getx()+1);
        int suCH = map.getTmap()[suC.gety()][suC.getx()];
        int SuLoC;
        if (suCH <= hight) {
            SuLoC = 1;
        } else {
            SuLoC = 1+(suCH-hight);
        }
        succs.add(new RamblersState(suC, suCH,SuLoC));
    }
    return succs;
  }

  // sameState

  public boolean sameState(SearchState s2) {
    RamblersState ms2 = (RamblersState) s2;
    return (point==ms2.getPoint());
  }

  // toString
  public String toString() {
    return ("point State: " + point);
  }

}

