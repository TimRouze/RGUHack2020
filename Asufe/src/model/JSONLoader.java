package model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import model.Action;
import model.Scene;
import model.SceneState;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JSONLoader {
    public static List<Scene> getScenes(String path) {
        List<Scene> scenes = new ArrayList<>();

        JSONParser jsonParser = new JSONParser();
        try {
            Object object = jsonParser.parse(new FileReader(path));
            JSONArray jsonArray = (JSONArray) object;
            jsonArray.forEach(o -> {
                JSONObject obj = (JSONObject)o;
                Scene scene = new Scene(Integer.parseInt((String)obj.get("id")), (String)obj.get("text"), SceneState.valueOf((String)obj.get("sceneState")), (Boolean)obj.get("conditioned"));
                JSONArray actions = (JSONArray)obj.get("actions");
                actions.forEach(act -> {
                    JSONObject action = (JSONObject)act;
                    int dmg = Integer.parseInt((String)action.get("damages"));
                    int nextScene = Integer.parseInt((String)action.get("nextScene"));
                    Object truc = action.get("conditioned");
                    List<String> inputs = new ArrayList<>();
                    ((JSONArray)action.get("inputs")).forEach(input -> {
                        inputs.add((String)input);
                    });
                    scene.addAction(new Action(dmg, inputs, nextScene));
                });
                scenes.add(scene);
            });
        } catch(Exception e) {
            e.printStackTrace();
        }

        return scenes;
    }
    
    public static Scene getIntro(String path) {
        Scene scene = new Scene();
        JSONParser jsonParser = new JSONParser();
        try {
         Object object = jsonParser.parse(new FileReader(path));
         JSONObject jsonObject = (JSONObject) object;
         scene.setText((String)jsonObject.get("text"));
        } catch(Exception e) {
         e.printStackTrace();
        }
        return scene;
       }

}
