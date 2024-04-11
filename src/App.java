import Application.MainMenu;
import Application.AboutPage.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
        MainMenu main = new MainMenu();
        main.MainMenu();
        About page = new About();
        page.About();
    }

    @Override
    public void start(Stage primaryStage) {
        Label titleLabel = new Label("Password Validate\u00AE");
        titleLabel.setStyle("-fx-font: 24 Verdana; -fx-font-weight: bold;");
        titleLabel.setUnderline(true);
        titleLabel.setTextFill(Color.WHITE);
        Label welcomLabel = new Label("\nHello! Welcome to Password Validate!\n");
        welcomLabel.setStyle("-fx-font: 14 Verdana; -fx-font-weight: bold;");
        welcomLabel.setTextFill(Color.WHITE);
        Button AboutButton = new Button("About");
        AboutButton.setStyle("-fx-font-weight: bold;");
        Label introLabel = new Label("\nPlease click Main Menu to go to the Main Menu.");
        introLabel.setTextFill(Color.WHITE);
        introLabel.setStyle("-fx-font: 14 Verdana; -fx-font-weight: bold;");
        Button MainMenuButton = new Button("Main Menu");
        MainMenuButton.setStyle("-fx-font-weight: bold;");

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(titleLabel, welcomLabel, AboutButton, introLabel, MainMenuButton);
        layout.setId("VBox");
        Scene scene = new Scene(layout, 600, 600);
        scene.getStylesheets().addAll(
                this.getClass().getResource("/Application/Resources/Background/backgroundApp.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Password Validate");
        primaryStage.show();

        VBox aboutpLayout = new VBox(10);
        Scene aboutpScene = new Scene(aboutpLayout, 600, 600);

        AboutButton.setOnAction(e -> {
            primaryStage.setScene(aboutpScene);
            primaryStage.show();
            About page = new About();
            page.start(primaryStage);
        });
        AboutButton.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.A) {
                primaryStage.setScene(aboutpScene);
                primaryStage.show();
                About page = new About();
                page.start(primaryStage);
            } else if (e.getCode() == KeyCode.ENTER) {
                primaryStage.setScene(aboutpScene);
                primaryStage.show();
                About page = new About();
                page.start(primaryStage);
            }
        });
        VBox menuLayout = new VBox(10);
        Scene menuScene = new Scene(menuLayout, 600, 600);
        MainMenuButton.setOnAction(e -> {
            primaryStage.setTitle("Main Menu");
            primaryStage.setScene(menuScene);
            primaryStage.show();
            MainMenu main = new MainMenu();
            main.start(primaryStage);
        });

        // Keyboard shortcuts for the Main Menu Button
        MainMenuButton.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.M) {
                primaryStage.setTitle("Main Menu");
                primaryStage.setScene(menuScene);
                primaryStage.show();
                MainMenu main = new MainMenu();
                main.start(primaryStage);
            } else if (e.getCode() == KeyCode.ENTER) {
                primaryStage.setTitle("Main Menu");
                primaryStage.setScene(menuScene);
                primaryStage.show();
                MainMenu main = new MainMenu();
                main.start(primaryStage);
            }
        });
    }
}
