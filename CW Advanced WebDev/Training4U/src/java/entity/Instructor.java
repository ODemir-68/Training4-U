/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cmpodemi
 */
@Entity
@Table(name = "INSTRUCTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instructor.findAll", query = "SELECT i FROM Instructor i"),
    @NamedQuery(name = "Instructor.findByInstructorno", query = "SELECT i FROM Instructor i WHERE i.instructorno = :instructorno"),
    @NamedQuery(name = "Instructor.findByInstructorname", query = "SELECT i FROM Instructor i WHERE i.instructorname = :instructorname"),
    @NamedQuery(name = "Instructor.findByInstructorphone", query = "SELECT i FROM Instructor i WHERE i.instructorphone = :instructorphone"),
    @NamedQuery(name = "Instructor.findByInstructoremail", query = "SELECT i FROM Instructor i WHERE i.instructoremail = :instructoremail")})
public class Instructor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "INSTRUCTORNO")
    private Integer instructorno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "INSTRUCTORNAME")
    private String instructorname;
    @Size(max = 100)
    @Column(name = "INSTRUCTORPHONE")
    private String instructorphone;
    @Size(max = 255)
    @Column(name = "INSTRUCTOREMAIL")
    private String instructoremail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructorno")
    private Collection<Lesson> lessonCollection;

    public Instructor() {
    }

    public Instructor(Integer instructorno) {
        this.instructorno = instructorno;
    }

    public Instructor(Integer instructorno, String instructorname) {
        this.instructorno = instructorno;
        this.instructorname = instructorname;
    }

    public Integer getInstructorno() {
        return instructorno;
    }

    public void setInstructorno(Integer instructorno) {
        this.instructorno = instructorno;
    }

    public String getInstructorname() {
        return instructorname;
    }

    public void setInstructorname(String instructorname) {
        this.instructorname = instructorname;
    }

    public String getInstructorphone() {
        return instructorphone;
    }

    public void setInstructorphone(String instructorphone) {
        this.instructorphone = instructorphone;
    }

    public String getInstructoremail() {
        return instructoremail;
    }

    public void setInstructoremail(String instructoremail) {
        this.instructoremail = instructoremail;
    }

    @XmlTransient
    public Collection<Lesson> getLessonCollection() {
        return lessonCollection;
    }

    public void setLessonCollection(Collection<Lesson> lessonCollection) {
        this.lessonCollection = lessonCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (instructorno != null ? instructorno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instructor)) {
            return false;
        }
        Instructor other = (Instructor) object;
        if ((this.instructorno == null && other.instructorno != null) || (this.instructorno != null && !this.instructorno.equals(other.instructorno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Instructor[ instructorno=" + instructorno + " ]";
    }
    
}
