package mdigius.uno.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import mdigius.uno.Adapters.PlayerAdapter;
import mdigius.uno.Player;

import java.sql.SQLException;

public class DeleteUserController {

    @FXML
    private Button cancelBtn;

    @FXML
    private ComboBox<Player> userCombo;
    private PlayerAdapter pAdapter;
    private UnoController uController;

    public void setModel(UnoController uController, PlayerAdapter pAdapter) throws SQLException {
        this.uController = uController;
        this.pAdapter = pAdapter;
        buildComboBox();
    }
    public void buildComboBox() throws SQLException {
        userCombo.setItems(pAdapter.getPlayersList());
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
    void onDelete(ActionEvent event) throws SQLException {
        if(userCombo.getSelectionModel().getSelectedItem()!=null){
            pAdapter.deletePlayer(userCombo.getSelectionModel().getSelectedItem().getName());
            onCancel();
        }

    }

}
