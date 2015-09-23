package com.gut.practice.service;

import com.gut.practice.entity.Company;
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
public class CompanyService extends BaseService<Company> {

    
    private static final Logger log = LogManager.getLogger(CompanyService.class);
    
    @Override
    public Long add(Company oneNew) {
        try {
            oneNew.setDateCreate(new Date());
//            oneNew.setAuthor(new PortalUser());
            em.persist(oneNew);
            log.debug("Successed added this Company: " + oneNew);
        } catch (EntityExistsException e) {
            log.warn("Sorry, Opinion exist in DataBase! " + e.toString());
        } catch (Exception e) {
            log.warn("Sorry, can't add this Company " + e.toString());
        }
        return oneNew.getId();
    }

    @Override
    public Boolean edit(Company oneCompany) {
        try {
            Company model = em.find(Company.class, oneCompany.getId());
            model.setAssignation(oneCompany.getAssignation())
                    .setCompanyName(oneCompany.getCompanyName())
                    .setHRemail(oneCompany.getHRemail())
                    .setHRfirstName(oneCompany.getHRfirstName())
                    .setHRlastName(oneCompany.getHRlastName())
                    .setHRphone(oneCompany.getHRphone());
            em.merge(model);
            return true;
        } catch (Exception e) {
            log.warn("Sorry, can't edit this Company ", e);
        };
        return false;
    }

    ;
    
     @Override
    public Company getById(Long id) {
        Company model;
        try {
            model = em.find(Company.class, id);
        } catch (Exception e) {
            model = new Company();
            log.warn("Sorry, can't get Company with id: " + id, e);
        }
        return model;
    }

    @Override
    public List<Company> getAll() {
        log.debug("CompanyService: getAll");
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Company> cq = cb.createQuery(Company.class);
        Root<Company> root = cq.from(Company.class);

        try {
            final List<Company> result = em.createQuery(cq.select(root)).getResultList();
            log.debug("Znaleziono wyników: " + result.size());
            return result;
        } catch (Exception e) {
            log.warn("Sorry, can't get all Company " + e);
        }
        return new ArrayList<Company>();
    }

    @Override
    public Boolean remove(Long id) {
        try {
            Company model = em.find(Company.class, id);
            em.remove(model);
            return true;
        } catch (Exception e) {
            log.warn("Sorry, can't remove this New ", e);
        }
        return false;
    }
}
