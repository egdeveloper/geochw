package hse.geo.vespera.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"hse.geo.vespera.domain", "hse.geo.vespera.repository"})
public class RepositoryConfig {

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://95.85.24.237:5432/geochw_db");
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("geochw_user");
        dataSource.setPassword("geochw95root");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }
}
