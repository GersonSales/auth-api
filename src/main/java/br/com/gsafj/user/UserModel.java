package br.com.gsafj.user;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class UserModel implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Double id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "password")
  private String password;


  public final Double getId() {
    return id;
  }
}
