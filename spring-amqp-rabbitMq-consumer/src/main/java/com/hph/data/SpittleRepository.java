package com.hph.data;

import com.hph.model.Spittle;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 通过 EnableJpaRepositories 注解扫描，会自动生成 SpittleRepository 接口的实现
 * 实现 SpittleRepositorySwapper 是需要自定义的方法
 * @author com.hph
 */
public interface SpittleRepository extends JpaRepository<Spittle, String>,SpittleRepositorySwapper {
}
