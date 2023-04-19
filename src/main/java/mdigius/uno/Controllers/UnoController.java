package mdigius.uno.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mdigius.uno.Adapters.PlayerAdapter;
import mdigius.uno.Player;
import mdigius.uno.UnoApplication;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UnoController implements Initializable {
    @FXML
    private MenuBar mainMenu;
    @FXML
    private Menu userMenu;
    @FXML
    private Menu playMenu;
    private Player currentPlayer;
    Connection conn;

    @FXML
    void onClose(ActionEvent event) {
        // Get current stage reference
        Stage stage = (Stage) mainMenu.getScene().getWindow();
        // Close stage
        stage.close();
    }
    public Player getCurrentPlayer(){
        return currentPlayer;
    }

    public void setCurrentPlayer(Player player){
        currentPlayer = player;
        userMenu.setText(currentPlayer.getName());
        userMenu.setVisible(true);
        playMenu.setVisible(true);
    }

    @FXML
    void onCreateUser(ActionEvent event) throws IOException, SQLException {
        // load the fxml file (the UI elements)
        FXMLLoader fxmlLoader = new FXMLLoader(UnoApplication.class.getResource("CreateUser-view.fxml"));
        // create the root node
        Parent scene = fxmlLoader.load();
        CreateUserController createUserController = (CreateUserController) fxmlLoader.getController();
        PlayerAdapter pAdapter = new PlayerAdapter(conn, false);
        createUserController.setModel(this, pAdapter);
        // create new stage
        Stage stage = new Stage();
        stage.setScene(new Scene(scene));
        // add icon to the window
        stage.getIcons().add(new Image("file:src/main/resources/mdigius/uno/imgs/icons/UnoIcon.jpg"));
        stage.setTitle("Create User!");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void onLogin(ActionEvent event) throws IOException, SQLException {
        // load the fxml file (the UI elements)
        FXMLLoader fxmlLoader = new FXMLLoader(UnoApplication.class.getResource("Login-view.fxml"));
        // create the root node
        Parent scene = fxmlLoader.load();
        LoginController loginController = (LoginController) fxmlLoader.getController();
        PlayerAdapter pAdapter = new PlayerAdapter(conn, false);
        loginController.setModel(this, pAdapter);
        // create new stage
        Stage stage = new Stage();
        stage.setScene(new Scene(scene));
        // add icon to the window
        stage.getIcons().add(new Image("file:src/main/resources/mdigius/uno/imgs/icons/UnoIcon.jpg"));
        stage.setTitle("Login!");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();

    }
    @FXML
    void onDelete(ActionEvent event) throws IOException, SQLException {
        // load the fxml file (the UI elements)
        FXMLLoader fxmlLoader = new FXMLLoader(UnoApplication.class.getResource("DeleteUser-view.fxml"));
        // create the root node
        Parent scene = fxmlLoader.load();
        DeleteUserController deleteUserController = (DeleteUserController) fxmlLoader.getController();
        PlayerAdapter pAdapter = new PlayerAdapter(conn, false);
        deleteUserController.setModel(this, pAdapter);
        // create new stage
        Stage stage = new Stage();
        stage.setScene(new Scene(scene));
        // add icon to the window
        stage.getIcons().add(new Image("file:src/main/resources/mdigius/uno/imgs/icons/UnoIcon.jpg"));
        stage.setTitle("Delete User!");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    void onPlay() throws SQLException, IOException {
        // load the fxml file (the UI elements)
        FXMLLoader fxmlLoader = new FXMLLoader(UnoApplication.class.getResource("LetsPlay-view.fxml"));
        // create the root node
        Parent scene = fxmlLoader.load();
        LetsPlayController letsPlayController = (LetsPlayController) fxmlLoader.getController();
        PlayerAdapter pAdapter = new PlayerAdapter(conn, false);
        letsPlayController.setModel(this, pAdapter);
        // create new stage
        Stage stage = new Stage();
        stage.setScene(new Scene(scene));
        // add icon to the window
        stage.getIcons().add(new Image("file:src/main/resources/mdigius/uno/imgs/icons/UnoIcon.jpg"));
        stage.setTitle("Play Uno!");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();

    }
    @FXML
    void onStats(ActionEvent event) throws IOException, SQLException {
        // load the fxml file (the UI elements)
        FXMLLoader fxmlLoader = new FXMLLoader(UnoApplication.class.getResource("Stats-view.fxml"));
        // create the root node
        Parent scene = fxmlLoader.load();
        StatsController statsController = (StatsController) fxmlLoader.getController();
        PlayerAdapter pAdapter = new PlayerAdapter(conn, false);
        statsController.setModel(this, pAdapter);
        // create new stage
        Stage stage = new Stage();
        stage.setScene(new Scene(scene));
        // add icon to the window
        stage.getIcons().add(new Image("file:src/main/resources/mdigius/uno/imgs/icons/UnoIcon.jpg"));
        stage.setTitle("Player Stats!");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    void onLogout(ActionEvent event) {
        currentPlayer = null;
        userMenu.setVisible(false);
        playMenu.setVisible(false);


    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            // Create a named constant for the URL
            // NOTE: This value is specific for Java DB
            String DB_URL = "jdbc:derby:Uno;create=true";
            // Create a connection to the database
            conn = DriverManager.getConnection(DB_URL);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
