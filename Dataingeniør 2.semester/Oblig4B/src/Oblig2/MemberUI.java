package Oblig2;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import static Oblig2.BonusMember.*;

import javax.management.InstanceAlreadyExistsException;
import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MemberUI extends Application {

    Logger logger = Logger.getLogger("MemberUI");
    MemberArchive memberArchive = new MemberArchive();
    private final ObservableList<Personals> data = FXCollections.observableArrayList();
    Scene mainScene = new Scene(new Group());


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            // --- init ---
            refresh();
            primaryStage.setResizable(false);
            // --- Buttons ---
            Button addNewMember = new Button("Add a new member");
            addNewMember.setOnAction((actionEvent -> {
                addNewMember(primaryStage);
            }));

            // --- Table ---
            TableView tableView = new TableView();

            final Label label = new Label("Memberlist");
            label.setFont(new Font("Arial", 20));

            tableView.setEditable(true);
            TableColumn firstNameCol = new TableColumn("First Name");
            firstNameCol.setCellValueFactory(
                    new PropertyValueFactory<Personals, String>("firstname"));

            TableColumn lastNameCol = new TableColumn("Last Name");
            lastNameCol.setCellValueFactory(
                    new PropertyValueFactory<Personals, String>("surname"));

            TableColumn emailCol = new TableColumn("Email");
            emailCol.setCellValueFactory(
                    new PropertyValueFactory<Personals, String>("email"));

            tableView.setItems(data);
            tableView.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
            tableView.setPrefWidth(330);
            //--- (Containers) Boxes ---
            final VBox vbox1 = new VBox();
            final VBox vbox2 = new VBox();
            final HBox hbox = new HBox();

            vbox1.setSpacing(5);
            vbox1.setPadding(new Insets(10, 0, 0, 10));

            vbox2.setSpacing(5);
            vbox2.setPadding(new Insets(10));
            vbox2.setPadding(new Insets(38, 0, 0, 15));

            hbox.getChildren().addAll(vbox1, vbox2);
            vbox1.getChildren().addAll(label, tableView);
            vbox2.getChildren().addAll(addNewMember);

            //--- End ---
            ((Group) mainScene.getRoot()).getChildren().addAll(hbox);
            homePage(primaryStage);
            primaryStage.show();
        } catch (Exception e) {
            log(Level.WARNING, e.getMessage());
        }
    }


    /**
     * Gir oppdatert medlemsliste
     *
     * @throws IOException
     */
    private ArrayList<BonusMember> updateMemberList() throws IOException {
        ArrayList<String[]> saveData = readMembers();
        ArrayList<BonusMember> members = new ArrayList<>();
        saveData.forEach(x -> members.add(readFormattedSaveData(x)));
        return members;
    }

    private void updateMembers() throws IOException {
        updateMemberList().forEach(x -> {
            memberArchive.addToList(x);
        });
    }

    private void updateTable() {
        data.clear();
        for (BonusMember bonusMember : memberArchive.getMemberList()) {
            data.add(bonusMember.getPersonals());
        }
    }

    private void refresh() throws IOException {
        updateMembers();
        updateTable();
    }

    private void addNewMember(Stage stage) {
        Scene newMember = new Scene(new Group());
        TextField firstname = new TextField();
        TextField surname = new TextField();
        TextField email = new TextField();
        TextField password = new TextField();
        Button register = new Button("Register");
        Button cancel = new Button("Cancel");

        firstname.setPromptText("Firstname");
        firstname.setPadding(new Insets(5));
        surname.setPromptText("Surname");
        surname.setPadding(new Insets(5));
        email.setPromptText("Email");
        email.setPadding(new Insets(5));
        password.setPromptText("Password");
        password.setPadding(new Insets(5));

        cancel.setOnAction((actionEvent -> {
            try {
                refresh();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                homePage(stage);
            }
        }));


        register.setOnAction(actionEvent -> {
            int id = memberArchive.newMember(new Personals(firstname.getText(), surname.getText(), email.getText(), password.getText()));
            try {
                if (id != -1) {
                    savePersonals(memberArchive.findMember(id));
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Member is registered as a Basic member");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Member already exists!");
                    alert.showAndWait();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(firstname, surname, email, password, register, cancel);
        ((Group) newMember.getRoot()).getChildren().addAll(vbox);
        stage.setWidth(200);
        stage.setHeight(300);
        stage.setScene(newMember);
    }

    private void homePage(Stage stage) {
        stage.setTitle("Member system");
        stage.setWidth(500);
        stage.setHeight(600);
        stage.setScene(mainScene);
    }

    private void log(Level level, String message) {
        logger.log(level, message);
    }
}
