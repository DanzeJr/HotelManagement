/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.daos;

import hotel.db.MyConnection;
import hotel.dtos.StaffDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danze
 */
public class StaffDAO implements Serializable{
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
    
    public List<StaffDTO> getAllStaffs() throws Exception {
        List<StaffDTO> result = null;
        StaffDTO dto;
        String id, name, role, gender;
        
        try {
            String sql = "SELECT manhanvien, ten, chucvu, gioitinh FROM tbl_Staffs";
            conn = MyConnection.getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                id = rs.getString("manhanvien");
                name = rs.getString("ten");
                role = rs.getString("chucvu");
                gender = rs.getString("gioitinh");
                dto = new StaffDTO();
                dto.setId(id);
                dto.setName(name);
                dto.setRole(role);
                dto.setGender(gender);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public StaffDTO findByID(String id) throws Exception {
        StaffDTO dto = null;
        String name, role, gender, address, phone;
        Date birthDate;
        float salary;
        
        try {
            String sql = "SELECT ten, chucvu, gioitinh, diachi, ngaysinh, sdt, luong FROM tbl_Staffs WHERE manhanvien = ?";
            conn = MyConnection.getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, id);
            rs = pre.executeQuery();
            if (rs.next()) {
                name = rs.getString("ten");
                role = rs.getString("chucvu");
                gender = rs.getString("gioitinh");
                address = rs.getString("diachi");
                birthDate = rs.getDate("ngaysinh");
                phone = rs.getString("sdt");
                salary = rs.getFloat("luong");
                dto = new StaffDTO(name, role, gender, address, phone, birthDate, salary);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    
    public boolean isExistedID(String id) throws Exception {
        boolean check = false;
        
        try {
            String sql = "SELECT manhanvien FROM tbl_Staffs WHERE manhanvien = ?";
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
    
    public boolean insert(StaffDTO dto) throws Exception {
        boolean check = false;
        
        try {
            String sql = "INSERT INTO tbl_Staffs(manhanvien, ten, matkhau, chucvu, gioitinh, diachi, ngaysinh, sdt, luong)"
                    + " VALUES(?,?,?,?,?,?,?,?,?)";
            conn = MyConnection.getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, dto.getId());
            pre.setString(2, dto.getName());
            pre.setString(3, dto.getPassword());
            pre.setString(4, dto.getRole());
            pre.setString(5, dto.getGender());
            pre.setString(6, dto.getAddress());
            pre.setDate(7, dto.getBirthDate());
            pre.setString(8, dto.getPhone());
            pre.setFloat(9, dto.getSalary());
            check = pre.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
        
    public boolean update(StaffDTO dto) throws Exception {
        boolean check = false;
        int i = 0;
        try {
            conn = MyConnection.getConnection();
            String sql = "UPDATE tbl_Staffs SET matkhau = ?, ten = ?, chucvu = ?, gioitinh = ?, diachi = ?, ngaysinh = ?, sdt = ?,  luong = ?"
                    + " WHERE manhanvien = ?";
            if (dto.getPassword().isEmpty()) { //neu khong doi mat khau
                sql = sql.replace(" matkhau = ?,", "");
            }
            pre = conn.prepareStatement(sql);
            if (!dto.getPassword().isEmpty()) {
                pre.setString(++i, dto.getPassword());
            }
            pre.setString(++i, dto.getName());
            pre.setString(++i, dto.getRole());
            pre.setString(++i, dto.getGender());
            pre.setString(++i, dto.getAddress());
            pre.setDate(++i, dto.getBirthDate());
            pre.setString(++i, dto.getPhone());
            pre.setFloat(++i, dto.getSalary());
            pre.setString(++i, dto.getId());
            check = pre.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public List<StaffDTO> search(StaffDTO dto) throws Exception {
        List<StaffDTO> result = null;
        StaffDTO staffDTO;
        String id, name, role, gender;
        
        try {
            String sql = "SELECT manhanvien, ten, chucvu, gioitinh FROM tbl_Staffs"
                    + " WHERE manhanvien = ? AND ten LIKE ? AND chucvu = ? AND gioitinh = ? AND diachi = ? AND sdt = ?";
            conn = MyConnection.getConnection();
            if (dto.getId().isEmpty()) {
                sql = sql.replace(" manhanvien = ? AND", "");
            }
            if (dto.getName().isEmpty()) {
                sql = sql.replace(" ten LIKE ? AND", "");
            }
            if (dto.getRole().isEmpty()) {
                sql = sql.replace(" chucvu = ? AND", "");
            }
            if (dto.getGender().isEmpty()) {
                sql = sql.replace(" gioitinh = ? AND", "");
            }
            if (dto.getAddress().isEmpty()) {
                sql = sql.replace(" diachi = ? AND", "");
            }
            if (dto.getPhone().isEmpty()) {
                sql = sql.replace(" AND sdt = ?", "");
            }
            pre = conn.prepareStatement(sql);
            int i = 0;
            if (!dto.getId().isEmpty()) {
                pre.setString(++i, dto.getId());
            }
            if (!dto.getName().isEmpty()) {
                pre.setString(++i, "%" + dto.getName() + "%");
            }
            if (!dto.getRole().isEmpty()) {
                pre.setString(++i, dto.getRole());
            }
            if (!dto.getGender().isEmpty()) {
                pre.setString(++i, dto.getGender());
            }
            if (!dto.getAddress().isEmpty()) {
                pre.setString(++i, dto.getAddress());
            }
            if (!dto.getPhone().isEmpty()) {
                pre.setString(++i, dto.getPhone());
            }
            rs = pre.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                id = rs.getString("manhanvien");
                name = rs.getString("ten");
                role = rs.getString("chucvu");
                gender = rs.getString("gioitinh");
                staffDTO = new StaffDTO();
                staffDTO.setId(id);
                staffDTO.setName(name);
                staffDTO.setRole(role);
                staffDTO.setGender(gender);
                result.add(staffDTO);
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
            String sql = "DELETE FROM tbl_Staffs WHERE manhanvien = ?";
            pre = conn.prepareStatement(sql);
            pre.setString(1, id);
            check = pre.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
