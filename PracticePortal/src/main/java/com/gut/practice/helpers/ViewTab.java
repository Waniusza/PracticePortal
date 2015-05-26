/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.helpers;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author janusz
 */
@Getter
@Setter
public class ViewTab {
    
    private String title;
    private String includeResource;

    public ViewTab() {
    }

    public ViewTab(String title, String includeResource) {
        this.title = title;
        this.includeResource = includeResource;
    }
    
    
    
}
