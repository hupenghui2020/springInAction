package com.hph.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * 启用web保护
 * @author 10499
 */
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Resource
    private DataSource dataSource;

    private final static String SQL_FOR_USERS_BY_USERNAME_QUERY = "select username, password, true from spitter where username = ?";

    private final static String SQL_FOR_AUTHORITIES_BY_USERNAME_QUERY = "select username `ROLE_USER` from spitter where username = ?";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // 基于数据库的认证
        auth.jdbcAuthentication()
                // 数据源
                .dataSource(dataSource)
                // 用户认证
                .usersByUsernameQuery(SQL_FOR_USERS_BY_USERNAME_QUERY)
                // 鉴权
                .authoritiesByUsernameQuery(SQL_FOR_AUTHORITIES_BY_USERNAME_QUERY);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                // 以下请求路径需要认证
                .antMatchers("/spitters/me").authenticated()
                // 对以下路径的 post 请求进行认证
                .antMatchers(HttpMethod.POST, "/spittles").authenticated()
                // 其他请求不需要认证
                .anyRequest().permitAll();
    }
}
