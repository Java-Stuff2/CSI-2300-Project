package Application;

import Application.Modes.ValidPasswordChecker;
import Application.Modes.TriviaGame;
import javafx.application.Application;
import Application.AboutPage.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainMenu extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
        ValidPasswordChecker game1 = new ValidPasswordChecker();
        game1.ValidPasswordChecker();
        TriviaGame game2 = new TriviaGame();
        game2.TriviaGame();
        About page = new About();
        page.About();

    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Main Menu");
        Label blurbs1Label = new Label("There are two Modes ");
        blurbs1Label.setStyle(" -fx-font: 18 Verdana; -fx-font-weight: bold;");
        blurbs1Label.setTextFill(Color.WHITE);
        Label blurbs2Label = new Label("Trivia Quiz & Password Checker");
        blurbs2Label.setStyle(" -fx-font: 18 Verdana; -fx-font-weight: bold;");
        blurbs2Label.setTextFill(Color.WHITE);
        Label optionsLabel = new Label("Please select the button of the game mode that you would like to play.");
        optionsLabel.setUnderline(true);
        optionsLabel.setTextFill(Color.WHITE);
        Button passwordGameButton = new Button("Password Checker");
        passwordGameButton.setStyle(" -fx-font: 16 Verdana; -fx-font-weight: bold;");
        Button triviaGameButton = new Button("Trivia Quiz");
        triviaGameButton.setStyle(" -fx-font: 16 Verdana; -fx-font-weight: bold;");

        Button AboutButton = new Button("About");
        AboutButton.setStyle(" -fx-font: 16 Verdana; -fx-font-weight: bold;");
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(blurbs1Label, blurbs2Label, optionsLabel, AboutButton, triviaGameButton,
                passwordGameButton);
        layout.setId("VBox");
        Scene scenes = new Scene(layout, 550, 550);
        scenes.getStylesheets().addAll(
                this.getClass().getResource("/Application/Resources/Background/MainMenuBackground.css")
                        .toExternalForm());

        primaryStage.setScene(scenes);
        primaryStage.show();

        VBox layout0 = new VBox(10);
        Scene scene0 = new Scene(layout0, 500, 500);
        AboutButton.setOnAction(e -> {
            primaryStage.setScene(scene0);
            primaryStage.show();
            About page = new About();
            page.start(primaryStage);
        });
        AboutButton.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.A) {
                primaryStage.setScene(scene0);
                primaryStage.show();
                About page = new About();
                page.start(primaryStage);
            } else if (e.getCode() == KeyCode.ENTER) {
                primaryStage.setScene(scene0);
                primaryStage.show();
                About page = new About();
                page.start(primaryStage);
            }
        });

        VBox layout1 = new VBox(10);
        Label paswrdLabel = new Label("Loading Password");
        layout1.getChildren().addAll(paswrdLabel);
        Scene scene1 = new Scene(layout1, 500, 500);

        passwordGameButton.setOnAction(e -> {
            primaryStage.setTitle("Password Game");
            primaryStage.setScene(scene1);
            primaryStage.show();
            ValidPasswordChecker game1 = new ValidPasswordChecker();
            game1.start(primaryStage);

        });
        passwordGameButton.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.C) {
                primaryStage.setScene(scene1);
                primaryStage.show();
                ValidPasswordChecker game1 = new ValidPasswordChecker();
                game1.start(primaryStage);
            } else if (e.getCode() == KeyCode.ENTER) {
                primaryStage.setScene(scene1);
                primaryStage.show();
                ValidPasswordChecker game1 = new ValidPasswordChecker();
                game1.start(primaryStage);
            }
        });

        VBox layout2 = new VBox(10);
        Scene scene2 = new Scene(layout2, 500, 500);

        Label triviaLoad = new Label("Loading Trivia Quiz");

        triviaGameButton.setOnAction(e -> {
            primaryStage.setTitle("Trivia Game");
            primaryStage.setScene(scene2);
            primaryStage.show();
            TriviaGame game2 = new TriviaGame();
            game2.start(primaryStage);
        });
        triviaGameButton.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.Q) {
                primaryStage.setScene(scene2);
                primaryStage.show();
                TriviaGame game2 = new TriviaGame();
                game2.start(primaryStage);
            } else if (e.getCode() == KeyCode.ENTER) {
                primaryStage.setScene(scene2);
                primaryStage.show();
                TriviaGame game2 = new TriviaGame();
                game2.start(primaryStage);
            }
        });
        layout2.getChildren().addAll(triviaLoad);
        Scene scene = new Scene(layout, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void MainMenu() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'MainMenu'");
    }
}
