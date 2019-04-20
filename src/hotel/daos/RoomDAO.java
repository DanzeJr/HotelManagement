/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.daos;

import hotel.db.MyConnection;
import hotel.dtos.RoomDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danze
 */
public class RoomDAO implements Serializable{
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
    
    public List<RoomDTO> getAllRooms() throws Exception {
        List<RoomDTO> result = null;
        RoomDTO dto;
        String id, type;
        
        try {
            String sql = "SELECT sophong, loai FROM tbl_Rooms";
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
    
    public float getPrice(String id) throws Exception {
        float price = -1;
        
        try {
            String sql = "SELECT gia FROM tbl_Rooms WHERE sophong = ?";
            conn = MyConnection.getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, id);
            rs = pre.executeQuery();
            if (rs.next()) {
                price = rs.getFloat("gia");
            }
        } finally {
            closeConnection();
        }
        return price;
    }
    
    public RoomDTO findByID(String id) throws Exception {
        RoomDTO dto = null;
        String type;
        float price;
        
        try {
            String sql = "SELECT loai, gia FROM tbl_Rooms WHERE sophong = ?";
            conn = MyConnection.getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, id);
            rs = pre.executeQuery();
            if (rs.next()) {
                type = rs.getString("loai");
                price = rs.getFloat("gia");
                dto = new RoomDTO(type, price);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    
    public boolean isAvailable(String id) throws Exception {
        boolean check = true;
        
        try {
            String sql = "SELECT sophong FROM tbl_Bookings WHERE sophong = ?";
            conn = MyConnection.getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, id);
            rs = pre.executeQuery();
            if (rs.next()) {
                check = false;
            }
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean isExistedID(String id) throws Exception {
        boolean check = false;
        
        try {
            String sql = "SELECT sophong FROM tbl_Rooms WHERE sophong = ?";
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
    
    public boolean insert(RoomDTO dto) throws Exception {
        boolean check = false;
        
        try {
            String sql = "INSERT INTO tbl_Rooms(sophong, loai, gia)"
                    + " VALUES(?,?,?)";
            conn = MyConnection.getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, dto.getId());
            pre.setString(2, dto.getType());
            pre.setFloat(3, dto.getPrice());
            check = pre.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
        
    public boolean update(RoomDTO dto) throws Exception {
        boolean check = false;
        
        try {
            conn = MyConnection.getConnection();
            String sql = "UPDATE tbl_Rooms SET loai = ?, gia = ?"
                    + " WHERE sophong = ?";
            pre = conn.prepareStatement(sql);
            pre.setString(1, dto.getType());
            pre.setFloat(2, dto.getPrice());
            pre.setString(3, dto.getId());
            check = pre.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public List<RoomDTO> search(RoomDTO dto) throws Exception {
        List<RoomDTO> result = null;
        RoomDTO roomDTO;
        String id, type;
        
        try {
            String sql = "SELECT sophong, loai FROM tbl_Rooms"
                    + " WHERE sophong = ? AND type = ? AND sophong NOT IN (SELECT sophong FROM tbl_Bookings)";
            conn = MyConnection.getConnection();
            if (dto.getId().isEmpty()) {
                sql = sql.replace(" sophong = ? AND", "");
            }
            if (dto.getType().isEmpty()) {
                sql = sql.replace(" type = ? AND", "");
            }
            if (!dto.isAvail()) {
                sql = sql.replace("NOT ", "");
            }
            pre = conn.prepareStatement(sql);
            int i = 0;
            if (!dto.getId().isEmpty()) {
                pre.setString(++i, dto.getId());
            }
            if (!dto.getType().isEmpty()) {
                pre.setString(++i, dto.getType());
            }
            rs = pre.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                id = rs.getString("sophong");
                type = rs.getString("loai");
                roomDTO = new RoomDTO();
                roomDTO.setId(id);
                roomDTO.setType(type);
                result.add(roomDTO);
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
            String sql = "DELETE FROM tbl_Rooms WHERE sophong = ?";
            pre = conn.prepareStatement(sql);
            pre.setString(1, id);
            check = pre.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
