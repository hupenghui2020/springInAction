package com.hph.data;

import com.hph.model.Spitter;
import com.hph.model.Spittle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 通过 EnableJpaRepositories 注解扫描，会自动生成 SpitterRepository 接口的实现
 * @author com.hph
 */

public interface SpitterRepository extends JpaRepository<Spitter,String> {
}
