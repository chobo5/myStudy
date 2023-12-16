package com.example.springweb.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

//DB와 관련된 설정
//비즈니스를 처리하는 Service, Repository, Domain을 Bean으로 등록하기 위한 설
@Configuration
//.properties파일을 읽어들이기 위함
@PropertySource({"classpath:persistence-mysql.properties"})
public class AppConfig {
    //의존성 주입과 관련된 Annotation

    @Autowired //자동으로 객체를 초기화해준다
    //.properties파일에서 읽어들이 정보를 저장해서 사용할 수 있게 해준다.
    private Environment environment;

    //데이터베이스 접속과 관련된 객체(DataSource)를 만들어준다.
    //DataSource는 인터페이스이다.(고로 구현하고있는 객체를 리턴해준다.)
    //persistence-mysql.properties에 있는 정보를 이용해서 객체를 만든다.
    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource(); //DataSource 구현
        dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getProperty("jdbc.url"));
        dataSource.setUsername(environment.getProperty("jdbc.user"));
        dataSource.setPassword((environment.getProperty("jdbc.pass")));
        return dataSource
    }
}
