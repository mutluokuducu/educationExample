package com.education.repository.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "students")
public class Students  implements Serializable {

//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  private Integer id;

  @Id
  @Column(updatable = false, nullable = false)
  private Integer studentId;

  @Column
  private String fullName;

  @Column
  private String className;

  @Column
  private LocalDate date;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "studentId")
  private List<StudentMark> studentMark=new ArrayList<>();

  @OneToOne
  @JoinColumn(name="studentId")
  private Address address;

  public Students() {
  }

  public Students(Integer studentId, String fullName, String className, LocalDate date,
      List<StudentMark> studentMark, Address address) {
    this.studentId = studentId;
    this.fullName = fullName;
    this.className = className;
    this.date = date;
    this.studentMark = studentMark;
    this.address = address;
  }

  public Integer getStudentId() {
    return studentId;
  }

  public void setStudentId(Integer studentId) {
    this.studentId = studentId;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public List<StudentMark> getStudentMark() {
    return studentMark;
  }

  public void setStudentMark(List<StudentMark> studentMark) {
    this.studentMark = studentMark;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }
}
