import model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    static List<Scene> scenes = new ArrayList<>();

    public static void main(String[] args) {
        createScenes();
        for(Scene s : scenes) {
            System.out.println(s);
        }
    }

    public static void createScenes() {
        Scene s1 = new Scene(new Text("Scene 1"));
        Scene s2 = new Scene(new Text("Scene 2"));
        Scene s3 = new Scene(new Text("Scene 3"));
        Scene s4 = new Scene(new Text("Scene 4"));
        Scene s5 = new Scene(new Text("Scene 5"));
        Scene s6 = new Scene(new Text("Scene 6"), true);
        Scene s7 = new Scene(new Text("Scene 7"), false);

        s1.addScene(new Scene[]{s2, s3});
        s2.addScene(s5);
        s3.addScene(s4);
        s4.addScene(new Scene[]{s3, s7});
        s5.addScene(s6);

        scenes.addAll(Arrays.asList(s1, s2, s3, s4, s5, s6, s7));
    }
}
