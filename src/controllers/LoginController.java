/*
 * xu ly dang nhap
 */
package controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utilities.MysqlConnection;

/**
 *
 * @author Loc Nguyen
 */
public class LoginController {

    public boolean login(String username, String pass) throws SQLException, ClassNotFoundException {
        try ( Connection connection = MysqlConnection.getMysqlConnection();  Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM users WHERE username = '" + username + "'");
            if (rs == null) {
                return false;
            }
            while (rs.next()) {
                if (rs.getString("pass").equals(pass)) {
                    return true;
                }
            }
        }
        return false;
    }
}
