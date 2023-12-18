package com.example.springweb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@EnableTransactionManagement
//com.example이하에서 Service와 Repository 컴포넌트를 찾아 Bean으로 등록하
@ComponentScan(basePackages = {"com.example"},
        includeFilters = {@ComponentScan.Filter(Service.class),
        @ComponentScan.Filter(Repository.class)})
//com.example.repository이하는 JPA repository로 인식
@EnableJpaRepositories(basePackages = {"com.example.springweb.repository"})
@PropertySource({"classpath:persistence-mysql.properties"})



//DB와 관련된 설정
//비즈니스를 처리하는 Service, Repository, Domain을 Bean으로 등록하기 위한 설
@Configuration
//.properties파일을 읽어들이기 위함
@PropertySource({"classpath:persistence-mysql.properties"})
public class AppConfig {
    //의존성 주입과 관련된 Annotation
    @Autowired //자동으로 객체를 초기화해준다
    private Environment env; //.properties파일에서 읽어들이 정보를 저장해서 사용할 수 있게 해준다.

    //데이터베이스 접속과 관련된 객체(DataSource)를 만들어준다.
    //DataSource는 인터페이스이다.(고로 구현하고있는 객체를 리턴해준다.)
    //persistence-mysql.properties에 있는 정보를 이용해서 객체를 만든다.
    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource(); //DataSource 구현
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.user"));
        dataSource.setPassword((env.getProperty("jdbc.pass")));
        return dataSource;
    }

    //JPA를 다룰려면 트렌잭션을 처리 해야한다.
    //트렌잭션 시작, SQL실행, 트렌잭션 종료(commit, rollback)
    //스프링을 만든사람은 SQL만 실행하 트렌잭션의 실행과 종료는 자동으로 하게 하길원했다.
    //@Transactional 어노테이션을 이용해 트렌잭션을 자동으로 처리 할 수 있게 해준다.
    //트렌잭션을 관리하는 Bean이 필요하다.
    //EntityManagerFactory도 Bean으로 등록해야한다.

    @Bean
    public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    //LocalContainerEntityManagerFactoryBean은 EntityManagerFactory를 만들어주는 Bean이다.
    //LocalContainerEntityManagerFactoryBean은 DataSource가 필요하고, HibernateJpaVendorAdapter가 필요하다.
    //JPA는 ORM표준, 인터페이스, 구현체로는 Hibernate, EclipseLink, openJPA등이 있다.
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[]{"com.example"});

        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());
        return em;
    }

    //JPA Exception이 Spring에서 관리하는 Exception으로 자동 변환이 된다.
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
    final Properties additionalProperties() {
        final Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl,auto"));
        hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        hibernateProperties.setProperty("hibernate.cache.use_second_level_cache", env.getProperty("hibernate.cache.use_second_level_cache"));
        hibernateProperties.setProperty("hibernate.cache.use_query_cache", env.getProperty("hibernate.cache.use_query_cache"));
        return hibernateProperties;

    }
}
