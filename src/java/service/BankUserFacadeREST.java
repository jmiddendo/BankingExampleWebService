/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import fit5042.tutex.rest.entities.BankUser;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jmid3
 */
@Stateless
@Path("fit5042.tutex.rest.entities.bankuser")
public class BankUserFacadeREST extends AbstractFacade<BankUser> {

    @PersistenceContext(unitName = "HD-Student-restPU")
    private EntityManager em;

    public BankUserFacadeREST() {
        super(BankUser.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(BankUser entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, BankUser entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public BankUser find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<BankUser> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<BankUser> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @GET
    @Path("findByBankUser/{bankUserId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BankUser> findByBankUserId(@PathParam("bankUserId") Integer bankUserId) {
        Query query = em.createNamedQuery("BankUser.findByBankUserId");
        query.setParameter("bankUserId", bankUserId);
        return query.getResultList();
    }
    
    @GET
    @Path("findByType/{type}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BankUser> findByType(@PathParam("type") String type) {
        Query query = em.createNamedQuery("BankUser.findByType");
        query.setParameter("type", type);
        return query.getResultList();
    }
        
    @GET
    @Path("findByEmail/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BankUser> findByEmail(@PathParam("email") String email) {
        Query query = em.createNamedQuery("BankUser.findByEmail");
        query.setParameter("email", email);
        return query.getResultList();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
