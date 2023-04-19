package mdigius.uno.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import mdigius.uno.Adapters.PlayerAdapter;
import mdigius.uno.Player;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StatsController {

    @FXML
    private Button closeBtn;

    @FXML
    private TableColumn<Player, Integer> gamesColumn = new TableColumn<>();

    @FXML
    private TableColumn<Player, Integer> lossColumn = new TableColumn<>();

    @FXML
    private TableColumn<Player, String> playerColumn = new TableColumn<>();

    @FXML
    private TableColumn<Player, Integer> winColumn = new TableColumn<>();
    @FXML
    private TableView<Player> statsTable;
    private UnoController uController;
    private PlayerAdapter pAdapter;

    public void setModel(UnoController uController, PlayerAdapter pAdapter) throws SQLException {
        this.uController = uController;
        this.pAdapter = pAdapter;
        buildStatsTable();
    }

    @FXML
    void onClose(ActionEvent event) {
        // Get current stage reference
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        // Close stage
        stage.close();
    }

    public void buildStatsTable() {
        playerColumn.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
        winColumn.setCellValueFactory(new PropertyValueFactory<Player, Integer>("wins"));
        lossColumn.setCellValueFactory(new PropertyValueFactory<Player, Integer>("losses"));
        statsTable.getItems().add(uController.getCurrentPlayer());

    }
}
