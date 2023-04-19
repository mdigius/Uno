package mdigius.uno.Adapters;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class DerbyAdapter {
    Connection conn;
    public DerbyAdapter(Connection conn) throws SQLException {
        this.conn = conn;
    }

    public void createTable(String tableName, String[] columns) throws SQLException {
        // Starts to create the query string using the table name
        String sql = "CREATE Table " + tableName + " (";
        // For each column in the columns String array, it will create new column with its name
        // that holds a varchar object
        boolean bool = true;
        for (String column : columns){
            if(bool) {
                sql += column + " VARCHAR(100) NOT NULL PRIMARY KEY, ";
                bool = false;
            } else{
                sql += column + " VARCHAR(100), ";
            }

        }
        // Replaces the last comma with a bracket
        sql = sql.substring(0, sql.length() - 2) + ")";
        // Creates a statement object and executes the query
        Statement stmt = conn.createStatement();
        System.out.println(sql);
        stmt.executeUpdate(sql);
    }
    public void addRecord(String tableName, String[] columns, String[] values) throws SQLException {
        String sql = "INSERT INTO " + tableName + " (";
        for(String column: columns){
            sql += column + ", ";
        }
        // Replaces the last comma with a bracket
        sql = sql.substring(0, sql.length() - 2) + ") VALUES (";
        for(String value : values){
            sql += "'" + value + "', ";
        }
        sql = sql.substring(0, sql.length() - 2) + ")";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }
    public ResultSet findRecord(String tableName, String column, String value) throws SQLException {
        // Creates a statement to select rows in which the value in a specific
        // column is equal to what is passed into the function
        String sql = "SELECT * FROM " + tableName + " WHERE " + column + " = '" + value + "'";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }

    public void updateRecord(String tableName, String column, String value, String checkedColumn, String checkedValue) throws SQLException {
        // Creates a statement to set the value for a column in which a column has a certain value
        String sql = "UPDATE " + tableName + " SET " + column + " = '" + value + "' WHERE " +
                checkedColumn + " = '" + checkedValue + "'";
        // Creates a statement object and executes the update
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }

    public void deleteRecord(String tableName, String column, String value) throws SQLException {
        String sql = "DELETE FROM " + tableName + " WHERE " + column + " ='" + value + "'";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }






}

