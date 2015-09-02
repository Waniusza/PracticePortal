package com.gut.practice.service.login;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

/**
 *
 * @author kongo
 */
public class AuthenticationTest {
    private static String INPUTFILE = "src/main/resources/jaas.config";
    
    public static void main(String[] args) {
		System.setProperty("java.security.auth.login.config", INPUTFILE);

		String name = "myName";
		String password = "myPassword";

		try {
			LoginContext lc = new LoginContext("Test", new MyCallbackHandler(name, password));
			lc.login();
		} catch (LoginException e) {
			e.printStackTrace();
		}
	}
}
