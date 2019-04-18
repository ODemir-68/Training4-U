/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Booking;
import entity.Instructor;
import entity.Lesson;
import entity.Sport;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cmpodemi
 */
@Named(value = "training4UBean")
@SessionScoped
public class Training4UBean implements Serializable {

    List<Lesson> lessons=null;
    List<Booking> booking=null;
    @PersistenceContext(unitName = "Training4UPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    public Training4UBean() {
    }
    public List<Sport>getSports(){
        return em.createNamedQuery("Sport.findAll").getResultList();
    }
    public List<Instructor>getInstructors(){
        return em.createNamedQuery("Instructor.findAll").getResultList();
    }
    public List<Lesson>getLessons(){
        return em.createNamedQuery("Lesson.findAll").getResultList();
    }

    public String goToBookingPage (){
    return "bookingPage";
    } 
    
    public List<Lesson> getSport01(){
    List<Lesson> Sport01=new ArrayList<Lesson>();
    if(lessons==null)
        lessons=em.createNamedQuery("Lesson.findAll").getResultList();
    for(Lesson lesson:lessons){
        if(lesson.getSportno()!= null)
            if(lesson.getSportno().getSportno() == 1)
                Sport01.add(lesson);
    }    
    return Sport01;
    }
    
    public void setAvailableLesson (Lesson lesson){
    int lessons = lesson.getAvailablelessons(); 
    lesson.setAvailablelessons(lessons-1); 
    updateEntity(lesson); 
    }
    
    public void updateEntity(Object object){
    try{
        
        utx.begin();
        em.merge(object);
        utx.commit();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    }

    private String firstOperand = null;
    private Integer secondOperand = null;
    
    public String getFirstOperand() {
        return firstOperand;
    }
    public void setFirstOperand(String firstOperand) {
        this.firstOperand = firstOperand;
    }
    public Integer getSecondOperand(){
        return secondOperand;
    }
    public void setSecondOperand(Integer secondOperand){
        this.secondOperand = secondOperand;
    }
    
    

    
    public void addEntity(Object object){
    try{
        utx.begin();
        em.persist(object);
        utx.commit();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    }
}
