package mdigius.uno.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mdigius.uno.Adapters.PlayerAdapter;

import java.sql.SQLException;

public class CreateUserController {

    @FXML
    private TextField nameField;
    @FXML
    private Button cancelBtn;
    private PlayerAdapter pAdapter;
    private UnoController uController;

    public void setModel(UnoController uController, PlayerAdapter pAdapter){
        this.uController = uController;
        this.pAdapter = pAdapter;
    }

    @FXML
    void onCancel() {
        // Get current stage reference
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        // Close stage
        stage.close();

    }

    @FXML
    void onSave() throws SQLException {
        if(nameField.getText()!=null) {
            pAdapter.insertPlayer(nameField.getText());
            onCancel();
        }

    }

}
