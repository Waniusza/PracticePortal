package com.gut.practice.service;

import com.gut.practice.helpers.JsonHelper;
import javax.ejb.Stateless;
import javax.faces.bean.SessionScoped;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.simple.JSONArray;

/**
 *
 * @author kongo
 */
@Stateless
@SessionScoped
public class FaqService {

    final static String PATH = "constants/FAQ.json";

    
    private static final Logger log = LogManager.getLogger(FaqService.class);
    
    public JSONArray getAll() {
        JSONArray result = new JSONArray();
        try {
            String data = JsonHelper.readFromResource(PATH);
            log.debug("Get JsonArray data  -" + data);
//            result = new JSONArray(data);
            log.debug("Get JsonArray result -" + result);
        } catch (JSONException e) {
            log.warn("Sorry, can't get all Faq JSONException" + e);
        }

        return result;
    }

}
