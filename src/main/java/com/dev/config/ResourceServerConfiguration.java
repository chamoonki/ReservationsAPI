package com.dev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.web.session.SessionManagementFilter;

import com.dev.config.filter.CorsFilter;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	private static final String RESOURCE_ID = "my_rest_api";
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(RESOURCE_ID).stateless(false);
	}
	
	@Bean
    CorsFilter corsFilter() {
        CorsFilter filter = new CorsFilter();
        return filter;
    }
	 

	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		//모든 api url에 OAuth 토큰 확인 
		//IP 차단도 같이 코딩 필요		
		http.addFilterBefore(corsFilter(), SessionManagementFilter.class)
		.csrf().disable()
		.anonymous().disable()
		.requestMatchers()
		.antMatchers("/**")
		.and()
		.authorizeRequests()
		
		/*
		 *  차후 client 서버에서만 api server 접근 가능하게 block
		 *  .anyRequest().access("hasIpAddress('0:0:0:0:0:0:0:1')")	
		 *  세부적으로 Admin 권한의 api 별도 구분해야됨
		 *  ex) /centerPayment/modify 결제 수정은 시스템 관리자만 가능 한 API
		 *  	/centerPayment/view	     결제 조회는 원장도 가능한 API
		 */
//		.antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources/**", "/configuration/**", "/swagger-ui.html", "/webjars/**").hasRole("ADMIN")
		.antMatchers("/").hasRole("ADMIN")
		.antMatchers("/authGroup/**").hasRole("ADMIN")		
		.antMatchers("/commonCode/**").hasRole("ADMIN")
		.antMatchers("/management/**").hasRole("USER")
		
		.antMatchers("/center/**").hasRole("USER")
		.antMatchers("/centerDirector/**").hasRole("USER")
		.antMatchers("/centerPayment/**").hasRole("USER")
		.antMatchers("/centerStatus/**").hasRole("USER")
		.antMatchers("/file/**").hasRole("USER")
		
		.antMatchers("/centerConfig/**").hasRole("USER")
		.antMatchers("/healthClass/**").hasRole("USER")
		.antMatchers("/healthClassReserv/**").hasRole("USER")
		.antMatchers("/healthClassSchedule/**").hasRole("USER")
		.antMatchers("/healthClassType/**").hasRole("USER")
		.antMatchers("/locker/**").hasRole("USER")
		.antMatchers("/user/**").hasRole("USER")
		.antMatchers("/userHealthClassStatus/**").hasRole("USER")
		.antMatchers("/userPayment/**").hasRole("USER")
		.antMatchers("/userStatus/**").hasRole("USER")
		
		.antMatchers("/authGroups/**").hasRole("ADMIN")
		.antMatchers("/commonCodes/**").hasRole("ADMIN")
		.antMatchers("/managements/**").hasRole("USER")
		
		.antMatchers("/centers/**").hasRole("USER")
		.antMatchers("/centerDirectors/**").hasRole("USER")
		.antMatchers("/centerPayments/**").hasRole("USER")
		.antMatchers("/centerStatuss/**").hasRole("USER")
		.antMatchers("/files/**").hasRole("USER")
		
		.antMatchers("/centerConfigs/**").hasRole("USER")
		.antMatchers("/healthClasss/**").hasRole("USER")
		.antMatchers("/healthClassReservs/**").hasRole("USER")
		.antMatchers("/healthClassSchedules/**").hasRole("USER")
		.antMatchers("/healthClassTypes/**").hasRole("USER")
		.antMatchers("/lockers/**").hasRole("USER")
		.antMatchers("/users/**").hasRole("USER")
		.antMatchers("/userHealthClassStatuss/**").hasRole("USER")
		.antMatchers("/userPayments/**").hasRole("USER")
		.antMatchers("/userStatuss/**").hasRole("USER")
		.and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
	}

}