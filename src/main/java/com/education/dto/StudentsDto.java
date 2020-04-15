package com.education.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class StudentsDto {

  private  String  fullName;
  private  String address;

  public StudentsDto() {
  }

  public StudentsDto(String fullName, String address) {
    this.fullName = fullName;
    this.address = address;
  }


  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
