package com.hph.data.impl;

import com.hph.data.SpittleRepositorySwapper;
import com.hph.model.Spittle;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.UUID;

/**
 * 通过这种方式可以自定义 sql
 * SpittleRepositoryImpl 会与 SpittleRepository 接口自动生成的实现类进行合并
 * @author com.hph
 */
public class SpittleRepositoryImpl implements SpittleRepositorySwapper {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Spittle findOneSpittle(String id) {

        System.out.println("我没走缓存");
        String sql = "select * from spittle where id ='" + id +"'";
        return entityManager.find(Spittle.class, id);
    }

    @Override
    public Spittle saveSpittle(Spittle spittle) {

        String insertSql = "INSERT INTO spittle values (:id, :message, :createTime, :latitude, :longitude)";

        String id = UUID.randomUUID().toString();

        int n = entityManager.createNativeQuery(insertSql)
                .setParameter("id", id)
                .setParameter("message", spittle.getMessage())
                .setParameter("createTime", spittle.getCreateTime())
                .setParameter("latitude", spittle.getLatitude())
                .setParameter("longitude", spittle.getLongitude()).executeUpdate();

        return n > 0 ? entityManager.find(Spittle.class, id) : null;
    }

    @Override
    public void removeSpittle(String spittleId) {

        String deleteSql = "DELETE from spittle where id = :id";

        entityManager.createNativeQuery(deleteSql)
                .setParameter("id", spittleId).executeUpdate();
    }
}
