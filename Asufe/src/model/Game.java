package model;

import java.util.List;
import java.util.Scanner;

public class Game {
	
	private Player player;
	private Scene currentScene;
	private Scanner in;
	public Game(Player player, Scene currentScene) {
		this.player = player;
		this.currentScene = currentScene;
		in = new Scanner(System.in);
	}
	
	public int getPlayerInput() {
		return checkInput(in.nextLine().toLowerCase().trim());
	}
	
	public int checkInput(String userInput) {
		List<Action> actions = currentScene.getActions();
		for(Action a : actions) {
			List<String> inputs = a.getInputs();
			for(String input: inputs) {
				if(userInput.contains(input)) {
					return a.getNextScene();
				}
			}
		}
		return currentScene.getId();
	}
	
}
