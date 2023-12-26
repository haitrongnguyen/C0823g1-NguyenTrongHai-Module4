package com.example.jpacustomermanagement.repository;

import com.example.jpacustomermanagement.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Repository
public class CustomerRepository implements ICustomerRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c", Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(Long id) {
        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c where id = :id", Customer.class).setParameter("id",id);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void save(Customer customer) {
        System.out.println(customer.getId());
        if (customer.getId() == null){
            entityManager.persist(customer);
        }else {
            entityManager.merge(customer);
        }
    }

    @Override
    public void remove(Long id) {
        Customer customer = findById(id);
        if (customer != null){
            entityManager.remove(customer);
        }
    }
}
