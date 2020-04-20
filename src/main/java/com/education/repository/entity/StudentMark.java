package com.education.repository.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "studentsMark")
public class StudentMark implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column
  private  Integer  studentId;

  @Column
  private String lesson;

  @Column
  private Integer mark1;

  @Column
  private Integer mark2;

  @Column
  private Integer mark3;

  @Column
  private Double average;

  @Column
  private String  letter;


  public StudentMark() {
  }

  public StudentMark(Integer studentId, String lesson, Integer mark1, Integer mark2,
      Integer mark3, Double average, String letter) {
    this.studentId = studentId;
    this.lesson = lesson;
    this.mark1 = mark1;
    this.mark2 = mark2;
    this.mark3 = mark3;
    this.average = average;
    this.letter = letter;
  }

  public Integer getStudentId() {
    return studentId;
  }

  public void setStudentId(Integer studentId) {
    this.studentId = studentId;
  }

  public String getLesson() {
    return lesson;
  }

  public void setLesson(String lesson) {
    this.lesson = lesson;
  }

  public Integer getMark1() {
    return mark1;
  }

  public void setMark1(Integer mark1) {
    this.mark1 = mark1;
  }

  public Integer getMark2() {
    return mark2;
  }

  public void setMark2(Integer mark2) {
    this.mark2 = mark2;
  }

  public Integer getMark3() {
    return mark3;
  }

  public void setMark3(Integer mark3) {
    this.mark3 = mark3;
  }

  public Double getAverage() {
    return average;
  }

  public void setAverage(Double average) {
    this.average = average;
  }

  public String getLetter() {
    return letter;
  }

  public void setLetter(String letter) {
    this.letter = letter;
  }
}

