package com.inn.navin.jwt.user.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "user")
public class User implements UserDetails{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "userId")
  private Integer id;

  @Column(name = "userName", length = 30, nullable = false)
  private String name;

  @Column(name = "userEmail", length = 25, nullable = false)
  private String email;

  @Column(name = "userPassword", length = 255, nullable = false)
  private String password;

  @Column(name = "userRole", nullable = false)
  private String role;

  @Column(name = "userDeleted")
  private boolean deleted = false;

  @ManyToMany
  //@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role", referencedColumnName = "id"))
  private Set<Role> roles = new HashSet<>();

  public User() {
    super();
  }

  public Integer getUid() {
    return id;
  }

  public void setUid(Integer uid) {
    this.id = uid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public boolean getDeleted() {
    return deleted;
  }

  public void setDeleted(boolean deleted) {
    this.deleted = deleted;
  }

  public User(Integer id, String name, String email, String password, String role, boolean deleted) {
    super();
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
    this.role = role;
    this.deleted = deleted;
  }

  @Override
  public String toString() {
    return "User [uid=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
        + ", deleted=" + deleted + "]";
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<SimpleGrantedAuthority> authorities=this.roles.stream().map((role)-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    return authorities;
  }

  @Override
  public String getUsername() {
    return this.email;
  }

  @Override
  public boolean isAccountNonExpired() {
   return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
  return true;  
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
