package com.gut.practice.service;

import com.gut.practice.helpers.Configuration;
import com.gut.practice.helpers.JsonHelper;
import com.gut.practice.structs.Faq;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.bean.SessionScoped;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author kongo
 */
@Stateless
@SessionScoped
public class FaqService {
    private static final Logger log = LogManager.getLogger(FaqService.class);

    public List<Faq> getAll() {
        log.debug("getAll");
        List<Faq> result = new ArrayList<>();
        JSONArray jsonData = new JSONArray();
        try {
            String data = JsonHelper.readFromResourcee(Configuration.FAQ_SRC);
            jsonData = new JSONArray(data);
            log.debug("Got JsonArray length -" + jsonData.length());
        } catch (JSONException e) {
            log.warn("Sorry, can't get all Faq JSONException" + e);
        }
        for (int i = 0; i < jsonData.length(); i++) {
            JSONObject temp = (JSONObject) jsonData.get(i);
            Faq q = new Faq().setQuestion(temp.getString("question")).setAnswer(temp.getString("answer"));
            result.add(q);
        }

        return result;
    }

}
