package com.example.jpablog.repository;

import com.example.jpablog.model.Blog;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BlogRepository implements IBlogRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> query = entityManager.createQuery("from Blog", Blog.class);
        return query.getResultList();
    }

    @Override
    public void save(Blog blog) {
        if (blog.getId() == null){
            entityManager.persist(blog);
        }else {
            entityManager.merge(blog);
        }
    }

    @Override
    public void remove(Blog blog) {
        if (blog != null){
            entityManager.remove(blog);
        }
    }

    @Override
    public Blog findById(Long id) {
        TypedQuery<Blog> query = entityManager.createQuery("select c from Blog c where id = :id", Blog.class);
        query.setParameter("id",id);
        System.out.println(query.getSingleResult());
        return query.getSingleResult();
    }
}
