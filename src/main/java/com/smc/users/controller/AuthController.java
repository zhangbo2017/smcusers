package com.smc.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.smc.users.constant.Const;
import com.smc.users.entity.Userinfolist;
import com.smc.users.model.AuthRequest;
import com.smc.users.service.UsersService;
import com.smc.users.utils.CommonResult;
import com.smc.users.utils.ResponseBean;

import java.util.Date;
import static org.springframework.http.HttpStatus.*;

/**
 * @author BoZhang
 * E-mail:dlzbo@cn.ibm.com
 * @version date：May 12, 2020 7:54:48 PM
*/
@CrossOrigin
@RestController
//@RequestMapping(value = "api/smc/secure", produces = MediaType.APPLICATION_JSON_VALUE) // 可访问api/smc/secure/login
public class AuthController {

//  @Autowired
//  private SmcUserDetailsService smcuserDetailsService;
//  @Autowired
//  private AuthenticationManager authenticationManager;
  @Autowired
  private UsersService usersService;

//  @PostMapping("/login")
//  public ResponseEntity<CommonResult> login(@RequestBody AuthRequest request) throws Exception {
//
////    Authentication authentication = authenticationManager
////        .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
////
////    SecurityContextHolder.getContext().setAuthentication(authentication);
//
//    // Reload password post-security so we can generate token
////    UserDetails userDetails = smcuserDetailsService.loadUserByUsername(request.getUsername());
//	  Userinfolist userinfolist = usersService.getUserByUsername(request.getUsername());
//	  if(userinfolist.getPassword() !=request.getPassword()) {
//		  return ResponseEntity.ok().body(CommonResult.build(Const.COMMONRESULT_ERROR_CODE, "password is wrong!!"));
//	  }
//    // login, changepw, logout will update lastupdate column
//    if(!(usersService.setLastupdateByUsername(request.getUsername(), new Date())>0)) {
//    	return ResponseEntity.ok().body(CommonResult.build(Const.COMMONRESULT_ERROR_CODE, "database error, please wait a moment and retry or contact with system admin!"));
//    }
//
////    String jwtToken = JwtTokenUtil.generateToken(userDetails, false);
////    System.out.println("jwtToken >>>>"+jwtToken);
//    
////    AuthResponse authResponse = new AuthResponse();
////    authResponse.setUsername(userDetails.getUsername());
////    Set<GrantedAuthority> authorities = (Set<GrantedAuthority>) userDetails.getAuthorities();
////    authResponse.setUsertype(authorities.toArray()[0].toString());
////    authResponse.setJwtToken(jwtToken);
//    
//    return ResponseEntity.ok().body(CommonResult.build(Const.COMMONRESULT_OK_CODE, "Login successfully!", userinfolist));
//  }

  @RequestMapping(value = "/haslogin", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<CommonResult> haslogin(@RequestBody AuthRequest request) throws Exception {
//	    Authentication authentication = authenticationManager
//	            .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
//
//	        SecurityContextHolder.getContext().setAuthentication(authentication);

	        // Reload password post-security so we can generate token
//	        UserDetails userDetails = smcuserDetailsService.loadUserByUsername(request.getUsername());
//	  	if(!(usersService.getUserByUsernameAndPassword(request.getUsername(),request.getPassword())>0)) {
//        	return ResponseEntity.ok().body(CommonResult.build(Const.COMMONRESULT_ERROR_CODE, "database error, please wait a moment and retry or contact with system admin!"));
//        }
	        Userinfolist userinfolist = usersService.getUserByUsernameAndPassword(request.getUsername(),request.getPassword());
		  	if(userinfolist != null) {
		  		 // login, changepw, logout will update lastupdate column
		  		if(!(usersService.setLastupdateByUsername(request.getUsername(), new Date())>0)) {
		        	return ResponseEntity.ok().body(CommonResult.build(Const.COMMONRESULT_ERROR_CODE, "database error, please wait a moment and retry or contact with system admin!"));
		        }
        	return ResponseEntity.ok().body(CommonResult.build(Const.COMMONRESULT_OK_CODE, "valid User and Password"));
        }else {
        	return ResponseEntity.ok().body(CommonResult.build(Const.COMMONRESULT_ERROR_CODE, "Invaild User or Password!,Please retry"));
        }
	       
	        
	     
  }
  
  @RequestMapping(value = "/getUser", method = RequestMethod.POST)
  public Userinfolist getUserByUsername(@RequestParam("username") String username) throws Exception {

	  Userinfolist userinfolist=this.usersService.getUserByUsername(username);
	  return userinfolist;
  }
  
  // use for test
  @RequestMapping(value = "/authenticated", method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity<ResponseBean> authenticated() throws Exception {
      return ResponseEntity.ok().body(new ResponseBean(OK.value(), OK.getReasonPhrase()).data("AUTHENTICATED - hasToken VERIFIED"));
  }
  
  // use for test
  @RequestMapping(value = "/admin", method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity<ResponseBean> isAdmin() throws Exception {
      return ResponseEntity.ok().body(new ResponseBean(OK.value(), OK.getReasonPhrase()).data("AUTHENTICATED - isAdmin VERIFIED"));
  }
  
  // use for test
  @RequestMapping(value = "/sayhello")
  public String sayhello() throws Exception {
      return "hello";
  }

//  @ExceptionHandler(AuthenticationException.class)
//  @ResponseStatus(UNAUTHORIZED)
//  public ResponseEntity<ResponseBean> handleAuthentication401Exception(AuthenticationException exception) throws Exception {
//    return ResponseEntity.status(UNAUTHORIZED)
//    	.body(new ResponseBean(UNAUTHORIZED.value(), UNAUTHORIZED.getReasonPhrase()).error(exception.getMessage()));
//  }
//
//  @ExceptionHandler(AuthenticationException.class)
//  @ResponseStatus(FORBIDDEN)
//  public ResponseEntity<ResponseBean> handleAuthentication403Exception(AuthenticationException exception) throws Exception {
//    return ResponseEntity.status(FORBIDDEN)
//    	.body(new ResponseBean(FORBIDDEN.value(), FORBIDDEN.getReasonPhrase()).error(exception.getMessage()));
//  }

}
