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
    	//System.out.println(scenes);
    	/*Scene intro = JSONLoader.getIntro("resources/intro.json");
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
    	
    	System.out.println("------------------------------------------------------------------------------------------------------");*/
		Scanner sc = new Scanner(System.in);
		Game game = new Game(new Player("Mich'mich", 10), scenes);
		Action action = new Action(0, null, 0);
		while(game.isPlaying()) {
			sc = new Scanner(System.in);
			System.out.println(game.getScene(action));
			if(game.getCurrentScene().isConditioned()) {
				if(game.getPlayer().getHp() < 5) {
					action = new Action(0, null, 11);
					System.out.println("press enter");
					sc.nextLine();
				} else {
					action = new Action(0, null, 12);
					System.out.println("press enter");
					sc.nextLine();
				}
			} else {
				action = game.guessAction(sc.nextLine().toLowerCase().trim());
			}
		}
    }
}
