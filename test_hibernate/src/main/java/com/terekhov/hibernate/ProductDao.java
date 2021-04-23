package com.terekhov.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.util.List;

public class ProductDao {

    public static void main(String[] args) {

        init();

    }

    public static void init(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
        Session session = null;
        try{
            Product product1 = new Product("MacBook", "Ultra low and Great Power", new BigDecimal(3000));
            Product product2 = new Product( "iPhone", "The most expensive phone by credit", new BigDecimal(1000));
            Product product3 = new Product("iPad", "More size - more cost", new BigDecimal(2000));
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.save(product1);
            session.save(product2);
            session.save(product3);
            session.getTransaction().commit();

        }finally {
            session.close();
            factory.close();
        }
    }

    public List<Product> findAll() {
             SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
        Session session = null;

        try{
            session = factory.getCurrentSession();
            session.beginTransaction();
            List<Product> listProduct = session
                    .createQuery("from Product").getResultList();
            session.getTransaction().commit();
            return listProduct;
        }finally {
            session.close();
            factory.close();
        }
    }

    public Product findById ( long id){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
        Session session = null;
        Product product;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        } finally {
            session.close();
            factory.close();
        }
    }


    public void saveOrUpdate(Product product) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Product product1 = session.get(Product.class, product.getId());
            product1.setName(product.getName());
            product1.setDescription(product.getDescription());
            product1.setPrice(product.getPrice());
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
}

    public void remove(long id) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
        Session session = null;
        try{
            session = factory.getCurrentSession();
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }
    }


}
