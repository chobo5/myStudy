package bitcamp.myapp.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import java.io.InputStream;

@ComponentScan(value={"bitcamp.myapp.dao", "bitcamp.util"})
@PropertySource({"classpath:config/jdbc.properties"})
public class RootConfig {
    private final Log log = LogFactory.getLog(RootConfig.class);
    public RootConfig() {
        log.debug("생성자 호출");
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        String resource = "config/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }
}
