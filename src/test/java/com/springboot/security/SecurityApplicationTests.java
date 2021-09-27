package com.springboot.security;

import com.springboot.security.domain.user.UserInfo;
import com.springboot.security.repository.user.UserRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.TestExecutionEvent;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import  org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import  org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import  org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@SpringBootTest
@AutoConfigureMockMvc
class SecurityApplicationTests {

	@Autowired
    MockMvc mockMvc;

	@Autowired
	public UserRepository userRepository;
	private Long TEST_ACCOUNT_CODE;



	@BeforeTransaction
	public void setupAccount() {
		TEST_ACCOUNT_CODE = userRepository.save(UserInfo.builder().email("test@naver.com").auth("USER").password("password").build())
				.getCode();
	}
	
	@AfterTransaction
	public void clearAccount() {
		userRepository.deleteById(TEST_ACCOUNT_CODE);
	}
	


	
	@Test
	@DisplayName("WithMockUser를 이용한 security 테스트")
	@WithMockUser(username = "Mock테스트계정", password = "test", roles = {"USER","ADMIN"})
	public void test_security_with_WithMockUser() throws Exception {
		// given
		// userRepository.save(UserInfo.builder().email("test@naver.com").auth("ADMIN").password("password").build())
		// 		.getCode();

		// // when
		// UserInfo findUser = userRepository.findByEmail("test@naver.com").get();
		// List<UserInfo> findAll = userRepository.findAll();

		// // then
		// Assertions.assertThat(findUser.getEmail()).isEqualTo("test@naver.com");
		// Assertions.assertThat(findUser.getAuth()).isEqualTo("ADMIN");
		// Assertions.assertThat(findAll.size()).isEqualTo(1);



		mockMvc.perform(MockMvcRequestBuilders.get("/"))
				.andExpect(status().isOk())
				.andDo(print());
			
						
						
	}
	

	@Test
	@DisplayName("WithAnonymousUser를 이용한 security 테스트")
	@WithAnonymousUser()
	public void test_security_with_WithAnonymousUser() throws Exception {
	
		mockMvc.perform(MockMvcRequestBuilders.get("/"))
				.andExpect(MockMvcResultMatchers.redirectedUrl("/"))
				.andDo(print());


	
	}
	

	@WithUserDetails(value = "test@naver.com")
	@Test
	public void test_security_with_WithUserDetails() throws Exception{
		
		UserInfo findUser = userRepository.findById(TEST_ACCOUNT_CODE).get();
		Assertions.assertThat(findUser.getEmail()).isEqualTo("test@naver.com");
	}

}
