package com.hph.data.impl;

import com.hph.data.SpitterRepository;
import com.hph.data.SpittleRepository;
import com.hph.model.Spitter;
import com.hph.model.Spittle;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hph
 */

@Repository
public class SpitterRepositoryImpl implements SpitterRepository {

    @Resource
    private JdbcOperations jdbcOperations;

    private List<Spitter> spitterList = new ArrayList<>();

    @Override
    public void save(Spitter spitter) {

        /*索引参数，使用JdbcTemplate，如果使用命名参数的话，则需要使用NamedParameterJdbcTemplate
        命名参数类型sql：insert into spitter (username, password, email) values (:username, :password, :email)*/
        jdbcOperations.update("insert into spitter (username, password, email) values (? ,? ,?)",
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getEmail());
    }

    @Override
    public Spitter findByUsername(String username) {

        return spitterList.stream().filter(spitter -> spitter.getUsername().equals(username)).findFirst().orElse(null);
    }
}
