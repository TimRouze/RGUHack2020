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
    	int sceneId = 1;
    	boolean playing = true;
    	Game game = new Game(new Player("Mich'mich", 10), scenes.get(0));
    	System.out.println(intro);
    	while(playing) {
    		System.out.println(scenes.get(sceneId-1));
        	System.out.print(">");
        	sceneId = game.getPlayerInput();
        	try {
            	Thread.sleep(1000);
        	} catch(Exception e) {
        		e.printStackTrace();
        	}
        	if(sceneId == game.getCurrentScene().getId()) {
        		System.out.println("I'm affraid you can't do that... Try something else!");
        	}else {
	        	System.out.println(sceneId);
	        	System.out.println(scenes.get(sceneId-1));
	        	if(scenes.get(sceneId-1).getSceneState() == SceneState.WIN) {
	            	System.out.println("------------------------------------------------------------------------------------------------------");
	        		System.out.println("Nice one bud!");
	        		playing = false;
	        	}else if(scenes.get(sceneId-1).getSceneState() == SceneState.LOSE) {
	            	System.out.println("------------------------------------------------------------------------------------------------------");
	        		System.out.println("BOOOOOH you lose!");
	        		playing = false;
	        	}
        	}
    	}
    	
    	System.out.println("------------------------------------------------------------------------------------------------------");
    }
}
