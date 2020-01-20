package project1;
import java.io.Serializable;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import project1.antlr4.MyRulesBaseVisitor;
import project1.antlr4.RulesLexer;
import project1.antlr4.RulesParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Main extends Application implements Serializable  {
    public static void main(String[] args) throws FileNotFoundException {
        /*
        File file = new File("src/project1/input.txt");
        Scanner scanner = new Scanner(file);
        List<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.length() != 0) { lines.add(line); }
        }
        MyRulesBaseVisitor visitor = new MyRulesBaseVisitor();
        for (String line : lines) {
            CharStream charStream = CharStreams.fromString(line);
            RulesLexer lexer = new RulesLexer(charStream);
            CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
            RulesParser parser = new RulesParser(commonTokenStream);

            RulesParser.ProgramContext programContext = parser.program();
            visitor.visit(programContext);
        }*/

        //Dbms myDbms = new Dbms();
        Application.launch(args);
   }

    @Override
    public void start(Stage stage) throws Exception {
        //stage.setTitle("Application Probs");
        //stage.show();

        // Declaring Labels for messages
        Dbms myDbms = new Dbms();
        Label userSelectionMsgLbl = new Label("Your selection: ");
        Label userSelectionDataLbl = new Label("");

        Label queriesLbl = new Label("Queries:  ");

        // Create the ComboBox
        final ComboBox<String> queriesBox = new ComboBox<>();
        queriesBox.getItems().addAll("Please select a query to preform...","Bacon Number","Constellation of Co-Stars","Typecasting","Cover Roles","Best of Days, Worst of Days");
        queriesBox.getSelectionModel().selectFirst();

        GridPane root2 = new GridPane();
        //HBox for text boxes
        HBox textualHealing = new HBox();

        final TextArea textArea = new TextArea();
        textArea.setWrapText(true);
        //enable output textbox to scroll
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(textArea);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefWidth(600);
        scrollPane.setPrefHeight(150);
        HBox outputBox = new HBox();
        outputBox.getChildren().addAll(scrollPane);
        outputBox.setVisible(false);

        //create button to read in strings from input text box
        Button b = new Button("Submit");
        HBox submitButton = new HBox();
        submitButton.getChildren().addAll(b);
        submitButton.setVisible(false);

        // Update the message Label when the value changes
        queriesBox.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {

                String Query = queriesBox.getValue();
                userSelectionDataLbl.setText(Query);
                String selection = queriesBox.getValue();
                switch (selection)
                {
                    case "Bacon Number":
                        textualHealing.getChildren().clear();
                        Label actorName1=new Label("Name of an actor:  ");
                        TextField tf1=new TextField();
                        Label actorName2 = new Label("   Name of a different actor:   ");
                        TextField tf2=new TextField();

                        root2.addRow(0, actorName1, tf1);
                        root2.addRow(1, actorName2, tf2);
                        textualHealing.getChildren().addAll(root2, actorName1, tf1, actorName2, tf2);
                        submitButton.setVisible(true);
                        outputBox.setVisible(true);
                        b.setOnAction(q->textArea.setText("TODO Implement: You entered: bacon: "+tf1.getText()+"   "+" other bacon: "+tf2.getText()));
                        break;

                    case "Constellation of Co-Stars":
                        textualHealing.getChildren().clear();
                        Label actorNameCo=new Label("Name of an actor:  ");
                        TextField tf1Co=new TextField();
                        Label costarNum = new Label("   Number of co-star appearances:   ");
                        TextField tf2Co=new TextField();
                        root2.addRow(0, actorNameCo, tf1Co);
                        root2.addRow(1, costarNum, tf2Co);
                        textualHealing.getChildren().addAll(root2, actorNameCo, tf1Co, costarNum, tf2Co);
                        submitButton.setVisible(true);
                        outputBox.setVisible(true);
                        b.setOnAction(t->textArea.setText((myDbms.conOfCoStars(tf1Co.getText(), Integer.parseInt(tf2Co.getText()))).toString()));
                        break;

                    case "Typecasting":
                        textualHealing.getChildren().clear();
                        Label actorNameType=new Label("Name of an actor:  ");
                        TextField tf1Type=new TextField();

                        root2.addRow(0, actorNameType, tf1Type);
                        textualHealing.getChildren().addAll(root2, actorNameType, tf1Type);
                        submitButton.setVisible(true);
                        outputBox.setVisible(true);
                        b.setOnAction(r->textArea.setText(myDbms.typecasting(tf1Type.getText())));
                        break;

                    case "Cover Roles":
                        textualHealing.getChildren().clear();
                        Label charName1=new Label("Name of a character:  ");
                        TextField tf1Char=new TextField();

                        root2.addRow(0, charName1, tf1Char);
                        textualHealing.getChildren().addAll(root2, charName1, tf1Char);
                        submitButton.setVisible(true);
                        outputBox.setVisible(true);

                        //print every string in vector of string
                        b.setOnAction(t->textArea.setText((myDbms.coverRoles(tf1Char.getText())).toString()));
                        break;

                    case "Best of Days, Worst of Days":
                        textualHealing.getChildren().clear();
                        Label actorNameBest=new Label("Name of an actor:  ");
                        TextField tf1Best=new TextField();

                        root2.addRow(0, actorNameBest, tf1Best);

                        textualHealing.getChildren().addAll(root2, actorNameBest, tf1Best);
                        submitButton.setVisible(true);
                        outputBox.setVisible(true);
                        b.setOnAction(y->textArea.setText(myDbms.bodWod(tf1Best.getText())));
                        break;
                }

            }
        });

        // Create the HBox for the Months
        HBox monthBox = new HBox();
        monthBox.getChildren().addAll(queriesLbl, queriesBox);

        // Create the HBox for the Dropdown
        HBox selectionBox = new HBox();
        selectionBox.getChildren().addAll(userSelectionMsgLbl, userSelectionDataLbl);

        // Create the VBox for all of the Hboxes
        VBox root = new VBox();
        root.getChildren().addAll(monthBox, selectionBox, textualHealing, submitButton, outputBox );



        // Set the Style-properties of the VBox
        root.setSpacing(15);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: Grey;");

        // Create the Scene, add the stage and display
        Scene scene = new Scene(root,625,400);
        stage.setScene(scene);
        stage.setTitle("Movie Database");
        stage.show();



    }

}
