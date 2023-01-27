package com.example.ducklings.respository;

import com.example.ducklings.db.MysqlDatabase;
import com.example.ducklings.model.InvoiceItem;
import com.example.ducklings.model.InvoiceList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class InvoiceListRepo {

    private MysqlDatabase db;

    public InvoiceListRepo(){
        db = MysqlDatabase.getInstance();
    }
    public InvoiceList getInvoiceList(String username){
        Connection conn = db.getConnection();
        InvoiceList list = new InvoiceList();
        String sql = "" +
                "SELECT * FROM users ";
        try{
            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, username);

                ResultSet rs = pstmt.executeQuery();

                if(!rs.next()) { return null; } //guardian clause

                do {
                    InvoiceItem item  = new InvoiceItem();
                    item.setTitle(rs.getString("title"));
                    item.setCreated(rs.getDate("created"));
                    item.setDescription(rs.getString("description"));
                    item.setCategory(rs.getString("category"));
                    item.setAmount(rs.getInt("amount"));


                   list.getInvoices().add(item);
                } while(rs.next());


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            return list;

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
