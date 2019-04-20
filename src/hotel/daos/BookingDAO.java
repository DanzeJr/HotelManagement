/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.daos;

import hotel.db.MyConnection;
import hotel.dtos.BookingDTO;
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
public class BookingDAO implements Serializable{
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
    
    public List<BookingDTO> getAllBookings() throws Exception {
        List<BookingDTO> result = null;
        BookingDTO dto;
        String code, room, customer;
        int duration;
        
        try {
            String sql = "SELECT ma, sophong, cmnd, songay FROM tbl_Bookings";
            conn = MyConnection.getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                code = rs.getString("ma");
                room = rs.getString("sophong");
                customer = rs.getString("cmnd");
                duration = rs.getInt("songay");
                dto = new BookingDTO(code, customer, room, duration);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public List<RoomDTO> getAvailableRooms() throws Exception {
        List<RoomDTO> result = null;
        RoomDTO dto;
        String id, type;
        
        try {
            String sql = "SELECT sophong, loai FROM tbl_Rooms WHERE sophong NOT IN (SELECT sophong FROM tbl_Bookings)";
            conn = MyConnection.getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                id = rs.getString("sophong");
                type = rs.getString("loai");
                dto = new RoomDTO();
                dto.setId(id);
                dto.setType(type);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public List<String> getAllCustomers() throws Exception {
        List<String> result = null;
        String customer;
        
        try {
            String sql = "SELECT cmnd, ten FROM tbl_Customers";
            conn = MyConnection.getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                customer = rs.getString("cmnd") + " - " + rs.getString("ten");
                result.add(customer);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public BookingDTO findByID(String id) throws Exception {
        BookingDTO dto = null;
        String room, customer;
        float price;
        int duration;
        Timestamp date;
        
        try {
            String sql = "SELECT tbl_Bookings.sophong, loai, gia, songay, tbl_Bookings.cmnd, ten, ngaytao"
                    + " FROM tbl_Bookings JOIN tbl_Rooms ON tbl_Bookings.sophong = tbl_Rooms.sophong"
                    + " JOIN tbl_Customers ON tbl_Bookings.cmnd = tbl_Customers.cmnd WHERE ma = ?";
            conn = MyConnection.getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, id);
            rs = pre.executeQuery();
            if (rs.next()) {
                room = rs.getString("sophong") + " - " + rs.getString("loai");
                price = rs.getFloat("gia");
                duration = rs.getInt("songay");
                customer = rs.getString("cmnd") + " - " + rs.getString("ten");
                date = rs.getTimestamp("ngaytao");
                dto = new BookingDTO(customer, room, duration, date);
                dto.setRoomPrice(price);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    
    public boolean isExistedID(String id) throws Exception {
        boolean check = false;
        
        try {
            String sql = "SELECT ma FROM tbl_Bookings WHERE ma = ?";
            conn = MyConnection.getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, id);
            rs = pre.executeQuery();
            if (rs.next()) {
                check = true;
            }
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean insert(BookingDTO dto) throws Exception {
        boolean check = false;
        
        try {
            String sql = "INSERT INTO tbl_Bookings(ma, cmnd, sophong, songay, ngaytao)"
                    + " VALUES(?,?,?,?,?)";
            conn = MyConnection.getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, dto.getCode());
            pre.setString(2, dto.getCustomer());
            pre.setString(3, dto.getRoom());
            pre.setInt(4, dto.getDuration());
            pre.setTimestamp(5, dto.getDate());
            check = pre.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
        
    public boolean update(BookingDTO dto) throws Exception {
        boolean check = false;
        
        try {
            conn = MyConnection.getConnection();
            String sql = "UPDATE tbl_Bookings SET cmnd = ?, sophong = ?, songay = ?"
                    + " WHERE ma = ?";
            pre = conn.prepareStatement(sql);
            pre.setString(1, dto.getCustomer());
            pre.setString(2, dto.getRoom());
            pre.setInt(3, dto.getDuration());
            pre.setString(4, dto.getCode());
            check = pre.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public List<BookingDTO> search(BookingDTO dto) throws Exception {
        List<BookingDTO> result = null;
        BookingDTO bDTO;
        String code, room, customer;
        int duration;
        
        try {
            String sql = "SELECT ma, sophong, cmnd, songay FROM tbl_Bookings"
                    + " WHERE ma = ? AND sophong = ? AND cmnd = ?";
            conn = MyConnection.getConnection();
            if (dto.getCode().isEmpty()) {
                sql = sql.replace(" ma = ? AND", "");
            }
            if (dto.getRoom().isEmpty()) {
                sql = sql.replace(" sophong = ? AND", "");
            }
            if (dto.getCustomer().isEmpty()) {
                sql = sql.replace(" AND cmnd = ?", "");
            }
            pre = conn.prepareStatement(sql);
            int i = 0;
            if (!dto.getCode().isEmpty()) {
                pre.setString(++i, dto.getCode());
            }
            if (!dto.getRoom().isEmpty()) {
                pre.setString(++i, dto.getRoom());
            }
            if (!dto.getCustomer().isEmpty()) {
                pre.setString(++i, dto.getCustomer());
            }
            rs = pre.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                code = rs.getString("ma");
                room = rs.getString("sophong");
                customer = rs.getString("cmnd");
                duration = rs.getInt("songay");
                bDTO = new BookingDTO(code, customer, room, duration);
                result.add(bDTO);
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
            String sql = "DELETE FROM tbl_Bookings WHERE ma = ?";
            pre = conn.prepareStatement(sql);
            pre.setString(1, id);
            check = pre.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
