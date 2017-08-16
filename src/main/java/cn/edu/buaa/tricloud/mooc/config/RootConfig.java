package cn.edu.buaa.tricloud.mooc.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
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
@PropertySource(value = {"classpath:jdbc.properties"})
public class RootConfig {

    @Bean
    public
    static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public DataSource dataSource(@Value("${jdbc.url}") String url,
                                 @Value("${jdbc.user.name}") String username,
                                 @Value("${jdbc.user.password}") String password,
                                 @Value("${jdbc.driver.name}") String drivername,
                                 @Value("${jdbc.size.action.init}") Integer initsize,
                                 @Value("${jdbc.size.action.max}") Integer maxsize)
    {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(drivername);
        dataSource.setInitialSize(initsize);
        dataSource.setMaxTotal(maxsize);
        return dataSource;
    }

//    @Bean
//    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan(new String[] {"cn.edu.buaa.tricloud.mooc.domain"});
        Properties properties = new Properties();
        properties.setProperty("dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
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
