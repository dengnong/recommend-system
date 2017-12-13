package com.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.persistence.SharedCacheMode;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = false, exposeProxy = true)
@EnableTransactionManagement(proxyTargetClass = false)
@EnableJpaRepositories(basePackages = {"com.repository"},
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "transactionManager")
@PropertySource(encoding = "UTF-8", value = {"classpath:bundle/db.properties", "classpath:bundle/hbm.properties"})
@ComponentScan(basePackages = {"com.repository", "com.service"}, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, ControllerAdvice.class})
})
public class SpringConfig {

    /**
     * 数据源配置
     */
    @Value(value = "${mysql.url}")
    private String url;
    @Value(value = "${mysql.driverClassName}")
    private String driverClassName;
    @Value(value = "${mysql.username}")
    private String username;
    @Value(value = "${mysql.password}")
    private String password;
    @Value(value = "${druid.minIdle}")
    private int minIdle;
    @Value(value = "${druid.maxActive}")
    private int maxActive;
    @Value(value = "${druid.testWhileIdle}")
    private boolean testWhileIdle;

    /**
     * JPA 规范的 Hibernate 实现
     */
    @Value(value = "${hibernate.show_sql}")
    private boolean showSql;
    @Value(value = "${hibernate.format_sql}")
    private boolean formatSql;
    @Value(value = "${hibernate.hbm2ddl.auto}")
    private String hbm2ddl;
    @Value(value = "${hibernate.dialect}")
    private String dialect;
    /**
     * 二级缓存
     */
    @Value(value = "${hibernate.cache.use_second_level_cache}")
    private boolean useSecondLevelCache;
    @Value(value = "${hibernate.cache.region.factory_class}")
    private String cacheRegionFactory;
    @Value(value = "${hibernate.cache.provider_configuration_file_resource_path}")
    private String cacheProviderConfigLocation;
    @Value(value = "${hibernate.cache.use_query_cache}")
    private boolean useQueryCache;
    @Value(value = "${jpa.shared-cache-mode}")
    private String sharedCacheMode;


    // 必须指定返回类型为 DruidDataSource 才能够执行其中的方法；如果返回 DataSource 类型是没有这两个方法的
    @Bean(name = "dataSource", initMethod = "init", destroyMethod = "close")
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxActive(maxActive);
        dataSource.setTestWhileIdle(testWhileIdle);
        return dataSource;
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new
                LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setPackagesToScan("com.entity", "com.converter.jpa");
        Map<String, Object> jpaPropertyMap = new HashMap<>();
        jpaPropertyMap.put(Environment.DIALECT, dialect);
        jpaPropertyMap.put(Environment.SHOW_SQL, showSql);
        jpaPropertyMap.put(Environment.FORMAT_SQL, formatSql);
        jpaPropertyMap.put(Environment.HBM2DDL_AUTO, hbm2ddl);
        // 二级缓存配置
        jpaPropertyMap.put(Environment.USE_SECOND_LEVEL_CACHE, useSecondLevelCache);
        jpaPropertyMap.put(Environment.CACHE_REGION_FACTORY, cacheRegionFactory);
        jpaPropertyMap.put(Environment.CACHE_PROVIDER_CONFIG, cacheProviderConfigLocation);
        jpaPropertyMap.put(Environment.USE_QUERY_CACHE, useQueryCache);
        factoryBean.setJpaPropertyMap(jpaPropertyMap);
        // 设置只有使用 @javax.persistence.Cacheable 注解标注的实体能够被缓存
        factoryBean.setSharedCacheMode(SharedCacheMode.valueOf(sharedCacheMode));
        return factoryBean;
    }

    @Bean(name = "transactionManager")
    public JpaTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }

}
