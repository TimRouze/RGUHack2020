package model;

import java.util.List;

public class Game {
	private Player player;
	private List<Scene> scenes;
	private int currentSceneId;
	private boolean playing;

	public Game(Player player, List<Scene> scenes) {
		this.player = player;
		this.scenes = scenes;
		this.playing = true;
	}

	public Scene getScene(Action action) {
		currentSceneId = action.getNextScene();
		Scene currentScene = getScene(action.getNextScene());

		player.setHp(player.getHp() - action.getDamages());
		switch(currentScene.getSceneState()) {
			case WIN:
			case LOSE:
				playing = false;
				break;
		}

		return currentScene;
	}
	
	public Action guessAction(String userInput) {
		List<Action> actions = getScene(currentSceneId).getActions();
		for(Action a : actions) {
			List<String> inputs = a.getInputs();
			for(String input: inputs) {
				if(userInput.contentEquals(input)) {
					return a;
				}
			}
		}
		return new Action(0, null, currentSceneId);
	}

	private Scene getScene(int id) {
		for(Scene s : scenes)
			if(s.getId() == id)
				return s;
		return null;
	}

	public Scene getCurrentScene() {
		return getScene(currentSceneId);
	}

	public boolean isPlaying() {
		return playing;
	}

	public Player getPlayer() {
		return player;
	}
}
