package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Scene {
	private int id;
    private String text;
    private List<Action> actions;
    private SceneState sceneState;

    public Scene(int id, String text, SceneState sceneState) {
        this.id = id;
        this.text = text;
        this.sceneState = sceneState;
        actions = new ArrayList<>();
    }
    
    public Scene() {
    	id = 0;
    	sceneState = SceneState.NEUTRAL;
    }

    public void addAction(Action a) {
    	actions.add(a);
    }
    
    public void setText(String text) {
    	this.text = text;
    }
    
    public String getText() {
    	return text;
    }

    public void addAction(Action[] nActions) {
        actions.addAll(Arrays.asList(nActions));
    }
    
    public List<Action> getActions(){
    	return actions;
    }
    
    public int getId() {
    	return id;
    }

    @Override
    public String toString() {
        return id + "\n" + text + "\n" + sceneState;
    }
    
}
