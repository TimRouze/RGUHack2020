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
