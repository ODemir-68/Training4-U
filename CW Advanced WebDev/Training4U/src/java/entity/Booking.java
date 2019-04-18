/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cmpodemi
 */
@Entity
@Table(name = "BOOKING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b"),
    @NamedQuery(name = "Booking.findByBookingno", query = "SELECT b FROM Booking b WHERE b.bookingno = :bookingno"),
    @NamedQuery(name = "Booking.findByCustomername", query = "SELECT b FROM Booking b WHERE b.customername = :customername"),
    @NamedQuery(name = "Booking.findByCustomerphone", query = "SELECT b FROM Booking b WHERE b.customerphone = :customerphone")})
public class Booking implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BOOKINGNO")
    private Integer bookingno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "CUSTOMERNAME")
    private String customername;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CUSTOMERPHONE")
    private String customerphone;
    @JoinColumn(name = "LESSONNO", referencedColumnName = "LESSONNO")
    @ManyToOne(optional = false)
    private Lesson lessonno;

    public Booking() {
    }

    public Booking(Integer bookingno) {
        this.bookingno = bookingno;
    }

    public Booking(Integer bookingno, String customername, String customerphone) {
        this.bookingno = bookingno;
        this.customername = customername;
        this.customerphone = customerphone;
    }

    public Integer getBookingno() {
        return bookingno;
    }

    public void setBookingno(Integer bookingno) {
        this.bookingno = bookingno;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCustomerphone() {
        return customerphone;
    }

    public void setCustomerphone(String customerphone) {
        this.customerphone = customerphone;
    }

    public Lesson getLessonno() {
        return lessonno;
    }

    public void setLessonno(Lesson lessonno) {
        this.lessonno = lessonno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingno != null ? bookingno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.bookingno == null && other.bookingno != null) || (this.bookingno != null && !this.bookingno.equals(other.bookingno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Booking[ bookingno=" + bookingno + " ]";
    }
    
}
