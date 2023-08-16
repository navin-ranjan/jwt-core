package com.inn.navin.jwt.user.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inn.navin.jwt.user.dao.UserDao;
import com.inn.navin.jwt.user.model.User;
import com.inn.navin.jwt.user.wrapper.UserDetailsWrapper;

@RestController
@CrossOrigin("*")
public class JwtController {
	
	@Autowired
	private JwtUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtTokenUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDao userDao;
	
	
	//generate token

    @RequestMapping(value ="/token", method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody User user) throws Exception {

    	System.out.println(user);
    	
    	try {
    		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("bad Credentials");
		}    	
    	
    	UserDetails userDetails=customUserDetailsService.loadUserByUsername(user.getEmail());
    	String token =jwtUtil.generateToken(userDetails);
    	User holdUser=userDao.getUserDetails(null, user.getEmail(), null);
    	UserDetailsWrapper usWrapper=new UserDetailsWrapper( holdUser.getUid(),holdUser.getName(), holdUser.getEmail(), null, token,holdUser.getRole());
    	
        return ResponseEntity.ok(usWrapper);
    }

}
