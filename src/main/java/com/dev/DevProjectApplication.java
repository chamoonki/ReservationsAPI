package com.dev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.dev.model.auth.Oauth;
import com.dev.service.auth.form.OauthService;
import com.dev.utils.auth.OauthTokenUtil;
import com.google.gson.Gson;

@SpringBootApplication
public class DevProjectApplication implements CommandLineRunner  {

	@Autowired
	private OauthService oauthService;
	
	PasswordEncoder encoder = new BCryptPasswordEncoder();
	
    public static void main(String[] args) {
       SpringApplication.run(DevProjectApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		
		// TODO : 최초 토큰 강제 주입 (인증서버 분리를 안했기때문에 현재로는 강제 주입해준다.)
		// TODO : 추후 oAuth 분리하게 되면 수정 해야 한다, 
		OauthTokenUtil token = new OauthTokenUtil();
		String admin_token = token.getResourceCredentials("admin", "admin");
		String user_token = token.getResourceCredentials("user", "password");
//		String center_token = token.getResourceCredentials("devDirector", "admin");
		
//		System.out.println(center_token);
		
		// 토큰 DB 저장
		// Json으로 받아온 결과를 객체로 변환하기 위해 Gson 생성
		Gson gson = new Gson();
		// Json -> Object로 변환 후 oauth Model에 넣어 준다.
		Oauth admin_oauth = gson.fromJson(admin_token, Oauth.class);
		admin_oauth.setId("dev_admin_token");
		oauthService.updateById("dev_admin_token", admin_oauth);
		
		Oauth user_oauth = gson.fromJson(user_token, Oauth.class);
		user_oauth.setId("dev_user_token"); 
		oauthService.updateById("dev_user_token", user_oauth);
	}


}
