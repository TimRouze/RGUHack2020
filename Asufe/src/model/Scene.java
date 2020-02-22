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
    }

    public void addAction(Action a) {
    	actions.add(a);
    }

    public void addAction(Action[] nActions) {
        actions.addAll(Arrays.asList(nActions));
    }

    @Override
    public String toString() {
        return id + "\n" + text + "\n" + sceneState;
    }
    
}
