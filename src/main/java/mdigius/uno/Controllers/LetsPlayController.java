package mdigius.uno.Controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import mdigius.uno.Adapters.PlayerAdapter;

import java.sql.SQLException;
import java.util.ArrayList;

public class LetsPlayController {

    @FXML
    private Button cancelBtn;

    @FXML
    private ComboBox<Integer> playersCombo;
    private UnoController uController;
    private PlayerAdapter pAdapter;

    public void setModel(UnoController uController, PlayerAdapter pAdapter) throws SQLException {
        this.uController = uController;
        this.pAdapter = pAdapter;
        buildComboBox();
    }
    public void buildComboBox() throws SQLException {
        playersCombo.getItems().addAll(1,2,3);
        playersCombo.getSelectionModel().selectFirst();
    }

    @FXML
    void onCancel() {
        // Get current stage reference
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        // Close stage
        stage.close();
    }

    @FXML
    void onCombo(ActionEvent event) {

    }

    @FXML
    void onPlay(ActionEvent event) {

    }

}
