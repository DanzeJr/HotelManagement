/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.dtos;

import java.io.Serializable;
import java.sql.Date;
import java.util.Vector;

/**
 *
 * @author Danze
 */
public class StaffDTO implements Serializable{
    private String id, name, password, role, gender, address, phone;
    private Date birthDate;
    private float salary;

    public StaffDTO() {
    }

    public StaffDTO(String name, String role, String gender, String address, String phone, Date birthDate, float salary) {
        this.name = name;
        this.role = role;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.birthDate = birthDate;
        this.salary = salary;
    }
    
    public Vector toVector() throws Exception {
        Vector v = new Vector();
        v.add(id);
        v.add(name);
        v.add(role);
        v.add(gender);
        return v;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
        
}
