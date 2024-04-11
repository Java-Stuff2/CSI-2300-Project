
package Application.Modes.TriviaQuiz;

import Application.MainMenu;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Quiz extends Application {
    private final DoubleProperty fontSize = new SimpleDoubleProperty(16); // Default font size
    private final FontStyle fontStyle = new FontStyle();

    public static void main(String[] args) {
        launch(args);
        MainMenu mainMain = new MainMenu();
        mainMain.MainMenu();

    }

    @Override
    public void start(Stage primaryStage) {

        // Where the quiz content will be held
        VBox quizContent = createQuizContent(primaryStage);
        ScrollPane contentArea = new ScrollPane();
        contentArea.setContent(quizContent);

        // collapsible settings section
        TitledPane settingsPane = createSettingsPane();

        // Bind font size to the selected value in the ComboBox
        settingsPane.expandedProperty().addListener((obs, oldExpanded, newExpanded) -> {
            if (newExpanded) {
                // Settings expanded, update font size
                fontSize.set(16); // Reset to default
            }
        });
        quizContent.styleProperty()
                .bind(Bindings.createStringBinding(() -> String.format("-fx-font-size: %.1fpx; -fx-font-family: %s;",
                        fontSize.get(), fontStyle.getFontFamily()),
                        fontSize, fontStyle.fontFamilyProperty()));

        VBox root = new VBox(10);
        root.getChildren().addAll(settingsPane, contentArea);
        root.setPadding(new Insets(20));
        Scene scene = new Scene(root, 800, 600);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Quiz App");
        primaryStage.show();
    }

    // Layout the scene
    private VBox createQuizContent(Stage primaryStage) {
        VBox vbox = new VBox(10);

        Pane titleQuizPanel = new Pane();
        Label quizTitleLabel = new Label("Quiz");
        quizTitleLabel.setLayoutX(250);
        titleQuizPanel.getChildren().add(quizTitleLabel);
        quizTitleLabel.setAlignment(Pos.TOP_CENTER);
        quizTitleLabel.setStyle("-fx-font-weight: bold; -fx-underline: true;");

        Label question1label = new Label(
                "\n1) As of 2024, which of the following passwords are the most commonly used passwords?"
                        + "\n (Click all that apply)");
        question1label.setStyle("-fx-font-weight: bold;");
        CheckBox quest1choice1CheckBox = new CheckBox("a) 123456");
        CheckBox quest1choice2CheckBox = new CheckBox("b) Qwerty1234");
        CheckBox quest1choice3CheckBox = new CheckBox("c) #APpI3ifhone");
        CheckBox quest1choice4CheckBox = new CheckBox("d) Password");
        CheckBox quest1choice5CheckBox = new CheckBox("e) 123werty456");
        Label q1LabelQuestionFeed = new Label();
        Label q1LabelAnswer = new Label();
        vbox.getChildren().addAll(titleQuizPanel, question1label, quest1choice1CheckBox, quest1choice2CheckBox,
                quest1choice3CheckBox, quest1choice4CheckBox, quest1choice5CheckBox);

        Label divider12 = new Label("----------------------------------------------------------------------------");

        Label question2label = new Label(
                "2) What kind of characters should you use in your passwords to make them secure?"
                        + "\n(Select one answer)");
        question2label.setStyle("-fx-font-weight: bold;");
        RadioButton q2Radio1, q2Radio2, q2Radio3, q2Radio4, q2Radio5;
        q2Radio1 = new RadioButton("a) Mixed cased letters only");
        q2Radio2 = new RadioButton("b) Numbers only");
        q2Radio3 = new RadioButton("c) Mixed letters and numbers");
        q2Radio4 = new RadioButton("d) Special Characters");
        q2Radio5 = new RadioButton("e) Choices c and d");
        ToggleGroup question2 = new ToggleGroup();
        q2Radio1.setToggleGroup(question2);
        q2Radio2.setToggleGroup(question2);
        q2Radio3.setToggleGroup(question2);
        q2Radio4.setToggleGroup(question2);
        q2Radio5.setToggleGroup(question2);
        Label q2LabelQuestionFeed = new Label();
        Label q2LabelAnswer = new Label();
        vbox.getChildren().addAll(divider12, question2label, q2Radio1, q2Radio2, q2Radio3, q2Radio4, q2Radio5);

        Label divider23 = new Label("----------------------------------------------------------------------------");

        // Question 3
        Label question3Label = new Label(
                "3) Out of all of the following options,"
                        + "what can you use to help you create a secure password?");
        question3Label.setStyle("-fx-font-weight: bold;");
        RadioButton q3Radio1, q3Radio2, q3Radio3, q3Radio4;
        q3Radio1 = new RadioButton("a) your personal information");
        q3Radio2 = new RadioButton("b) your family's personal information");
        q3Radio3 = new RadioButton("c) a password generator");
        q3Radio4 = new RadioButton("d) a password generator with encryption");
        ToggleGroup question3 = new ToggleGroup();
        q3Radio1.setToggleGroup(question3);
        q3Radio2.setToggleGroup(question3);
        q3Radio3.setToggleGroup(question3);
        q3Radio4.setToggleGroup(question3);
        Label q3LabelQuestionFeed = new Label();
        Label q3LabelAnswer = new Label();
        vbox.getChildren().addAll(divider23, question3Label, q3Radio1, q3Radio2, q3Radio3, q3Radio4);

        // Divider between questions 3 and 4
        Label divider34 = new Label("----------------------------------------------------------------------------");

        // Question 4
        Label question4Label = new Label(
                "4) True/False: You should NOT give your password to anyone you know.");
        question4Label.setStyle("-fx-font-weight: bold;");
        RadioButton q4Radio1, q4Radio2;
        q4Radio1 = new RadioButton("a) False");
        q4Radio2 = new RadioButton("b) True");
        ToggleGroup question4 = new ToggleGroup();
        q4Radio1.setToggleGroup(question4);
        q4Radio2.setToggleGroup(question4);
        Label q4LabelQuestionFeed = new Label();
        Label q4LabelAnswer = new Label();
        vbox.getChildren().addAll(divider34, question4Label, q4Radio1, q4Radio2);

        Button submitButton = new Button("Submit");
        Button exitGame2Button = new Button("Exit");

        submitButton.setOnAction(event -> {
            // Logic for Question 1
            boolean isq1Correct = quest1choice1CheckBox.isSelected() && quest1choice2CheckBox.isSelected()
                    && quest1choice4CheckBox.isSelected() && !quest1choice3CheckBox.isSelected()
                    && !quest1choice5CheckBox.isSelected();
            if (isq1Correct) {
                q1LabelQuestionFeed.setText("Question 1");
                q1LabelQuestionFeed.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");
                q1LabelAnswer
                        .setText("Correct!" + "According to most websites these are the most commonly used passwords.");
                q1LabelAnswer.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
            } else {
                q1LabelQuestionFeed.setText("Question 1");
                q1LabelQuestionFeed.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");
                q1LabelAnswer.setText("Wrong!" + "\nCorrect Answers: a, b, d"
                        + "\nJust search most commonly used passwords on the internet.");
                q1LabelAnswer.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            }
            // Logic for Question 2
            boolean isq2Correct = q2Radio5.isSelected();
            if (isq2Correct) {
                q2LabelQuestionFeed.setText("Question 2");
                q2LabelQuestionFeed.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");
                q2LabelAnswer.setText("Correct!"
                        + "\nThe more complex and diverse a password, the longer it takes for hackers to crack your password");
                q2LabelAnswer.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
            } else {
                q2LabelQuestionFeed.setText("Question 2");
                q2LabelQuestionFeed.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");
                q2LabelAnswer.setText("Wrong!" + "\nCorrect answer: e"
                        + "\nIf you only use one type of character then consider your account(s) gone.");
                q2LabelAnswer.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            }
            // Logic for Question 3
            boolean isq3Correct = q3Radio4.isSelected();
            if (isq3Correct) {
                q3LabelQuestionFeed.setText("Question 3");
                q3LabelQuestionFeed.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");
                q3LabelAnswer.setText("Correct"
                        + "\nPassword generators can generate secure passwords. Using an encrypted password generator makes it unreadble to unwanted nosey people.");
                q3LabelAnswer.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
            } else {
                q3LabelQuestionFeed.setText("Question 3");
                q3LabelQuestionFeed.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");
                q3LabelAnswer.setText("Wrong!" + "\nCorrect answer: d"
                        + "Nowadays, most people put their personal information online. Which anyone can just look up and try to brute force your password on your accounts");
                q3LabelAnswer.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            }
            // Logic for Question 4
            boolean isq4Correct = q4Radio2.isSelected();
            if (isq4Correct) {
                q4LabelQuestionFeed.setText("Question 4");
                q4LabelQuestionFeed.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");
                q4LabelAnswer.setText(
                        "Correct" + "\nBecause giving out your password can increase the chance of Identity Theft");
                q4LabelAnswer.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
            } else {
                q4LabelQuestionFeed.setText("Question 4");
                q4LabelQuestionFeed.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");
                q4LabelAnswer.setText("Wrong!" + "\nCorrect answer: b"
                        + "\nBecause the person you give your password to can do whatever it is they want with it."
                        + "You have no control over their actions");
                q4LabelAnswer.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            }
        });

        exitGame2Button.setOnAction(e -> {
            MainMenu menuMain = new MainMenu();
            menuMain.start(primaryStage);
        });

        vbox.getChildren().addAll(submitButton, exitGame2Button, q1LabelQuestionFeed, q1LabelAnswer,
                q2LabelQuestionFeed, q2LabelAnswer, q3LabelQuestionFeed, q3LabelAnswer, q4LabelQuestionFeed,
                q4LabelAnswer);

        Scene scenes = new Scene(vbox, 560, 560);
        primaryStage.setScene(scenes);
        primaryStage.show();
        return vbox;
    }

    // Create settings pane
    private TitledPane createSettingsPane() {
        ComboBox<Double> fontSizeComboBox = new ComboBox<>();
        fontSizeComboBox.getItems().addAll(12.0, 14.0, 16.0, 18.0, 20.0, 22.0); // Add more options if needed
        fontSizeComboBox.setValue(16.0); // Default font size

        ComboBox<String> fontComboBox = new ComboBox<>();
        fontComboBox.getItems().addAll("Arial", "Times New Roman", "Verdana",
                "Calibri", "Helvetica", "Tahoma", "OpenDyslexic");
        fontComboBox.setValue("Verdana");

        // Update font size when user selects an option
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