package mdigius.uno.Adapters;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mdigius.uno.Player;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PlayerAdapter {
    Connection conn;
    private DerbyAdapter derbyAdapter;
    private String[] columns;
    public PlayerAdapter(Connection conn, Boolean reset) throws SQLException {
        columns = new String[]{"Name", "Coins", "Wins", "Losses"};
        derbyAdapter = new DerbyAdapter(conn);
        this.conn = conn;
        if (reset) {
            Statement stmt = conn.createStatement();
            try {
                // Remove tables if database tables have been created.
                // This will throw an exception if the tables do not exist
                stmt.execute("DROP TABLE Players");
                // then do finally
            } catch (SQLException ex) {
                // No need to report an error.
                // The table simply did not exist.
                // do finally to create it
            }
            derbyAdapter.createTable("Players", columns);
            populateSamples();
        }
    }
    public void populateSamples() throws SQLException {
        // Add code to populate default
    }
    public void insertPlayer(String name) throws SQLException {
        String[] values = new String[]{name, String.valueOf(0), String.valueOf(0), String.valueOf(0)};
        derbyAdapter.addRecord("Players", columns, values);
    }
    public void deletePlayer(String name) throws SQLException {
        derbyAdapter.deleteRecord("Players", "Name", name);
    }
    public void updatePlayer(String column, String value, String checkedColumn, String checkedValue) throws SQLException {
        derbyAdapter.updateRecord("Players", column, value, checkedColumn, checkedValue);
    }
    public ResultSet getPlayerResult(String column, String value) throws SQLException {
        ResultSet rs = derbyAdapter.findRecord("Players", column, value);
        return rs;

    }
    public Player getPlayer(String name) throws SQLException {
        String sql = "SELECT * FROM Players WHERE Name = '" + name + "'";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        Player player = null;
        while (rs.next()) {
            player = new Player(rs.getString(1));
            player.setCoins(rs.getInt(2));
            player.setWins(rs.getInt(3));
            player.setLosses(rs.getInt(4));
        }
        return player;
    }

    public ObservableList<Player> getPlayersList() throws SQLException {
        ObservableList<Player> playersList = FXCollections.observableArrayList();
        // SQL statement to select all columns from the Players table
        String sqlStatement = "SELECT * FROM Players";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sqlStatement);
        // While the result set has a next row, create a new Player object with all of its information in the column
        while (rs.next()) {
            Player player = new Player(rs.getString(1));
            player.setCoins(rs.getInt(2));
            player.setWins(rs.getInt(3));
            player.setLosses(rs.getInt(4));
            playersList.add(player);
        }
        return playersList;
    }
}
