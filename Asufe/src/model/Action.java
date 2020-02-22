package model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Action {
    public static Scanner sc = new Scanner(System.in);

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
