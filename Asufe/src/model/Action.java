package model;

import java.util.List;

public class Action {
	private int damages;
	private List<String> inputs;
	private Scene nextScene;
	
	Action(int dmg, List<String> inpt, Scene nScene){
		damages = dmg;
		inputs = inpt;
		nextScene = nScene;
	}

	public int getDamages() {
		return damages;
	}

	public void setDamages(int damages) {
		this.damages = damages;
	}

	public List<String> getInputs() {
		return inputs;
	}

	public void setInputs(List<String> inputs) {
		this.inputs = inputs;
	}

	public Scene getNextScene() {
		return nextScene;
	}

	public void setNextScene(Scene nextScene) {
		this.nextScene = nextScene;
	}
	
	
}
