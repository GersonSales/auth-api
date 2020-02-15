package br.com.gsafj.user;

import java.io.Serializable;

public class UserVO implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long id;
  private String firstName;
  private String lastName;
  private String password;

  public final Long getId() {
    return id;
  }

  public final String getFirstName() {
    return firstName;
  }

  public final String getLastName() {
    return lastName;
  }
}
