package com.epam.spring.core.beans;

public class Client {

  private Long id;
  private String fullname;
  private String greeting;

  public void setGreeting(String greeting) {
    this.greeting = greeting;
  }

  public Client(Long id, String fullname) {
    this.id = id;
    this.fullname = fullname;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }
}
