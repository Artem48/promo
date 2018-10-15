package com.scnetcracker.config;
import com.scnetcracker.dao.UserDao;
import com.scnetcracker.dao.UserDaoImpl;
import com.scnetcracker.service.UserService;
import com.scnetcracker.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


@Configuration
public class SpringConfig {

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());

    }
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource  source = new DriverManagerDataSource();
        source.setUrl("jdbc:mysql://localhost:3306/promo?useSll=false ");
        source.setUsername("root");
        source.setPassword("");
        source.setDriverClassName("com.mysql.jdbc.Driver");
        return source;
    }

    @Bean
    public UserDao getUserDao(){
        return new UserDaoImpl(getJdbcTemplate());
    }

    @Bean
    public UserService getUserService(){
        return new UserServiceImpl();
    }

}
