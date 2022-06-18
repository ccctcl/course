package spring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

public class jdbcConfig {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.user}")
    private String username;
    @Value("${jdbc.password}")
    private String password;


    @Bean(name="runner")
    public QueryRunner createQueryRunner(@Qualifier("ds") DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    @Bean(name="ds")
    public DataSource createDataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
    try {
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
    } catch (PropertyVetoException e) {
        e.printStackTrace();
    }

    return dataSource;
    }
}
