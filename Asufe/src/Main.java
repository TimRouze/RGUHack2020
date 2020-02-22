import model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Scene> scenes = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
    	Player michmich = new Player("Mich'mich", 10);
    	System.out.println("My name is: " + michmich.getName());
    	scenes = JSONLoader.getScenes("resources/Scenes.json");
        System.out.println(scenes);
    }

    public static String readAction() {
        String res;
        while(true) {
            try {
                res = sc.nextLine();
                break;
            } catch(InputMismatchException e) {
                sc.next();
            }
        }
        return res;
    }
}
