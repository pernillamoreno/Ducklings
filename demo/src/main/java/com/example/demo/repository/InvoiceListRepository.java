package com.example.demo.repository;


import com.example.demo.db.MysqlDatabase;
import com.example.demo.model.InvoiceItem;
import com.example.demo.model.InvoiceList;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InvoiceListRepository {

    private MysqlDatabase db;

    public InvoiceListRepository() {
        db = MysqlDatabase.getInstance();
    }

    public InvoiceList getInvoiceList(String username) {
        Connection conn = db.getConnection();
        InvoiceList list = new InvoiceList(username);
        String sql = "" +
                "SELECT * FROM shoppingLists " +
                "JOIN listOwners " +
                "ON shoppingLists.ownerId=listOwners.id " +
                "WHERE listOwners.name = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();

            if (!rs.next()) {
                return null;
            }

            System.out.println(username);
            do {
                InvoiceItem item = new InvoiceItem();
                item.setName(rs.getString("itemName"));
                item.setQuantity(rs.getString("Quantity"));

                list.getItemList().add(item);
            } while (rs.next());


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    public void addItem(String username, InvoiceItem item) {
        Connection conn = db.getConnection();
        String sql = "SELECT id FROM listOwners WHERE name=?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            int ownerId;

            if (!rs.next()) { // Gå till första raden i query svaret
                ownerId = this.createNew(username);
            } else {
                ownerId = rs.getInt("id");
            }

            sql = "INSERT INTO shoppingLists (ownerId, itemName, quantity)" +
                    "VALUES (?, ?, ?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, ownerId);
            pstmt.setString(2, item.getName());
            pstmt.setString(3, item.getQuantity());

            pstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int createNew(String username) {
        Connection conn = db.getConnection();
        String sql = "INSERT INTO listOwners (name) VALUES (?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            return stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

