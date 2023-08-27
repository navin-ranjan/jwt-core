package com.inn.navin.jwt.user.wrapper;

import java.util.Set;

import com.inn.navin.jwt.user.model.Role;

public class UserDetailsWrapper {

  private Integer id;
	private String name;
	private String email;
	private String password;
	private String token;
	private Set<Role> roles;
	
	
	
	@Override
  public String toString() {
    return "UserDetailsWrapper [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
        + ", token=" + token + ", role=" + roles + "]";
  }
	

  public Integer getId() {
    return id;
  }


  public void setId(Integer id) {
    this.id = id;
  }


  public Set<Role> getRole() {
    return roles;
  }

  public void setRole(Set<Role> roles) {
    this.roles = roles;
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

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}


  public UserDetailsWrapper() {
    super();
    // TODO Auto-generated constructor stub
  }


  public UserDetailsWrapper(Integer id, String name, String email, String password, String token, Set<Role> roles) {
    super();
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
    this.token = token;
    this.roles = roles;
  }
	
	
//  public UserDetailsWrapper(String name, String email, String password, String token) {
//    super();
//    this.name = name;
//    this.email = email;
//    this.password = password;
//    this.token = token;
//  }

  

}
