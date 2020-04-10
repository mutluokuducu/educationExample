package com.education.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Students {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column
  private  String  fullName;
  @Column
  private  String address;

  public Students() {
  }

  public Students(String fullName, String address) {
    this.fullName = fullName;
    this.address = address;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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
