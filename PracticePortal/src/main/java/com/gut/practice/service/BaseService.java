/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.service;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author janusz & kongo
 */

public abstract class BaseService<T>  implements Serializable{
    @PersistenceContext
    protected EntityManager em;
    
     
    public abstract Long add (T d);
    public abstract Boolean edit(T d);
    public abstract T getById (Long id);
    public abstract List<T> getAll ();
    public abstract Boolean remove (Long id);
   
}
