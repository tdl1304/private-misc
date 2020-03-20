package Oblig4B;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MemberUI extends Application {

    public static Logger logger = Logger.getLogger("Member system");
    MemberArchive memberArchive = new MemberArchive();
    private final ObservableList<Personals> data = FXCollections.observableArrayList();
    Scene mainScene = new Scene(new Group());
    TableView tableView = new TableView();
    TableSelectionModel<Personals> tableSelectionModel = tableView.getSelectionModel();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            // --- init --- \\
            refresh();
            primaryStage.setResizable(false);
            tableSelectionModel.setSelectionMode(SelectionMode.SINGLE);
            // --- Buttons --- \\
            Button addNewMember = new Button("Add a new member");
            addNewMember.setOnAction(actionEvent -> {
                addNewMember(primaryStage);
            });

            Button deleteMember = new Button("Delete selected");
            deleteMember.setOnAction(ActionEvent -> {
                try {
                    deleteMemberFromSelected();
                } catch (IOException e) {
                    log(Level.WARNING, e.getStackTrace().toString());
                }
            });

            Button autoUpgrade = new Button("Upgrade members");
            autoUpgrade.setOnAction(event -> {
                try {
                    autoUpgradeMembers();
                } catch (IOException e) {
                    log(Level.WARNING, e.getStackTrace().toString());
                }
            });

            // --- Table --- \\
            final Label label = new Label("Memberlist");
            label.setFont(new Font("Arial", 20));

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
            //--- TextBox ---\\
            TextArea information = new TextArea();
            information.setPrefWidth(130);
            information.setEditable(false);
            tableView.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
                if (!tableSelectionModel.isEmpty()) {
                    information.setText(memberArchive.findMember(tableSelectionModel.getSelectedItem()).toString());
                }
            });
            //--- (Containers) Boxes ---\\
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
            vbox2.getChildren().addAll(addNewMember, deleteMember, autoUpgrade, information);

            //--- End --- //
            ((Group) mainScene.getRoot()).getChildren().addAll(hbox);
            homePage(primaryStage);
            primaryStage.show();
        } catch (Exception e) {
            log(Level.WARNING, e.getStackTrace().toString());
        }
    }


    /**
     * Gir oppdatert medlemsliste
     *
     * @throws IOException
     */
    private ArrayList<BonusMember> updateMemberList() throws IOException {
        ArrayList<String[]> saveData = BonusMember.readMembers();
        ArrayList<BonusMember> members = new ArrayList<>();
        saveData.forEach(x -> members.add(BonusMember.readFormattedSaveData(x)));
        return members;
    }

    //Updates memberlist from savefile, also checks for duplicates
    private void updateMembers() throws IOException {
        memberArchive.getMemberList().clear();
        updateMemberList().forEach(x -> {
            memberArchive.addToList(x);
        });
    }

    //Updates table from memberlist
    private void updateTable() {
        data.clear();
        for (BonusMember bonusMember : memberArchive.getMemberList()) {
            data.add(bonusMember.getPersonals());
        }
    }

    //Updates memberlist, then updates table
    private void refresh() throws IOException {
        updateMembers();
        updateTable();
    }

    private void deleteMemberFromSelected() throws IOException {
        if (!tableSelectionModel.isEmpty()) {
            memberArchive.deleteMember(memberArchive.findMember(tableSelectionModel.getSelectedItem()));
            refresh();
        }
    }

    private void autoUpgradeMembers() throws IOException {
        memberArchive.checkMembers();
        refresh();
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
                log(Level.WARNING, e.getStackTrace().toString());
            } finally {
                homePage(stage);
            }
        }));


        register.setOnAction(actionEvent -> {
            int id = 0;
            try {
                id = memberArchive.newMember(new Personals(firstname.getText(), surname.getText(), email.getText(), password.getText()));
                if (id != -1) {
                    BonusMember.savePersonals(memberArchive.findMember(id));
                    alertMessage("Member is registered as a basic member");
                    refresh();
                    homePage(stage);
                } else {
                    log(Level.WARNING, "Instance of BonusMember already exist");
                    alertMessage("Member already exists!");
                }
            } catch (IllegalArgumentException e) {
                log(Level.WARNING, "Bad input");
                alertMessage("Please fill out all the blanks");
            } catch (IOException e) {
                log(Level.WARNING, e.getStackTrace().toString());
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

    public static void log(Level level, String message) {
        logger.log(level, message);
    }

    private void alertMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
