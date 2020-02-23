package view;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import model.Action;
import model.Game;
import model.JSONLoader;
import model.Player;
import model.SceneState;

public class MainView extends Application{
	Stage window;
	Scene menuScene, gameScene, endScene; 
	Action action;
	Game game;
	TextField userGameInput;
	List<model.Scene> scenes;
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		scenes = new ArrayList<>();
    	scenes = JSONLoader.getScenes("resources/Scenes.json");
    	
		window = primaryStage;
		window.setTitle("A Series of (un)Fortunate Events");
		Text gameTitle = new Text("A Series of (un)Fortunate Events");
		gameTitle.setStyle("-fx-fill: white;");
		gameTitle.setTextAlignment(TextAlignment.CENTER);
		Text instructions = new Text("Type in 'start'");
		instructions.setTextAlignment(TextAlignment.CENTER);
		instructions.setStyle("-fx-fill: white;");
		TextField userInput = new TextField();
		userInput.setStyle("-fx-background-color: darkgrey; -fx-border-color: black;");
		GridPane menuLayout = new GridPane();
		menuLayout.setMinSize(500, 400);
		menuLayout.setVgap(50);
		menuLayout.setAlignment(Pos.CENTER);
		menuLayout.add(gameTitle, 1, 0);
		menuLayout.add(instructions, 1, 1);
		menuLayout.add(userInput, 1, 2);
		menuLayout.setStyle("-fx-background-color: black;");
		menuScene = new Scene(menuLayout);
		menuScene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
		      if(key.getCode()==KeyCode.ENTER) {
		          String uInput = userInput.getText().toLowerCase().trim();
		          if(uInput.equals("start")) {
		        	  initGameScene();
		        	  window.setScene(gameScene);
		          }
		      }
		});
		window.setScene(menuScene);
		window.show();
	}

	public void initGameScene() {
    	model.Scene intro = JSONLoader.getIntro("resources/intro.json");
    	model.Scene rules = JSONLoader.getIntro("resources/rules.json");
    	game = new Game(new Player("Mich'mich", 10), scenes);
    	action = new Action(0, null, 0);
    	
    	Button tryAgainBtn = new Button();
    	tryAgainBtn.setText("Click here to quit the game!");
    	tryAgainBtn.setVisible(false);
    	tryAgainBtn.setOnAction(e -> {
    		window.close();
    	});
		Text gameText = new Text();
		gameText.setText(intro.toString());
		gameText.setStyle("-fx-fill: white; -fx-font-size: 18;");
		gameText.setTextAlignment(TextAlignment.CENTER);
		Text rulesText = new Text();
		rulesText.setText(rules.toString());
		rulesText.setFill(Color.WHITE);
		rulesText.setTextAlignment(TextAlignment.CENTER);
		rulesText.setFont(Font.font("Verdanna", FontPosture.ITALIC, 18));
		userGameInput = new TextField();
		userGameInput.setStyle("-fx-background-color: darkgrey; -fx-border-color: black;");
		VBox gameLayout = new VBox();
		gameLayout.setMinSize(500, 600);
		gameLayout.setStyle("-fx-background-color: black;");
		//gameLayout.setStyle("-fx-background-image: url('view/Scene1.jpg'); -fx-background-position: center center; -fx-background-repeat: stretch; -fx-background-color: black;");
		gameLayout.setMargin(gameText, new Insets(30, 20, 50, 20));
		gameLayout.setAlignment(Pos.CENTER);
		ObservableList list = gameLayout.getChildren();
		list.addAll(gameText, rulesText, userGameInput, tryAgainBtn);
		gameScene = new Scene(gameLayout);
		gameScene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
		      if(key.getCode()==KeyCode.ENTER) {
		          String uInput = userGameInput.getText().toLowerCase().trim();
		          rulesText.setVisible(false);
		          userGameInput.clear();
		          gameText.setText(game.getScene(action).toString());
		          if(game.getCurrentScene().isConditioned()) {
		        	  if(game.getPlayer().getHp() < 5) {
							action = new Action(0, null, 11);
							gameText.setText("press enter");
		        	  }else {
		        		  action = new Action(0, null, 12);
		        		  gameText.setText("press enter");
		        	  }
		          }
		          if(!game.isPlaying()) {
		        	  tryAgainBtn.setVisible(true);
		        	  userGameInput.setVisible(false);
		          }
		          action = game.guessAction(uInput);
		          uInput = "";
		      }
		});
	}
	
	 /*public void gameMethod() {
			Game game = new Game(new Player("Mich'mich", 10), scenes);
			Action action = new Action(0, null, 0);
			while(game.isPlaying()) {
				sc = new Scanner(System.in);
				System.out.println(game.getScene(action));
				if(game.getCurrentScene().isConditioned()) {
					
						System.out.println("press enter");
						sc.nextLine();
					} else {
						action = new Action(0, null, 12);
						System.out.println("press enter");
						sc.nextLine();
					}
				} else {
					action = game.guessAction(sc.nextLine().toLowerCase().trim());
				}
			}
	    }*/
}
