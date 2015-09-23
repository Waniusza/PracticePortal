package com.gut.practice.service;

import com.gut.practice.entity.JobOffer;
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
 * @author janusz
 */
@Stateless
@SessionScoped
public class JobOfferService extends BaseService<JobOffer> {

    private final static Logger log = LogManager.getLogger(JobOfferService.class.getName());

    @Override
    public Long add(JobOffer practice) {
        try {
            
            practice.setDateCreate(new Date());
            em.persist(practice);
            log.debug("Successed added this JobOffer.");
            log.debug("Successed added this JobOffer: " + practice);
        } catch (EntityExistsException e) {
            log.warn("Sorry, JobOffer exist in DataBase! ", e);
        } catch (Exception e) {
            log.warn("Sorry, can't add this JobOffer ", e);
        }
        return practice.getId();
    }

    @Override
    public Boolean edit(JobOffer practice) {
        try {
            JobOffer model = em.find(JobOffer.class, practice.getId());
            model.setCompany(practice.getCompany());
            model.setDateTo(practice.getDateTo());
            model.setMainDuty(practice.getMainDuty());
            model.setSalaryMax(practice.getSalaryMax());
            model.setSalaryMin(practice.getSalaryMin());
            em.merge(model);
            em.flush();
            return true;
        } catch (Exception e) {
            log.warn("Sorry, can't edit this JobOffer ", e);
        };
        return false;
    }

    @Override
    public JobOffer getById(Long id) {
        JobOffer model;
        try {
            model = em.find(JobOffer.class, id);
        } catch (Exception e) {
            model = new JobOffer();
            log.warn("Sorry, can't get JobOffer with id: " + id, e);
        }

        return model;
    }

    @Override
    public List<JobOffer> getAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<JobOffer> cq = cb.createQuery(JobOffer.class);
        Root<JobOffer> root = cq.from(JobOffer.class);

        try {
            List<JobOffer> resultList = em.createQuery(cq.select(root)).getResultList();
            log.debug("I got jobOffers: " + resultList.size());
            return resultList;
        } catch (Exception e) {
            log.warn("Sorry, can't get all JobOffers ", e);
        };
        return new ArrayList<>();
    }

    @Override
    public Boolean remove(Long id) {
        try {
            JobOffer model = em.find(JobOffer.class, id);
            em.remove(model);
            return true;
        } catch (Exception e) {
            log.warn("Sorry, can't remove this JobOffer ", e);
        }
        return false;
    }

}
