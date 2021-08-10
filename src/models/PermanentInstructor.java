package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@PrimaryKeyJoinColumn(name="user_id")
@Entity
@Table(name="permanent_instructors")
public class PermanentInstructor extends User{

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="fixed_salary")
    private int fixedSalary;

    @OneToMany(mappedBy = "permanentInstructor")
    private List<Course> courseList=new ArrayList<>();

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public PermanentInstructor(String name, String address, String phoneNumber, int fixedSalary) {
        super(name, address);
        this.phoneNumber = phoneNumber;
        this.fixedSalary = fixedSalary;
    }

    public PermanentInstructor() {

    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(int fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PermanentInstructor that = (PermanentInstructor) o;
        return fixedSalary == that.fixedSalary && Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber, fixedSalary);
    }

}
