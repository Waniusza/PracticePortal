package com.gut.practice.service.user;

import com.gut.practice.entity.Practice;
import com.gut.practice.entity.user.Student;

/**
 *
 * @author kongo
 */
public class StudentService extends PortalUserService {
    public boolean addPratice(Practice practice){
        try { 
            Student student = new Student();//FIXME
            student.getPracticeList().add(practice);
            return true; } 
        catch (Exception e) { 
            System.out.printf("Sorry, can't add Pratice ", e); 
        }; 
        return false; 
    }
}
