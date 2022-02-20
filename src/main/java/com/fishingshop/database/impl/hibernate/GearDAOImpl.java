package com.fishingshop.database.impl.hibernate;

import com.fishingshop.database.IGearDAOI;
import com.fishingshop.model.Gear;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Repository
public class GearDAOImpl implements IGearDAOI {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Gear> getGears() {
        Session session = this.sessionFactory.openSession();
        Query<Gear> query = session.createQuery("FROM com.fishingshop.model.Gear");
        List<Gear> result = query.getResultList();
        session.close();
        return result;
    }

    @Override
    public Optional<Gear> getGearById(int gearId) {
        Session session = this.sessionFactory.openSession();
        Query<Gear> query = session.createQuery("FROM com.fishingshop.model.Gear WHERE id = :id");
        query.setParameter("id", gearId);
        try {
            Gear gear = query.getSingleResult();
            session.close();
            return Optional.of(gear);
        } catch (NoResultException e) {
            session.close();
            return Optional.empty();
        }
    }

    @Override
    public void updateGear(Gear gear) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(gear);
            tx.commit();
        } catch (Exception e) {
            if(tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }
}
