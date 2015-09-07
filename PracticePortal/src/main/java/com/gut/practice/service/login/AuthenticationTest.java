package com.gut.practice.service.login;

import com.gut.practice.entity.user.PortalUser;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

/**
 *
 * @author kongo
 */
public class AuthenticationTest {
    private static String INPUTFILE = "src/main/resources/jaas.config";
    public static DataSource dataSource;
	
    public static void main(String[] args) {
	dataSource = new DataSource();
		
	System.setProperty("java.security.auth.login.config", INPUTFILE);

	String name = "user";
	String password = "1234";
		
	PortalUser user = new PortalUser();
	user.setName(name);
	user.setPassword(password);
	try {
            //LoginContext lc = new LoginContext("Test", new MyCallbackHandler(name, password));
            LoginContext lc = new LoginContext("Test", new MyCallbackHandler(user));
            lc.login();
	} catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
