/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.service;

import com.gut.practice.service.login.User;
import com.gut.practice.util.Permission;
import javax.ejb.Stateless;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author janusz
 */
@Stateless
@SessionScoped
public class SecurityService {

    
    // Zarejestrowanie - nazewnictwo zgodnie z gitHub'em :)
    public Long signUp(User user) {

        // Dodanie użykownika
        return (long) 0;
    }

    // Zalogowanie
    public User sinIn(String name, String pass) {
        // hasło powinno już przychodzić zaszyfrowane

        // Znalezienie użytkownika jeśli istnieje
        return new User();
        // w przeciwnym wypadku null
//        return null;

    }

    // Wylogowanie
    public User sinOut(String name, String pass) {
        // hasło powinno już przychodzić zaszyfrowane

        // Znalezienie użytkownika jeśli istnieje
        return new User();
        // w przeciwnym wypadku null
//        return null;

    }

    public boolean isPermissed(User user, Permission permission) {
        // Sprawdzenie czy użytkownik posiada dane uprawnienia
        return false;
    }

}
