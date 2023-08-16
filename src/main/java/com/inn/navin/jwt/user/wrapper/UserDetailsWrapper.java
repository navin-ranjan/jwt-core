package com.inn.navin.jwt.user.wrapper;

public class UserDetailsWrapper {

  private Integer id;
	private String name;
	private String email;
	private String password;
	private String token;
	private String role;
	
	
	
	@Override
  public String toString() {
    return "UserDetailsWrapper [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
        + ", token=" + token + ", role=" + role + "]";
  }
	

  public Integer getId() {
    return id;
  }


  public void setId(Integer id) {
    this.id = id;
  }


  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
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


  public UserDetailsWrapper(Integer id, String name, String email, String password, String token, String role) {
    super();
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
    this.token = token;
    this.role = role;
  }
	
	
//  public UserDetailsWrapper(String name, String email, String password, String token) {
//    super();
//    this.name = name;
//    this.email = email;
//    this.password = password;
//    this.token = token;
//  }

  

}
