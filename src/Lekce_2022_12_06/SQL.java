package Lekce_2022_12_06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQL {
    private static final String USER = "JSveda";
    private static final String PASSWORD = "password";
    private static final String URL_STRING = "jbdc:sqllite:MacbookPro";

    public static void main(String[] args) throws SQLException {
        try(Connection con = DriverManager.getConnection(URL_STRING, USER, PASSWORD); Statement stmt = con.createStatement()) {
            // stmt.execute("INSERT INTO people(first_name, last_name) VALUES ('Jakub', 'Sveda')");


            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
