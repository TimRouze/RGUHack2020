package model;

import java.util.ArrayList;
import java.util.List;

public class Action {
	private int damages;
	private List<String> inputs;
	private int nextScene;
	
	public Action(int dmg, List<String> inpt, int nScene){
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

	public int getNextScene() {
		return nextScene;
	}

	public void setNextScene(int nextScene) {
		this.nextScene = nextScene;
	}
}
