package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Scene {
	private int id;
    private String text;
    private SceneState sceneState;
    private boolean conditioned;
    private List<Action> actions;

    public Scene(int id, String text, SceneState sceneState, boolean conditioned) {
        this.id = id;
        this.text = text;
        this.sceneState = sceneState;
        this.conditioned = conditioned;
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

    public boolean isConditioned() {
        return conditioned;
    }

    public SceneState getSceneState() {
    	return sceneState;
    }
    @Override
    public String toString() {
    	String stringText = "------------------------------------------------------------------------------------------------------\n";
    	stringText += id + "\n" + text + "\n";
        return stringText;
    }
}
