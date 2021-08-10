package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@PrimaryKeyJoinColumn(name="user_id")
@Entity
@Table(name="visiting_researchers")
public class VisitingResearcher extends  User{

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="hourly_salary")
    private int hourlySalary;

    @OneToMany(mappedBy = "visitingResearcher")
    private List<Course> courseList=new ArrayList<>();

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public VisitingResearcher(String name, String address, String phoneNumber, int hourlySalary) {
        super(name, address);
        this.phoneNumber = phoneNumber;
        this.hourlySalary = hourlySalary;
    }

    public VisitingResearcher() {

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(int hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        VisitingResearcher that = (VisitingResearcher) o;
        return hourlySalary == that.hourlySalary && Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), phoneNumber, hourlySalary);
    }
}
