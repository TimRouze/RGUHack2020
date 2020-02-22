package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Scene {
    private String text;
    private List<Action> actions;
    private boolean winningScene;

    public Scene(String text) {
        this.text = text;
        actions = new ArrayList<>();
    }

    public Scene(String text, boolean winning) {
        this.text = text;
        winningScene = winning;
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
