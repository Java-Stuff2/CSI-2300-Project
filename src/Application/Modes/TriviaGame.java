package Application.Modes;

import Application.MainMenu;
import Application.Modes.TriviaQuiz.Quiz;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TriviaGame extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Trivia Game");
        Label labelTitle = new Label("Welcome to Trivia");
        labelTitle.setStyle("-fx-font: 16 Verdana;-fx-font-weight: bold;");
        labelTitle.setUnderline(true);
        Label labelRulesTrivia = new Label("Rules");
        labelRulesTrivia.setStyle("-fx-font: 14 Verdana;-fx-font-weight: bold;");
        labelRulesTrivia.setUnderline(true);
        Label gameRulesTriviaQuiz = new Label(
                "This is a quiz where it tests your knowledge on passwords (making passwords, etc)"
                        + "\nClick on the start button to begin the Trivia Quiz.");
        gameRulesTriviaQuiz.setStyle("-fx-font: 14 Verdana;-fx-font-weight: bold;");
        Button startButton = new Button("Start");
        startButton.setOnAction(e -> {
            Quiz quizStage = new Quiz();
            quizStage.start(primaryStage);

        });
        Button mainMenu2Button = new Button("Main Menu");
        mainMenu2Button.setOnAction(e -> {
            MainMenu menuMain = new MainMenu();
            menuMain.start(primaryStage);

        });

        VBox layoutTquiz = new VBox(10);
        layoutTquiz.setAlignment(Pos.CENTER);
        layoutTquiz.getChildren().addAll(labelTitle, labelRulesTrivia, gameRulesTriviaQuiz, startButton,
                mainMenu2Button);
        layoutTquiz.setId("VBox");
        Scene scenes = new Scene(layoutTquiz, 730, 550);
        scenes.getStylesheets().addAll(
                this.getClass().getResource("/Application/Resources/Background/TriviaBackground.css")
                        .toExternalForm());

        primaryStage.setScene(scenes);
        primaryStage.show();
    }

    public void TriviaGame() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'TriviaGame'");
    }

}
