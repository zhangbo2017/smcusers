package com.smc.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@ComponentScan(basePackages = "com.ibm.users.service.*")
//@EnableJpaRepositories(basePackages = "com.ibm.users.repository.*") 
//@EntityScan("com.ibm.users.entity.*")
/**
 * @author BoZhang
 * E-mail:dlzbo@cn.ibm.com
 * @version date：May 12, 2020 7:54:31 PM
*/
@SpringBootApplication
@EnableEurekaClient
public class UsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}

}
