package com.example.duckco.repository;

import com.example.duckco.db.MySqlDatabase;
import com.example.duckco.model.AuthDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {

    private MySqlDatabase db;

    public UserRepository() {
        db = MySqlDatabase.getInstance();
    }

    public AuthDetails getUser(String username, String password) {
        AuthDetails user;
        Connection conn = db.getConnection();
        String sql = "" +
                "SELECT * FROM user " +
                "WHERE userName = ? AND password = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            if (!rs.next()) {
                return null;
            }

            user = new AuthDetails();
            user.setUsername(rs.getString("userName"));
            user.setPassword(rs.getString("password"));
            user.setId(rs.getInt("userId"));


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }
}