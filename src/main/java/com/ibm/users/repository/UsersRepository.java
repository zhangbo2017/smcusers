package com.ibm.users.repository;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ibm.users.entity.Userinfolist;

/**
 * @author BoZhang
 * E-mail:dlzbo@cn.ibm.com
 * @version date：May 12, 2020 7:56:20 PM
*/
public interface UsersRepository extends JpaRepository<Userinfolist, Integer> {
		
	Userinfolist findByUsername(String username);
	// Userinfolist findByEmail(String email);
	
//	#########################################################################
  

 
 @Modifying
 @Transactional
 @Query("update Userinfolist u set u.confirmed = :confirmed where u.username=:username")
 int saveUsersByUsernameAndConfirmed(@Param("username") String username, @Param("confirmed") String confirmed);

 @Modifying
 @Transactional
 @Query("update Userinfolist u set u.lastupdate = :lastupdate where u.username=:username")
 int saveUsersByUsernameAndLastupdate(@Param("username") String username, @Param("lastupdate") Date lastupdate);

 Userinfolist findByUsernameAndPassword(String username, String password);

// @GeneratedValue(strategy = GenerationType.IDENTITY)
// Userinfolist saveUsers(Userinfolist users);
 
  
}