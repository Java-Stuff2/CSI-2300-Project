package Application.AboutPage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Application.MainMenu;

public class About extends Application {
        public static void main(String[] args) {
                launch(args);
                MainMenu mainMain = new MainMenu();
                mainMain.MainMenu();
        }

        @Override
        public void start(Stage primaryStage) {
                // UI Elements

                Label versionLabel = new Label("Version 1.0");
                // Project's Purpose & Features
                Label ppurposeLabel = new Label("Project's Purpose & Features");
                ppurposeLabel.setStyle("-fx-font: 18 Verdana; -fx-font-weight: bold;");
                Label purposeBlurLabel = new Label(
                                "The purpose of this application is to help people create secure passwords."
                                                + "It will be used for educational purposes."
                                                + "\nI wanted to bulid this application was built to get hands-on experience in coding projects related to my field.");
                Label featureLabel = new Label("Features: ");
                featureLabel.setStyle("-fx-font: 16 Verdana; -fx-font-weight: bold;");
                Label blurbFeaturLabel = new Label(
                                "\t•Font Size Adjuster- it allows the user to adjust the size of the font within each Mode.");
                Label blurbFeatur1Label = new Label(
                                "\t• Font Style Changer-it allows the user to change the font within each Mode.");
                Label modeLabel = new Label("\t• Modes");
                modeLabel.setStyle("-fx-font: 14 Verdana; -fx-font-weight: bold;");
                Label modelBlurLabel = new Label(
                                "\t\to Trivia Quiz- tests your knowledge of secure password practices with explanations."
                                                + "\n\t\t\tUsers can see the explanations when they click on the “Submit” button.");

                Label modelBlur1Label = new Label(
                                "\t\toPassword Checker- A hands-on experience in making a password."
                                                + "\n\t\t\tUsers can test their passwords in the password field and check their passwords by clicking on the “Validate” button."
                                                + "\n\t\t\tBy clicking on the “Validate” button, it will display tips on how to make your passwords strong.");
                // Divider for Project Stuff
                Label divider1Label = new Label(
                                "----------------------------------------------------------------------------------------------------------------------------------");
                Label ProjectNameLabel = new Label("Project name: Password Validate");
                ProjectNameLabel.setStyle("-fx-font: 14 Verdana; -fx-font-weight: bold;");
                Label teamNameLabel = new Label("Team name: MypasswrdisN0T1234");
                teamNameLabel.setStyle("-fx-font: 14 Verdana; -fx-font-weight: bold;");
                Label teamMemberLabel = new Label("Team member: Iyana Fortia");
                teamMemberLabel.setStyle("-fx-font: 14 Verdana; -fx-font-weight: bold;");
                Label rolesLabel = new Label("\tRoles:");
                rolesLabel.setStyle("-fx-font: 14 Verdana; -fx-font-weight: bold;");
                Label theRolesLabels = new Label(
                                "\t\tCoding" + "\t\tTesting & Debugging" + "\t\tStyling & Theming"
                                                + "\t\tQuality Assurance (QA)");
                // Divider for Credits
                Label divider2Label = new Label(
                                "---------------------------------------------------------------------------------------------------------------------------------");
                Label creditLabel = new Label("Credit");
                creditLabel.setStyle("-fx-font: 18 Verdana; -fx-font-weight: bold;");
                Label creditsResourcesLabel = new Label("\tResources:");
                creditsResourcesLabel.setStyle("-fx-font: 14 Verdana; -fx-font-weight: bold;");
                Label resourceAI1Label = new Label(
                                "\t\t• Bing AI Chat- used for project ideas, as a basis for formatting each scene, making the settings collapse menu.");
                Label resourceAI2Label = new Label("\t\t• ChatGPT- used for help on making the collapse menu.");
                Label creditBackgrndLabel = new Label("Background:");
                creditBackgrndLabel.setStyle("-fx-font: 14 Verdana; -fx-font-weight: bold;");
                Label BackgrndAppLabel = new Label(" Background for Application Stage Title: Password Validate");
                BackgrndAppLabel.setStyle("-fx-font-weight: bold;");
                TextField appLink = new TextField(
                                "https://www.freepik.com/free-vector/abstract-realistic-technology-particle-background_6849387.htm#fromView=search&page=1&position=49&uuid=6fe8d345-f26b-4e7a-9b4d-ce424cf8e976");
                appLink.setEditable(false);
                Label BackgrndMainLabel = new Label(" Background for Application Stage Title: Main Menu");
                BackgrndMainLabel.setStyle("-fx-font-weight: bold;");
                TextField mainMenuTextField = new TextField(
                                "https://www.freepik.com/free-vector/abstract-technology-particle-background_5617352.htm#fromView=search&page=1&position=0&uuid=6fe8d345-f26b-4e7a-9b4d-ce424cf8e976");
                mainMenuTextField.setEditable(false);
                Label BackgrndTriviaLabel = new Label("Background for Application Stage Title: TriviaGame");
                BackgrndTriviaLabel.setStyle("-fx-font-weight: bold;");
                TextField trivTextField = new TextField(
                                " https://www.freepik.com/free-vector/question-marks-background_50417664.htm#fromView=search&page=1&position=18&uuid=c72a3c9d-7a94-4f4c-96ce-c72c8f3a8515");
                trivTextField.setEditable(false);

                Label divider3Label = new Label(
                                "---------------------------------------------------------------------------------------------------------------------------------");
                Label naviLabel = new Label("Navigation");
                naviLabel.setStyle("-fx-font: 18 Verdana; -fx-font-weight: bold;");

                Button NaviButton = new Button("Main Menu");
                NaviButton.setStyle(" -fx-font: 14 Verdana; -fx-font-weight: bold;");
                NaviButton.setOnAction(e -> {
                        MainMenu menuMenu = new MainMenu();
                        menuMenu.start(primaryStage);
                });
                Label authorLabel = new Label("Author: Iyana Fortia");

                // Arrange elements in a VBox
                VBox root = new VBox(10); // 10 is the spacing between elements
                ScrollPane sidebar = new ScrollPane();
                sidebar.setContent(root);

                root.getChildren().addAll(versionLabel, ppurposeLabel, purposeBlurLabel, featureLabel,
                                blurbFeaturLabel, blurbFeatur1Label, modeLabel, modelBlurLabel, modelBlur1Label,
                                divider1Label,
                                ProjectNameLabel, teamNameLabel, teamMemberLabel, rolesLabel, theRolesLabels,
                                divider2Label, creditLabel, resourceAI1Label, resourceAI2Label, creditBackgrndLabel,
                                BackgrndAppLabel,
                                appLink, BackgrndMainLabel, mainMenuTextField, BackgrndTriviaLabel, trivTextField,
                                divider3Label,
                                naviLabel, NaviButton,
                                authorLabel);

                // Create the scene
                Scene scene = new Scene(sidebar, 740, 600); // Set preferred width and height

                // Set scene and show the stage
                primaryStage.setTitle("About My App");
                primaryStage.setScene(scene);
                primaryStage.show();

        }

        public void About() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'About'");
        }

}
