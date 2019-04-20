/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.dtos;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

/**
 *
 * @author Danze
 */
public class InvoiceDTO implements Serializable{
    private String code, bookingCode, customer, staff;
    private float total;
    private Timestamp date;

    public InvoiceDTO() {
    }

    public InvoiceDTO(String code, String bookingCode, String staff, Timestamp date) {
        this.code = code;
        this.bookingCode = bookingCode;
        this.staff = staff;
        this.date = date;
    }

    public InvoiceDTO(String bookingCode, String customer, String staff, float total, Timestamp date) {
        this.bookingCode = bookingCode;
        this.customer = customer;
        this.staff = staff;
        this.total = total;
        this.date = date;
    }   
                
    public Vector toVector() throws Exception {
        Vector v = new Vector();
        v.add(code);
        v.add(customer);
        v.add(date.toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm")));
        return v;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
        
}
