/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.dtos;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author Danze
 */
public class CustomerDTO implements Serializable{
    private String id, name, gender, address, phone, country;

    public CustomerDTO() {
    }

    public CustomerDTO(String id, String name, String gender, String country) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.country = country;
    }
        
    public CustomerDTO(String name, String gender, String address, String phone, String country) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.country = country;
    }
        
    public Vector toVector() throws Exception {
        Vector v = new Vector();
        v.add(id);
        v.add(name);
        v.add(gender);
        v.add(country);
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
        
}
