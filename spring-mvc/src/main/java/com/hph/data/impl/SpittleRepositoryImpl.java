package com.hph.data.impl;

import com.hph.data.SpittleRepositorySwapper;
import com.hph.model.Spittle;
import org.springframework.cache.annotation.Cacheable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 通过这种方式可以自定义 sql
 * SpittleRepositoryImpl 会与 SpittleRepository 接口自动生成的实现类进行合并
 * @author hph
 */
public class SpittleRepositoryImpl implements SpittleRepositorySwapper {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Spittle findOneSpittle(String id) {

        String sql = "select * from spittle where id =" + id;
        return (Spittle)entityManager.createQuery(sql).getSingleResult();
    }

    @Override
    public Spittle saveSpittle(Spittle spittle) {

        String insertSql = "INSERT INTO spittle values (:message, :time, :latitude, :longitude)";

        int n = entityManager.createQuery(insertSql)
                .setParameter("message", spittle.getMessage())
                .setParameter("time", spittle.getTime())
                .setParameter("latitude", spittle.getLatitude())
                .setParameter("longitude", spittle.getLongitude()).executeUpdate();

        return n > 0 ? entityManager.find(Spittle.class, spittle) : null;
    }

    @Override
    public void removeSpittle(String spittleId) {

        String deleteSql = "DELETE from spittle where id = " + spittleId;

        entityManager.createQuery(deleteSql).executeUpdate();
    }
}
