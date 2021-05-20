
import java.util.*;

public class RamblersSearch extends Search {

  private TerrainMap map; // the map that we're searching in
  private Coords goal; // goal Coordinates

  public TerrainMap getMap() {
    return map;
    // this will return the map
  }

  public Coords getGoal() {
    return goal;
    // this will return the goal as Coordinates 
  }

  public RamblersSearch(TerrainMap m, Coords g) {
    map = m;
    goal = g;
  }
}

