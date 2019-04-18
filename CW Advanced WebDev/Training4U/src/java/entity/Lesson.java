/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cmpodemi
 */
@Entity
@Table(name = "LESSON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lesson.findAll", query = "SELECT l FROM Lesson l"),
    @NamedQuery(name = "Lesson.findByLessonno", query = "SELECT l FROM Lesson l WHERE l.lessonno = :lessonno"),
    @NamedQuery(name = "Lesson.findByDate", query = "SELECT l FROM Lesson l WHERE l.date = :date"),
    @NamedQuery(name = "Lesson.findByStarttime", query = "SELECT l FROM Lesson l WHERE l.starttime = :starttime"),
    @NamedQuery(name = "Lesson.findByEndtime", query = "SELECT l FROM Lesson l WHERE l.endtime = :endtime"),
    @NamedQuery(name = "Lesson.findByPrice", query = "SELECT l FROM Lesson l WHERE l.price = :price"),
    @NamedQuery(name = "Lesson.findByAvailablelessons", query = "SELECT l FROM Lesson l WHERE l.availablelessons = :availablelessons")})
public class Lesson implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "LESSONNO")
    private Integer lessonno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STARTTIME")
    @Temporal(TemporalType.TIME)
    private Date starttime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ENDTIME")
    @Temporal(TemporalType.TIME)
    private Date endtime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private int price;
    @Column(name = "AVAILABLELESSONS")
    private Integer availablelessons;
    @JoinColumn(name = "INSTRUCTORNO", referencedColumnName = "INSTRUCTORNO")
    @ManyToOne(optional = false)
    private Instructor instructorno;
    @JoinColumn(name = "SPORTNO", referencedColumnName = "SPORTNO")
    @ManyToOne
    private Sport sportno;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lessonno")
    private Collection<Booking> bookingCollection;

    public Lesson() {
    }

    public Lesson(Integer lessonno) {
        this.lessonno = lessonno;
    }

    public Lesson(Integer lessonno, Date date, Date starttime, Date endtime, int price) {
        this.lessonno = lessonno;
        this.date = date;
        this.starttime = starttime;
        this.endtime = endtime;
        this.price = price;
    }

    public Integer getLessonno() {
        return lessonno;
    }

    public void setLessonno(Integer lessonno) {
        this.lessonno = lessonno;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Integer getAvailablelessons() {
        return availablelessons;
    }

    public void setAvailablelessons(Integer availablelessons) {
        this.availablelessons = availablelessons;
    }

    public Instructor getInstructorno() {
        return instructorno;
    }

    public void setInstructorno(Instructor instructorno) {
        this.instructorno = instructorno;
    }

    public Sport getSportno() {
        return sportno;
    }

    public void setSportno(Sport sportno) {
        this.sportno = sportno;
    }

    @XmlTransient
    public Collection<Booking> getBookingCollection() {
        return bookingCollection;
    }

    public void setBookingCollection(Collection<Booking> bookingCollection) {
        this.bookingCollection = bookingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lessonno != null ? lessonno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lesson)) {
            return false;
        }
        Lesson other = (Lesson) object;
        if ((this.lessonno == null && other.lessonno != null) || (this.lessonno != null && !this.lessonno.equals(other.lessonno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Lesson[ lessonno=" + lessonno + " ]";
    }
    
}
