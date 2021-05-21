import java.util.*;
public class RunRamblersBB {
    public static void main(String[] args) {
        TerrainMap tmap1 = new TerrainMap("tmc.pgm");
        Coords point1 = new Coords(3, 9);

        RamblersSearch searcher = new RamblersSearch(tmap1, new Coords(8, 9));
        SearchState iniState = (SearchState) new RamblersState(point1, 0, 0);

        String qq = searcher.runSearch(iniState, "b&b search");
        System.out.println(qq);
    }
}
