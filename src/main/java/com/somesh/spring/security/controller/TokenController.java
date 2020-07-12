/**
 * 
 */
package com.somesh.spring.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.somesh.spring.security.model.AuthenticationRequest;
import com.somesh.spring.security.model.AuthenticationResponse;
import com.somesh.spring.security.services.MyUserDetailsService;
import com.somesh.spring.security.util.JwtUtil;

/**
 * @author ksomalin
 *
 */
@Controller
public class TokenController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsService myUserDetailsService;

	@Autowired
	private JwtUtil util;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> createAuthenticatedToken(@RequestBody AuthenticationRequest request) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect UserName & Password", e);
		}

		UserDetails userDeatils = myUserDetailsService.loadUserByUsername(request.getUsername());

		String jwtToken = util.generateToken(userDeatils);

		return ResponseEntity.ok(new AuthenticationResponse(jwtToken));

	}

}
