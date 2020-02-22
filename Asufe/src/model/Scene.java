package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Scene {
	private int id;
    private String text;
    private List<Action> actions;
    private SceneState sceneState;

    public Scene(String text, SceneState state) {
        this.text = text;
        sceneState = state;
    }

    public void addAction(Action a) {
    	actions.add(a);
    }

    public void addAction(Action[] nActions) {
        actions.addAll(Arrays.asList(nActions));
    }

    @Override
    public String toString() {
        return "";
    }
    
}
