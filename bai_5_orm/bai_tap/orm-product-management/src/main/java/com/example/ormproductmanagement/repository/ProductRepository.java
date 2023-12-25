package com.example.ormproductmanagement.repository;

import com.example.ormproductmanagement.model.Product;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductRepository implements IProductRepository{
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Product> findAll() {
        String queryS = "SELECT c FROM Product AS c";
        TypedQuery<Product> query =entityManager.createQuery(queryS, Product.class);
        return query.getResultList();
    }

    @Override
    public void save(Product product) {
        Transaction transaction = null;
        Product productTemp;
        System.out.println(product.getId());
        if (product.getId() == 0){
            productTemp = new Product();
        }else {
            productTemp = findById(product.getId());
        }
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            productTemp.setName(product.getName());
            productTemp.setPrice(product.getPrice());
            productTemp.setDetail(product.getDetail());
            productTemp.setManufacturer(product.getManufacturer());
            session.saveOrUpdate(productTemp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }

    }

    @Override
    public Product findById(int id) {
        String queryS = "SELECT c FROM Product c WHERE c.id = :id";
        TypedQuery<Product> query =entityManager.createQuery(queryS, Product.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void remove(int id) {
        Product product = findById(id);
        if (product != null) {
            Transaction transaction = null;
            try (Session session = sessionFactory.openSession()) {
                transaction = session.beginTransaction();
                session.remove(product);
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
                if (transaction != null) {
                    transaction.rollback();
                }
            }
        }
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = findAll();
        List<Product> returnList = new ArrayList<>();
        for (Product p: products){
            if (p.getName().toLowerCase().contains(name.toLowerCase())){
                returnList.add(p);
            }
        }
        return returnList;
    }

    @Override
    public List<Product> sort() {
        List<Product> products = findAll();
        products.sort(Comparator.comparing(Product::getPrice));
        return products;
    }

    @Override
    public List<Product> sortByName() {
        List<Product> products = findAll();
        products.sort(Comparator.comparing(Product::getName));
        return products;
    }
}
