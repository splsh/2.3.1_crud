package application.config;

import application.entity.User;
import org.hibernate.dialect.MySQL8Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
@PropertySource("classpath:db.properties") // задаёт источник настроек для environment
@EnableTransactionManagement
// нужен ли компонент скан здесь если он уже есть в другом конфиге
public class DBConfig {

    private final Environment environment;

    //какая то херня
//    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Xz 4to tyt pisat'");
//
//    @Bean
//    public static EntityManager getEntityManager() {
//        return entityManagerFactory.createEntityManager();
//    }

    @Autowired      //environment нужен для подключения настроек к дата соурсу, хз как это работает
    public DBConfig(Environment env) {
        this.environment = env;
    }

    //источник данных для менеджера
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("db.driver"));
        dataSource.setUrl(environment.getProperty("db.url"));
        dataSource.setUsername(environment.getProperty("db.username"));
        dataSource.setPassword(environment.getProperty("db.password"));
        return dataSource;
    }

    @Bean
    public EntityManagerFactory configureEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(getDataSource());
        entityManagerFactoryBean.setPackagesToScan(environment.getProperty("db.entity.package"));
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setJpaProperties(getHibernateProperties());
        entityManagerFactoryBean.afterPropertiesSet();
        return (EntityManagerFactory) entityManagerFactoryBean.getObject();
    }

    @Bean
    public EntityManager entityManager() {
        return configureEntityManagerFactory().createEntityManager();
    }


    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(getDataSource());

        Properties props = new Properties();
        props.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
        props.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));

        factoryBean.setHibernateProperties(props);
        factoryBean.setAnnotatedClasses(User.class);
        return factoryBean;
    }
    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }

//    xuita
//    @Bean
//    public EntityManager getEntityManager() {
//        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactoryBean.setDataSource(getDataSource());
//        entityManagerFactoryBean.setPackagesToScan(environment.getProperty("db.entity.package"));
//        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//        Properties props = new Properties();
//        props.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
//        props.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
//        entityManagerFactoryBean.setJpaProperties(props);
//        return entityManagerFactoryBean.getObject().createEntityManager();
//    }


//    похоже что тоже самое что и выше, странно
//    @Bean
//    public EntityManager getEntityManager () {
//        return getLocalContainerEntityManagerFactoryBean().getObject().createEntityManager();
//    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));
            return properties;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



// похоже не годится
//    @Bean
//    public HibernateTransactionManager getTransactionManager() {
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//        transactionManager
//        return transactionManager;
//    }



}
