package com.smc.users.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smc.users.entity.Userinfolist;
import com.smc.users.repository.UsersRepository;

/**
 * @author BoZhang
 * E-mail:dlzbo@cn.ibm.com
 * @version date：May 12, 2020 7:56:30 PM
*/
@Service
public class UsersService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	public Userinfolist getUserOfUsername(String username) {
		return usersRepository.findByUsername(username);
	}
	
	// public Userinfolist getUserByEmail(String email) {
	//   return usersRepository.findByEmail(email);
	// }
	
	//    #########################################################################################
	
	public int setConfirmedByUsername(String username, String confirmed) {
		return usersRepository.saveUsersByUsernameAndConfirmed(username, "1");
	};
	
	public Userinfolist saveUsersInfo(Userinfolist users) {
		return usersRepository.save(users);
	};

	public int setLastupdateByUsername(String username, Date lastupdate) {
		return usersRepository.saveUsersByUsernameAndLastupdate(username, lastupdate);
	};

	public Userinfolist getUserByUsernameAndPassword(String username, String password) {
		return usersRepository.findByUsernameAndPassword(username,password);
	}
    
}