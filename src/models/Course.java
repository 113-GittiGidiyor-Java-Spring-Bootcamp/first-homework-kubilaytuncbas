package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="course_name")
    private String courseName;

    @Column(name="course_code")
    private String courseCode;

    @Column(name="credit_score")
    private int creditScore;

    @ManyToMany(mappedBy = "studentCourses")
    private Set<Student> students = new HashSet<>();

    @ManyToOne
    private PermanentInstructor permanentInstructor;

    @ManyToOne
    private VisitingResearcher visitingResearcher;

    public Course(){

    }
    public Course(String courseName,String courseCode,int creditScore){

        this.courseName=courseName;
        this.courseCode=courseCode;
        this.creditScore=creditScore;

    }

    public PermanentInstructor getPermanentInstructor() {
        return permanentInstructor;
    }

    public void setPermanentInstructor(PermanentInstructor permanentInstructor) {
        this.permanentInstructor = permanentInstructor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id && creditScore == course.creditScore && Objects.equals(courseName, course.courseName) && Objects.equals(courseCode, course.courseCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseName, courseCode, creditScore);
    }

}

