package ProjectTest;
import Project.*;


import Project.GameFlow;

public class TestGame {


    public static void Play() {
        GameFlow game = new GameFlow();
        game.insertLevel("C:\\Users\\danie\\Desktop\\study\\סמסטר ב\\opp\\assignments\\assignemt3\\assigment3-oop\\levels_dir\\levels_dir\\level1.txt");
        game.RunGame();
    }

    public static void main(String[] args) {
        TestGame.Play();
    }


}
