package models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@PrimaryKeyJoinColumn(name="user_id")
@Entity
@Table(name="students")
public class Student extends  User{
    //merabab
    @Column(name="birth_date")
    private LocalDate birthDate;

    @Column(name="gender")
    private String Gender;



    @ManyToMany
    private Set<Course> courses = new HashSet<>();



    public Student(String name, String address, LocalDate birthDate, String gender) {
        super(name, address);
        this.birthDate = birthDate;
        this.Gender = gender;
    }

    public Student() {

    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(birthDate, student.birthDate) && Objects.equals(Gender, student.Gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(birthDate, Gender);
    }

}

