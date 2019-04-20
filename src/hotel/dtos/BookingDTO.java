/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.dtos;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Vector;

/**
 *
 * @author Danze
 */
public class BookingDTO implements Serializable{
    private String code, customer, room;
    private float roomPrice;
    private int duration;
    private Timestamp date;

    public BookingDTO() {
    }

    public BookingDTO(String code, String customer, String room, int duration) {
        this.code = code;
        this.customer = customer;
        this.room = room;
        this.duration = duration;
    }

    public BookingDTO(String customer, String room, int duration, Timestamp date) {
        this.customer = customer;
        this.room = room;
        this.duration = duration;
        this.date = date;
    }
            
    public Vector toVector() throws Exception {
        Vector v = new Vector();
        v.add(code);
        v.add(room);
        v.add(customer);
        v.add(duration + "ngày");
        return v;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public float getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(float roomPrice) {
        this.roomPrice = roomPrice;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
        
}
