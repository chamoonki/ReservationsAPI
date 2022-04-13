package com.dev.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
@EnableWebSecurity
public class OAuth2SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private ClientDetailsService clientDetailsService;
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
    public PasswordEncoder noOpPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
	 
	@Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
		
		//인증서버를 분리한게 아니므로 메모리에 강제 인증 유저 삽입 
		auth
	        .inMemoryAuthentication()
	            .withUser("user")
	            .password("password")
	            .roles("USER")
	        .and()
	            .withUser("admin")
	            .password("admin")
	            .roles("USER", "ADMIN");
		
//		String user_query = "SELECT c.director_id AS USERNAME, c.password AS PASSWORD, 'true' " 
//				  + "FROM center_director c "
//				  + "WHERE c.director_id = ?";
//
//		String auth_query =  "SELECT c.director_id AS USERNAME, 'ROLE_USER' " 
//						  + "FROM center_director c "
//						  + "WHERE c.director_id = ?";
//		
//		auth.jdbcAuthentication()
//		.dataSource(dataSource)
//		.passwordEncoder(passwordEncoder())
//		.usersByUsernameQuery(user_query)
//		.authoritiesByUsernameQuery(auth_query);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

	@Bean
	public TokenStore tokenStore() {
		return new InMemoryTokenStore();
	}

	@Bean
	@Autowired
	public TokenStoreUserApprovalHandler userApprovalHandler(TokenStore tokenStore){
		TokenStoreUserApprovalHandler handler = new TokenStoreUserApprovalHandler();
		handler.setTokenStore(tokenStore);
		handler.setRequestFactory(new DefaultOAuth2RequestFactory(clientDetailsService));
		handler.setClientDetailsService(clientDetailsService);
		return handler;
	}
	
	@Bean
	@Autowired
	public ApprovalStore approvalStore(TokenStore tokenStore) throws Exception {
		TokenApprovalStore store = new TokenApprovalStore();
		store.setTokenStore(tokenStore);
		return store;
	}
	
}
