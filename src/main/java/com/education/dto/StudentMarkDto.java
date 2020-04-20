package com.education.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class StudentMarkDto {


  private  Integer  studentId;
  private String lesson;
  private Integer mark1;
  private Integer mark2;
  private Integer mark3;

  public StudentMarkDto() {
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
}

