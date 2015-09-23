/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.practice.helpers;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author janusz
 */
public class JsonHelper {
    
    private static final Logger log = LogManager.getLogger(JsonHelper.class);
   
        public static String readFromResourcee(String name) {
        log.debug("[readFromResource] -> " + name);
        InputStream is = JsonHelper.class.getClassLoader().getResourceAsStream(name);
        if (is != null) {
            try {
                String jsonData = new String(IOUtils.toByteArray(is));
                log.debug("[readFromResource] file read" + jsonData);
                return jsonData;
            } catch (IOException ex) {
                log.warn("[readFromResource] NSome error when searching real file.", ex);
                return "";
            }
        } else {
            log.warn("[readFromResource] input stream jest nullem");
            return "";
        }
    }

}
