package net.adonika.chicken;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//TODO java9버전 이상에서, transaction 관련 Deprecated가 진행되버려서 jUnit 테스트에 장애가 발생됨
public class ChickenRestApplicationTests {
	
	//@Test
	public void contextLoads() {
	}
	
	public static void main(String[] args) {
		String password = "1234";
		System.out.println("EncodedPassword: " + new BCryptPasswordEncoder().encode(password));
	}

}
