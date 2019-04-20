/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.daos;

import hotel.db.MyConnection;
import hotel.dtos.InvoiceDTO;
import hotel.dtos.RoomDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danze
 */
public class InvoiceDAO implements Serializable{
    private Connection conn;
    private PreparedStatement pre;
    private ResultSet rs;
    
    private void closeConnection() throws Exception {
        if (rs != null)
            rs.close();
        if (pre != null)
            pre.close();
        if (conn != null)
            conn.close();
    }
    
    public List<InvoiceDTO> getAllInvoices() throws Exception {
        List<InvoiceDTO> result = null;
        InvoiceDTO dto;
        String code, customer;
        Timestamp date;
        
        try {
            String sql = "SELECT mahoadon, cmnd, ngaythanhtoan"
                    + " FROM tbl_Invoices JOIN tbl_Bookings ON tbl_Invoices.madatphong = tbl_Bookings.ma";
            conn = MyConnection.getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                code = rs.getString("mahoadon");
                customer = rs.getString("cmnd");
                date = rs.getTimestamp("ngaythanhtoan");
                dto = new InvoiceDTO();
                dto.setCode(code);
                dto.setCustomer(customer);
                dto.setDate(date);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public InvoiceDTO findByID(String id) throws Exception {
        InvoiceDTO dto = null;
        String bookingCode, staff, customer;
        float total;
        Timestamp date;
        
        try {
            String sql = "SELECT mahoadon, madatphong, manhanvien, ngaythanhtoan, tbl_Bookings.cmnd, ten, gia, songay"
                    + " FROM tbl_Invoices JOIN tbl_Bookings ON tbl_Invoices.madatphong = tbl_Bookings.ma"
                    + " JOIN tbl_Customers ON tbl_Bookings.cmnd = tbl_Customers.cmnd"
                    + " JOIN tbl_Rooms ON tbl_Bookings.sophong = tbl_Rooms.sophong WHERE mahoadon = ?";
            conn = MyConnection.getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, id);
            rs = pre.executeQuery();
            if (rs.next()) {
                bookingCode = rs.getString("madatphong");
                staff = rs.getString("manhanvien");
                date = rs.getTimestamp("ngaythanhtoan");
                customer = rs.getString("cmnd") + " - " + rs.getString("ten");
                total = rs.getFloat("gia") * rs.getInt("songay");
                dto = new InvoiceDTO(bookingCode, customer, staff, total, date);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    
    public boolean insert(InvoiceDTO dto) throws Exception {
        boolean check = false;
        
        try {
            String sql = "INSERT INTO tbl_Invoices(mahoadon, madatphong, manhanvien, ngaythanhtoan)"
                    + " VALUES(?,?,?,?)";
            conn = MyConnection.getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, dto.getCode());
            pre.setString(2, dto.getBookingCode());
            pre.setString(3, dto.getStaff());
            pre.setTimestamp(4, dto.getDate());
            check = pre.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public List<InvoiceDTO> search(InvoiceDTO dto) throws Exception {
        List<InvoiceDTO> result = null;
        InvoiceDTO iDTO;
        String code, customer;
        Timestamp date;
        
        try {
            String sql = "SELECT mahoadon, cmnd, ngaythanhtoan"
                    + " FROM tbl_Invoices JOIN tbl_Bookings ON tbl_Invoices.madatphong = tbl_Bookings.ma"
                    + " WHERE mahoadon = ? AND cmnd = ?";
            conn = MyConnection.getConnection();
            if (dto.getCode().isEmpty()) {
                sql = sql.replace(" mahoadon = ? AND", "");
            }
            if (dto.getCustomer().isEmpty()) {
                sql = sql.replace(" AND cmnd = ?", "");
            }
            pre = conn.prepareStatement(sql);
            int i = 0;
            if (!dto.getCode().isEmpty()) {
                pre.setString(++i, dto.getCode());
            }
            if (!dto.getCustomer().isEmpty()) {
                pre.setString(++i, dto.getCustomer());
            }
            rs = pre.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                code = rs.getString("mahoadon");
                customer = rs.getString("cmnd");
                date = rs.getTimestamp("ngaythanhtoan");
                iDTO = new InvoiceDTO();
                iDTO.setCode(code);
                iDTO.setCustomer(customer);
                iDTO.setDate(date);
                result.add(iDTO);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public boolean delete(String id) throws Exception {
        boolean check = false;
        try {
            conn = MyConnection.getConnection();
            String sql = "DELETE FROM tbl_Invoices WHERE mahoadon = ?";
            pre = conn.prepareStatement(sql);
            pre.setString(1, id);
            check = pre.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
