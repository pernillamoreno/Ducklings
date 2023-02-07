package com.example.duckco.repository;

import com.example.duckco.db.MySqlDatabase;
import com.example.duckco.model.Invoice;
import com.example.duckco.model.UserInvoice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InvoiceRepository {

    private MySqlDatabase db;

    public InvoiceRepository() {
        db = MySqlDatabase.getInstance();
    }

    public UserInvoice getInvoices(String username) {
        Connection conn = db.getConnection();
        UserInvoice userInvoices = new UserInvoice(username);
        String sql = "" +
                "SELECT * FROM invoice " +
                "JOIN user " +
                "ON invoice.userId = user.userId " +
                "WHERE user.userName = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();

            if(!rs.next()) { return userInvoices; }

            System.out.println(username);
            do {
                Invoice invoice = new Invoice();
                invoice.setInvoiceId(rs.getInt("InvoiceId"));
                invoice.setTitle(rs.getString("Title"));
                invoice.setDescription(rs.getString("Description"));
                invoice.setCategory(rs.getString("Category"));
                invoice.setAmount(rs.getInt("Amount"));

                userInvoices.getInvoices().add(invoice);
            } while(rs.next());


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return userInvoices;
    }

    public void addInvoice(int userId, Invoice invoice) {
        Connection conn = db.getConnection();

        try {
            String sql = "INSERT INTO invoice (userId, Title, Description, Category, Amount)" +
                    "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            pstmt.setString(2, invoice.getTitle());
            pstmt.setString(3, invoice.getDescription());
            pstmt.setString(4, invoice.getCategory());
            pstmt.setDouble(5, invoice.getAmount());

            pstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteInvoice(int id) {
        Connection conn = db.getConnection();
        String sql = "DELETE FROM invoice WHERE InvoiceId = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            return stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Invoice getInvoice(int id) {
        Invoice invoice = null;
        Connection conn = db.getConnection();
        String sql = "" +
                "SELECT * FROM invoice " +
                "WHERE InvoiceId = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            if(!rs.next()) { return null; }

            invoice = new Invoice();
            invoice.setInvoiceId(rs.getInt("InvoiceId"));

            invoice.setTitle(rs.getString("Title"));
            invoice.setDescription(rs.getString("Description"));
            invoice.setCategory(rs.getString("Category"));
            invoice.setAmount(rs.getInt("Amount"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return invoice;
    }

    public void updateInvoice(Invoice invoice) {
        Connection conn = db.getConnection();
        String sql = "UPDATE invoice SET Title = ?, Description = ?, Category = ?, Amount = ?"
                +" WHERE InvoiceId = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, invoice.getTitle());
            pstmt.setString(2, invoice.getDescription());
            pstmt.setString(3, invoice.getCategory());
            pstmt.setDouble(4, invoice.getAmount());
            pstmt.setInt(5, invoice.getInvoiceId());
            pstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}