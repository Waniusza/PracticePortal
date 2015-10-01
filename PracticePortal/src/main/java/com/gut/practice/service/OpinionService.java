package com.gut.practice.service;

import com.gut.practice.entity.Opinion;
import com.gut.practice.helpers.util.OpinionName;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityExistsException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author kongo
 */
@Stateless
@SessionScoped
public class OpinionService extends BaseService<Opinion> {

    private final static Logger log = LogManager.getLogger(OpinionService.class);

    @Override
    public Long add(Opinion opinion) {
        try {
            em.persist(opinion);
        } catch (EntityExistsException e) {
            log.warn("Sorry, Opinion exist in DataBase! ", e);
        } catch (Exception e) {
            log.warn("Sorry, can't add tihs Opinion ", e);
        }
        return opinion.getId();
    }

    public Long add(String opinion, OpinionName name) {
        Opinion opn = new Opinion()
                .setText(opinion)
                .setOpinionName(name);
        opn.setDateCreate(new Date());
        try {
            em.persist(opn);
        } catch (EntityExistsException e) {
            log.warn("Sorry, Opinion exist in DataBase! ", e);
        } catch (Exception e) {
            log.warn("Sorry, can't add tihs Opinion ", e);
        }

        log.debug(" saved :" + opn);
        return opn.getId();
    }

    @Override
    public Boolean edit(Opinion opinion) {
        try {
            Opinion model = em.find(Opinion.class, opinion.getId());
            model.setOpinionName(opinion.getOpinion());
            model.setText(opinion.getText());
            model.setAuthor(opinion.getAuthor());
            em.merge(model);
            return true;
        } catch (Exception e) {
            log.warn("Sorry, can't edit this Opinion ", e);
        };
        return false;
    }

    @Override
    public Opinion getById(Long id) {
        Opinion model;
        try {
            model = em.find(Opinion.class, id);
        } catch (Exception e) {
            model = new Opinion();
            log.warn("Sorry, can't get Opinion with id: " + id, e);
        }

        return model;
    }

    @Override
    public List<Opinion> getAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Opinion> cq = cb.createQuery(Opinion.class);
        Root<Opinion> root = cq.from(Opinion.class);

        try {
            return em.createQuery(cq.select(root)).getResultList();
        } catch (Exception e) {
            log.warn("Sorry, can't get all Opinions ", e);
        }
        return new ArrayList<>();
    }

    @Override
    public Boolean remove(Long id) {
        try {
            Opinion model = em.find(Opinion.class, id);
            em.remove(model);
            return true;
        } catch (Exception e) {
            log.warn("Sorry, can't remove this Opinion ", e);
        }
        return false;
    }
}
