package Application.Modes;

import Application.MainMenu;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ValidPasswordChecker extends Application {
    private final DoubleProperty fontSize = new SimpleDoubleProperty(16); // Default font size
    private final FontStyle fontStyle = new FontStyle();
    private int totalAttempts = 0;
    private int validAttempts = 0;
    private int invalidAttempts = 0;

    public static void main(String[] args) {
        launch(args);
        MainMenu mainMain = new MainMenu();
        mainMain.MainMenu();

    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Password Checker");

        VBox passwordContent = createPassContent(primaryStage);
        ScrollPane contentArea = new ScrollPane();
        contentArea.setContent(passwordContent);
        TitledPane settingsPane = createSettingsPane(contentArea);

        settingsPane.expandedProperty().addListener((obs, oldExpanded, newExpanded) -> {
            if (newExpanded) {
                // Settings expanded, update font size
                fontSize.set(16); // Reset to default
            }
        });

        passwordContent.styleProperty()
                .bind(Bindings.createStringBinding(
                        () -> String.format("-fx-font-size: %.1fpx; -fx-font-family: %s;", fontSize.get(),
                                fontStyle.getFontFamily()),
                        fontSize, fontStyle.fontFamilyProperty()));

        VBox root = new VBox(10);
        root.getChildren().addAll(settingsPane, contentArea);
        root.setPadding(new Insets(20));
        Scene scene = new Scene(root, 800, 600);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Password");
        primaryStage.show();
    }

    private TitledPane createSettingsPane(ScrollPane contentArea) {
        ComboBox<Double> fontSizeComboBox = new ComboBox<>();
        fontSizeComboBox.getItems().addAll(12.0, 14.0, 16.0, 18.0, 20.0, 22.0); // Add more options if needed
        fontSizeComboBox.setValue(16.0); // Default font size

        ComboBox<String> fontComboBox = new ComboBox<>();
        fontComboBox.getItems().addAll("Arial", "Times New Roman", "Verdana",
                "Calibri", "Helvetica", "Tahoma", "OpenDyslexic");
        fontComboBox.setValue("Verdana");

        fontSizeComboBox.setOnAction(e -> fontSize.set(fontSizeComboBox.getValue()));
        fontComboBox.setOnAction(e -> fontStyle.setFontFamily(fontComboBox.getValue()));

        VBox settingsPaneContent = new VBox(10);
        settingsPaneContent.getChildren().addAll(new Label("Font Size:"), fontSizeComboBox,
                new Label("Font Family:"), fontComboBox);

        TitledPane settingsPane = new TitledPane("Settings", settingsPaneContent);
        settingsPane.setAnimated(true);
        settingsPane.setCollapsible(true);
        settingsPane.setExpanded(false); // Initially collapsed

        return settingsPane;
    }

    private VBox createPassContent(Stage primaryStage) {
        Label gameRules1Label = new Label("Rules");
        gameRules1Label.setStyle("-fx-font-weight: bold;");
        gameRules1Label.setUnderline(true);
        Label gameRulesLabel1 = new Label("Type in a password in the field underneath 'Enter a password'."
                + "\nAfter you enter a password, click on the validate button underneath the field."
                + "\nMake sure to check your attempts by clicking on the 'Show Attempts' button.");

        Label titleLabel = new Label("Enter a password:");
        titleLabel.setStyle("-fx-font-weight: bold;");
        PasswordField passwordField = new PasswordField();
        Button validateButton = new Button("Feedback");
        Label feedbackLabel = new Label();

        Button showAttemptsButton = new Button("Show Attempts");
        Button backButton = new Button("Main Menu");

        validateButton.setOnAction(e -> validatePassword(passwordField.getText(), feedbackLabel));
        showAttemptsButton.setOnAction(e -> showAttempts());
        backButton.setOnAction(e -> {
            MainMenu menuMenu = new MainMenu();
            menuMenu.start(primaryStage);
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));

        layout.getChildren().addAll(gameRules1Label, gameRulesLabel1, titleLabel, passwordField, validateButton,
                feedbackLabel, showAttemptsButton, backButton);

        Scene scenepv = new Scene(layout, 550, 350);
        primaryStage.setScene(scenepv);
        primaryStage.show();
        return layout;
    }

    private void validatePassword(String password, Label feedbackLabel) {
        feedbackLabel.setText("Feedback:");
        // Define validation rules
        totalAttempts++;
        boolean hasUpperCase = password.matches(".*[A-Z].*");
        boolean hasLowerCase = password.matches(".*[a-z].*");
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSymbol = password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\",./<>?].*");

        if (password.length() > 8 && hasUpperCase && hasLowerCase && hasDigit && hasSymbol) {
            validAttempts++;
            feedbackLabel.setText("Password accepted! This is a very vaild and strong password!"
                    + "\nIt has at least one of everything: lowercase letters, uppercase letters, digits, and symbols."
                    + "\nIts length is long.");
            feedbackLabel.setStyle("-fx-text-fill: green;");

        } else if (password.length() == 8 && hasUpperCase && hasLowerCase && hasDigit && hasSymbol) {
            feedbackLabel.setText("Password accepted! Try a longer password for more strength!");
            feedbackLabel.setStyle("-fx-text-fill: yellow;");
        } else if (password.length() >= 8 && hasUpperCase && hasLowerCase && hasDigit) {

            feedbackLabel.setText(
                    "Password accepted! \nOn your next attempt, consider adding symbols: '.*[!@#$%^&*()_+\\-=\\[\\]{};':\",./<>?].*' to your password.");
            feedbackLabel.setStyle("-fx-text-fill: yellow;");
        } else if (password.length() >= 8 && hasUpperCase && hasLowerCase && hasSymbol) {

            feedbackLabel
                    .setText(
                            "Password accepted!  \nOn your next attempt, consider adding digits '0123456789' to your password");
            feedbackLabel.setStyle("-fx-text-fill: yellow;");
        } else if (password.length() >= 8 && hasUpperCase && hasDigit && hasSymbol) {
            feedbackLabel
                    .setText(
                            "Password accepted!  \nOn your next attempt, consider adding lowercase letters 'abc' to your password");
            feedbackLabel.setStyle("-fx-text-fill: yellow;");
        } else if (password.length() >= 8 && hasLowerCase && hasDigit && hasSymbol) {
            feedbackLabel
                    .setText(
                            "Password accepted!  \nOn your next attempt, consider adding uppercase letters 'ABC' to your password");
            feedbackLabel.setStyle("-fx-text-fill: yellow;");
        } else {
            invalidAttempts++;
            feedbackLabel.setText("Invalid password. Please try again.");
            feedbackLabel.setStyle("-fx-text-fill: red;");
        }
    }

    private void showAttempts() {
        showResult("Valid Password Attempts: " + validAttempts + "\n Invalid Attempts: " + invalidAttempts
                + "\n Total Attempts: " + totalAttempts);
    }

    private void showResult(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Password Checker");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void ValidPasswordChecker() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ValidPasswordChecker'");
    }
}

class FontStyle {
    private final StringProperty fontFamily;

    public FontStyle() {
        this.fontFamily = new SimpleStringProperty("Verdana");
    }

    public StringProperty fontFamilyProperty() {
        return fontFamily;
    }

    public String getFontFamily() {
        return fontFamily.get();
    }

    public void setFontFamily(String fontFamily) {
        this.fontFamily.set(fontFamily);
    }
}
