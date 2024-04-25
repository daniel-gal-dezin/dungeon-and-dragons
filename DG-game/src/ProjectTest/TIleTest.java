package ProjectTest;
import Project.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.LinkedList;

public class TIleTest {


    Position p1;
    Position p2;
    Position p3;
    Player player;

    Enemy monster;

    @Before
    public void set_up(){

        p1 = new Position(2,2);
        p2 = new Position(3,3);
        p3 = new Position(4,4);
        monster = new Monster('s', "Lannister Soldier", 80, 8, 3, 25, 3);
        monster.setPosition(p3);
        player =  new Warrior('@',"John Snow",300,300,30,4,0,1,3);
         player.setPosition(p1);



    }



    @Test
    public void intractWithwall(){
        Wall wall = new Wall();
        wall.setPosition(p2);
        player.interact(wall);
        assertSame(player.getPosition(),p1);

    }

    @Test
    public void heroInterctwithEempty(){
        Empty empty = new Empty();
        empty.setPosition(p2);
        player.interact(empty);
        assertSame(player.getPosition(),p2);

    }

    @Test
    public void MonsterIntercatwithwall(){
        Wall wall = new Wall();
        wall.setPosition(p2);
        monster.interact(wall);
        assertSame(p3,monster.getPosition());


    }
    @Test
    public void MonsterIntercatwithempty(){
        Empty empty = new Empty();
        empty.setPosition(p2);
        monster.interact(empty);
        assertSame(p2,monster.getPosition());


    }

}
