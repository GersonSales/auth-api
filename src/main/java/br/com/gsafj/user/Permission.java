package br.com.gsafj.user;


import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Permission implements GrantedAuthority, Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;

  private String authority;


  @Override
  public String getAuthority() {
    return this.authority;
  }
}
