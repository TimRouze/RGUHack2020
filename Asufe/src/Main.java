import model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Scene> scenes = new ArrayList<>();

    public static void main(String[] args) {
    	scenes = JSONLoader.getScenes("resources/Scenes.json");
    	Scene intro = JSONLoader.getIntro("resources/intro.json");
    	Game game = new Game(new Player("Mich'mich", 10), scenes.get(0));
    	System.out.println("------------------------------------------------------------------------------------------------------");
    	System.out.println(intro.getText());
    	System.out.println("------------------------------------------------------------------------------------------------------");
    	System.out.println(scenes.get(0).getText());
    	System.out.print(">");
    	int newSceneId = game.getPlayerInput();
    	System.out.println(newSceneId);
    	System.out.println("------------------------------------------------------------------------------------------------------");
    	System.out.println(scenes.get(newSceneId-1).getText());
    	System.out.println("------------------------------------------------------------------------------------------------------");
    }
}
