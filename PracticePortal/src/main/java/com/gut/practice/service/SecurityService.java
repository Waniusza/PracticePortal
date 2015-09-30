/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.service;

import com.gut.practice.entity.user.PortalUser;
import com.gut.practice.service.login.User;
import com.gut.practice.helpers.util.Permission;
import javax.ejb.Stateless;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author janusz
 */
/** API dla zarządzania użytkownikami
 * 
 * signUpStudent - rejestracja użytkownika 
 * *** IN ***
 * String login
 * String pass
 * Long PG_ID   - może być nullem jeśli nie posiada
 * *** UWAGI ***
 * Tu automatycznie jest dodawane pole 
 * Permission permision = Permission.STUDENT;
 * *** OUT ***
 * boolean ok = true/false;
 * 
 * signUpCoordinator - rejestracja koordynatora 
 * *** IN ***
 * String login
 * String pass
 * Long PG_ID   - może być nullem jeśli nie posiada
 * *** UWAGI ***
 * Tu automatycznie jest dodawane pole 
 * Permission permision = Permission.DOORDINATOR;
 * *** OUT ***
 * boolean ok = true/false;
 * 
 * signUpEmployeer - rejestracja koordynatora pracodawcy
 * *** IN ***
 * String login
 * String pass
 * String firstName 
 * String lastName 
 * Company company 
 // TODO : obsługa zarządzania firmami (na początek wystarczy dodawanie i pobieranie listy firm
 * *** UWAGI ***
 * Tu automatycznie jest dodawane pole 
 * Permission permision = Permission.DOORDINATOR;
 * *** OUT ***
 * boolean ok = true/false;
 * 
 * singIn- logowanie
 * *** IN ***
 * String login
 * String pass
 * *** UWAGI ***
 * - trzeba jakoś w sesji przechować informację że użytkownik jest zalogowany
 * (Nasze manager'y i servisy są @SessionScoped, co chyba znaczy że mogą zapamiętywać dane tak długo jak długo sesia trwa)
 * - nie wolno zwracać za dużo danych użytkownikowi - dla bezpieczeństwa
 * (nie mam póki co pomysłu jak to rozwiązać)
 * *** OUT ***
 * 
 * 
 * singOut- wylogowanie
 * *** IN ***
 * - w parametrach wejściowych będzie to co metoda logowania zwraca
 * *** UWAGI ***
 * - także wyczyszczenie sesii
 * *** OUT ***
 * boolean ok = true/false;
 * 
 * 
 * isPermissed- wylogowanie
 * *** IN ***
 * - w parametrach wejściowych będzie to co metoda logowania zwraca
 * Permission perm;
 * *** UWAGI ***
 * *** OUT ***
 * boolean permissed = true/false;
 * 
 * 
 * getUser - dane użytkownika np do edycji konta
 * *** IN ***
 * - w parametrach wejściowych będzie to co metoda logowania zwraca
 * *** UWAGI ***
 * *** OUT ***
 * Dane użytkownika be z hasła
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
    public PortalUser sinIn(String name, String pass) {
        // hasło powinno już przychodzić zaszyfrowane
        // Znalezienie użytkownika jeśli istnieje
        
        //TODO zmienić \/
        return new PortalUser();
        // w przeciwnym wypadku null
//        return null;

    }
    
        // Wylogowanie
    public PortalUser sinOut(String name, String pass) {
        // hasło powinno już przychodzić zaszyfrowane
        // Znalezienie użytkownika jeśli istnieje
        
        return new PortalUser();
        // w przeciwnym wypadku null
//        return null;

    }

    public boolean isPermissed(User user, Permission permission) {
        // Sprawdzenie czy użytkownik posiada dane uprawnienia
        return false;
    }

}
