module mdigius.uno {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens mdigius.uno to javafx.fxml;
    exports mdigius.uno;
    exports mdigius.uno.Controllers;
    opens mdigius.uno.Controllers to javafx.fxml;
    exports mdigius.uno.Adapters;
    opens mdigius.uno.Adapters to javafx.fxml;
}