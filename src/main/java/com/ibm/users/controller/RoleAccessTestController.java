package com.ibm.users.controller;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.users.utils.ResponseBean;

/**
 * @author BoZhang
 * E-mail:dlzbo@cn.ibm.com
 * @version date：May 12, 2020 7:54:52 PM
*/
@CrossOrigin
@RestController
public class RoleAccessTestController {

	  // for admin role only
	  @RequestMapping(value = "smc/secure/admin", method = RequestMethod.GET)
	  @ResponseBody
	  public ResponseEntity<ResponseBean> authenticatedAdmin() throws Exception {
	      return ResponseEntity.ok().body(new ResponseBean(OK.value(), OK.getReasonPhrase()).data("AUTHENTICATED - ADMIN VERIFIED"));
	  }
	  
	  // for both admin and user roles
	  @RequestMapping(value = "smc/secure/user", method = RequestMethod.GET)
	  @ResponseBody
	  public ResponseEntity<ResponseBean> authenticatedUser() throws Exception {
	      return ResponseEntity.ok().body(new ResponseBean(OK.value(), OK.getReasonPhrase()).data("AUTHENTICATED - USER VERIFIED"));
	  }
	  
}
