package com.gut.practice.service.login;

import com.gut.practice.entity.user.PortalUser;
import java.io.IOException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

/**
 *
 * @author kongo
 */
public class MyCallbackHandler implements CallbackHandler {

    String name;
    String password;

    public MyCallbackHandler(String name, String password) {
	this.name = name;
	this.password = password;
    }
    
    public MyCallbackHandler(PortalUser user) {
	this.name = user.getName();
	this.password = user.getPassword();
    }

    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
	//System.out.println("Callback Handler - handle called");
	for (int i = 0; i < callbacks.length; i++) {
            if (callbacks[i] instanceof NameCallback) {
                NameCallback nameCallback = (NameCallback) callbacks[i];
                nameCallback.setName(name);
            } else if (callbacks[i] instanceof PasswordCallback) {
                PasswordCallback passwordCallback = (PasswordCallback) callbacks[i];
                passwordCallback.setPassword(password.toCharArray());
            } else {
                throw new UnsupportedCallbackException(callbacks[i], "The submitted Callback is unsupported");
            }
        }
    }
}