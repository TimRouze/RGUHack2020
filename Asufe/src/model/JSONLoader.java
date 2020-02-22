package model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
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
                Scene scene = new Scene(Integer.parseInt((String)obj.get("id")), (String)obj.get("text"), SceneState.valueOf((String)obj.get("sceneState")));
                scenes.add(scene);
            });
        } catch(Exception e) {
            e.printStackTrace();
        }

        return scenes;
    }
}
