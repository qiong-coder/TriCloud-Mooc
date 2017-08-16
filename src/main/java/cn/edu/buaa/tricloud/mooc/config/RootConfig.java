package cn.edu.buaa.tricloud.mooc.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.util.Properties;


/**
 * Created by qixiang on 8/14/17.
 */

@Configuration
@ComponentScan(basePackages = {"cn.edu.buaa.tricloud.mooc.service", "cn.edu.buaa.tricloud.mooc.repository"},
        excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value= EnableWebMvc.class) ,
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ControllerAdvice.class)})
public class RootConfig {

    @Bean
    public DataSource dataSource(Environment environment)
    {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(environment.getProperty("jdbc.url"));
        dataSource.setUsername(environment.getProperty("jdbc.user.name"));
        dataSource.setPassword(environment.getProperty("jdbc.user.password"));
        dataSource.setDriverClassName(environment.getProperty("jdbc.driver.name"));
        dataSource.setInitialSize(environment.getProperty("jdbc.size.action.init",Integer.class));
        dataSource.setMaxTotal(environment.getProperty("jdbc.size.action.max",Integer.class));
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan(new String[] {"cn.edu.buaa.tricloud.mooc.domain"});
        Properties properties = new Properties();
        properties.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
        properties.setProperty("show_sql", "true");
        properties.setProperty("format_sql", "true");
        properties.setProperty("hbm2ddl.auto", "update");
        factoryBean.setHibernateProperties(properties);
        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }

}
