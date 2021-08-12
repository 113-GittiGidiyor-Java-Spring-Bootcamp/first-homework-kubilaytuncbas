package controller;

import models.Course;
import service.CourseService;

public class CourseController {

    private CourseService courseService=new CourseService();

    public void saveCourse(Course course){
        courseService.saveToDatabase(course);
    }
    public void deleteCourse(int id){
        courseService.deleteFromDatabase(id);
    }
    public void updateCourse(Course course,int id){
        courseService.updateOnDatabase(course,id);
    }
}
