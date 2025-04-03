package com.multi.travel_404.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.multi.travel_404"})
public class MybatisConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource datasource) throws Exception {
        SqlSessionFactoryBean seb = new SqlSessionFactoryBean();
        Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/*.xml");

        seb.setMapperLocations(res);

        seb.setDataSource(datasource);

        seb.setTypeAliasesPackage("com.multi.travel_404.member.model.dto, com.multi.travel_404.board.model.dto, com.multi.travel_404.travel.model.dto");

        SqlSessionFactory sqlSessionFactory = seb.getObject();
        if (sqlSessionFactory != null) {
            sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
        }

        return seb.getObject();
    }
}
