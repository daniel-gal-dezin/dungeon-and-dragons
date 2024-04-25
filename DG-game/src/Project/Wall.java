package Project;

import Project.Tile;
import Project.Unit;

public class Wall extends Tile {

    public Wall(){super('#');}

    public void accept(Unit u){
        //Nothing happens, the turn goes to waste for this unit.
    }
}
