package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Scene {
    public Text text;
    public List<Scene> nextScenes;

    public Scene(Text text) {
        this.text = text;
        nextScenes = new ArrayList<>();
    }

    public Scene(Text text, boolean winnigScene) {
        this.text = text;
    }

    public void addScene(Scene s) {
        nextScenes.add(s);
    }

    public void addScene(Scene[] scenes) {
        nextScenes.addAll(Arrays.asList(scenes));
    }

    @Override
    public String toString() {
        return "";
    }
}
