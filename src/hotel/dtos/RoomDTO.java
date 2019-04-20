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
public class RoomDTO implements Serializable{
    private String id, type;
    private float price;
    private boolean avail;

    public RoomDTO() {
    } 

    public RoomDTO(String type, float price) {
        this.type = type;
        this.price = price;
    }
        
    public Vector toVector() throws Exception {
        Vector v = new Vector();
        v.add(id);
        v.add(type);
        return v;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isAvail() {
        return avail;
    }

    public void setAvail(boolean avail) {
        this.avail = avail;
    }
        
}
