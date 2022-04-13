package com.dev.utils.auth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.regex.Pattern;

/**
 * oAuth를 만들기 위한 Fake Util
 * 
 * @FileName : OauthTokenUtil.java
 * @Project : api
 * @author : moonki
 * @date   : 2019. 10. 3.
 */
public class OauthTokenUtil {

	private static final Pattern pat = Pattern.compile(".*\"access_token\"\\s*:\\s*\"([^\"]+)\".*");
	private static final String clientId = "rms-client";		//clientId
	private static final String clientSecret = "rms-secret";	//client secret
	private static final String tokenUrl = "http://localhost:8300/oauth/token";
	private static final String auth = clientId + ":" + clientSecret;
	private static final String authentication = Base64.getEncoder().encodeToString(auth.getBytes());
	
	/**
	 * oAuth 생성 하는 함수
	 * 
	 * @Method Name : getResourceCredentials
	 * @author  	: moonki
	 * @date		: 2019. 10. 3.
	 * @param userName
	 * @param password
	 * @return
	 */
	public static String getResourceCredentials(String userName, String password) {
		//		System.out.println("Basic " + authentication);
		
	    String content = "grant_type=password&username=" + userName + "&password=" + password;
	    BufferedReader reader = null;
	    HttpURLConnection connection = null;
	    String returnValue = "";
	    try {
	    	URL url = new URL(tokenUrl);
	        connection = (HttpURLConnection) url.openConnection();
	        connection.setRequestMethod("POST");
	        connection.setDoOutput(true);
	        connection.setRequestProperty("Authorization", "Basic " + authentication);
	        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	        connection.setRequestProperty("Accept", "application/json");
	        PrintStream os = new PrintStream(connection.getOutputStream());
	        os.print(content);
	        os.close();
	        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        String line = null;
	        StringWriter out = new StringWriter(connection.getContentLength() > 0 ? connection.getContentLength() : 2048);
	        while ((line = reader.readLine()) != null) {
	            out.append(line);
	        }
	        returnValue = out.toString();
	    } catch (Exception e) {
	        System.out.println("Error : " + e.getMessage());
	    } finally {
	        if (reader != null) {
	            try {
	                reader.close();
	            } catch (IOException e) {
	            }
	        }
	        connection.disconnect();
	    }
	    return returnValue;
	}
	
}
