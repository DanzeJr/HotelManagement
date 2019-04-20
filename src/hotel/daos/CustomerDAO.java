/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.daos;

import hotel.db.MyConnection;
import hotel.dtos.CustomerDTO;
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
public class CustomerDAO implements Serializable{
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
    
    public List<CustomerDTO> getAllCustomers() throws Exception {
        List<CustomerDTO> result = null;
        CustomerDTO dto;
        String id, name, gender, country;
        
        try {
            String sql = "SELECT cmnd, ten, gioitinh, quoctich FROM tbl_Customers";
            conn = MyConnection.getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                id = rs.getString("cmnd");
                name = rs.getString("ten");
                gender = rs.getString("gioitinh");
                country = rs.getString("quoctich");
                dto = new CustomerDTO(id, name, gender, country);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public CustomerDTO findByID(String id) throws Exception {
        CustomerDTO dto = null;
        String name, gender, address, phone, country;
        
        try {
            String sql = "SELECT ten, diachi, gioitinh, sdt, quoctich FROM tbl_Customers WHERE cmnd = ?";
            conn = MyConnection.getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, id);
            rs = pre.executeQuery();
            if (rs.next()) {
                name = rs.getString("ten");
                gender = rs.getString("gioitinh");
                address = rs.getString("diachi");
                phone = rs.getString("sdt");
                country = rs.getString("quoctich");
                dto = new CustomerDTO(name, gender, address, phone, country);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    
    public boolean isExistedID(String id) throws Exception {
        boolean check = false;
        
        try {
            String sql = "SELECT cmnd FROM tbl_Customers WHERE cmnd = ?";
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
    
    public boolean insert(CustomerDTO dto) throws Exception {
        boolean check = false;
        
        try {
            String sql = "INSERT INTO tbl_Customers(cmnd, ten, diachi, gioitinh, sdt, quoctich)"
                    + " VALUES(?,?,?,?,?,?)";
            conn = MyConnection.getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, dto.getId());
            pre.setString(2, dto.getName());
            pre.setString(3, dto.getAddress());            
            pre.setString(4, dto.getGender());
            pre.setString(5, dto.getPhone());
            pre.setString(6, dto.getCountry());
            check = pre.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
        
    public boolean update(CustomerDTO dto) throws Exception {
        boolean check = false;
        
        try {
            conn = MyConnection.getConnection();
            String sql = "UPDATE tbl_Customers SET ten = ?, diachi = ?, gioitinh = ?, sdt = ?,  quoctich = ?"
                    + " WHERE cmnd = ?";
            pre = conn.prepareStatement(sql);
            pre.setString(1, dto.getName());            
            pre.setString(2, dto.getAddress());
            pre.setString(3, dto.getGender());
            pre.setString(4, dto.getPhone());
            pre.setString(5, dto.getCountry());
            pre.setString(6, dto.getId());
            check = pre.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public List<CustomerDTO> search(CustomerDTO dto) throws Exception {
        List<CustomerDTO> result = null;
        CustomerDTO cusDTO;
        String id, name, gender, country;
        
        try {
            String sql = "SELECT cmnd, ten, gioitinh, quoctich FROM tbl_Customers"
                    + " WHERE cmnd = ? AND ten LIKE ? AND diachi = ? AND gioitinh = ? AND sdt = ? AND quoctich = ?";
            conn = MyConnection.getConnection();
            if (dto.getId().isEmpty()) {
                sql = sql.replace(" cmnd = ? AND", "");
            }
            if (dto.getName().isEmpty()) {
                sql = sql.replace(" ten LIKE ? AND", "");
            }
            if (dto.getAddress().isEmpty()) {
                sql = sql.replace(" diachi = ? AND", "");
            }
            if (dto.getGender().isEmpty()) {
                sql = sql.replace(" gioitinh = ? AND", "");
            }
            if (dto.getPhone().isEmpty()) {
                sql = sql.replace(" sdt = ? AND", "");
            }
            if (dto.getCountry().isEmpty()) {
                sql = sql.replace(" AND quoctich = ?", "");
            }
            pre = conn.prepareStatement(sql);
            int i = 0;
            if (!dto.getId().isEmpty()) {
                pre.setString(++i, dto.getId());
            }
            if (!dto.getName().isEmpty()) {
                pre.setString(++i, "%" + dto.getName() + "%");
            }
            if (!dto.getAddress().isEmpty()) {
                pre.setString(++i, dto.getAddress());
            }
            if (!dto.getGender().isEmpty()) {
                pre.setString(++i, dto.getGender());
            }
            if (!dto.getPhone().isEmpty()) {
                pre.setString(++i, dto.getPhone());
            }
            if (!dto.getCountry().isEmpty()) {
                pre.setString(++i, dto.getCountry());
            }
            rs = pre.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                id = rs.getString("cmnd");
                name = rs.getString("ten");
                gender = rs.getString("gioitinh");
                country = rs.getString("quoctich");
                cusDTO = new CustomerDTO(id, name, gender, country);
                result.add(cusDTO);
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
            String sql = "DELETE FROM tbl_Customers WHERE cmnd = ?";
            pre = conn.prepareStatement(sql);
            pre.setString(1, id);
            check = pre.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
