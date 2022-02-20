package com.fishingshop.database.impl.hibernate;

import com.fishingshop.database.IOrderDAOI;
import com.fishingshop.model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAOImpl implements IOrderDAOI {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addOrder(Order order) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(order);
            tx.commit();
        } catch (Exception e) {
            if(tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        Session session = this.sessionFactory.openSession();
        Query<Order> query = session.createQuery("FROM com.fishingshop.model.Order WHERE user_id = :userId");
        query.setParameter("userId", userId);
        List<Order> result = query.getResultList();
        session.close();
        return result;
    }
}
