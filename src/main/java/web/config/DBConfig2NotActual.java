package web.config;


//@Configuration
//@PropertySource("classpath:db.properties")
//@EnableTransactionManagement
//@ComponentScan(value = "web")
public class DBConfig2NotActual {
//
//
//    @Resource
//    private Environment environment;
//
//    @Bean
//    public DataSource getDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(Objects.requireNonNull(environment.getProperty("db.driver")));
//        dataSource.setUrl(environment.getProperty("db.url"));
//        dataSource.setUsername(environment.getProperty("db.username"));
//        dataSource.setPassword(environment.getProperty("db.password"));
//        return dataSource;
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean(){
//        LocalContainerEntityManagerFactoryBean entityMFB = new LocalContainerEntityManagerFactoryBean();
//        entityMFB.setDataSource(getDataSource());
//        entityMFB.setPersistenceProviderClass(HibernatePersistenceProvider.class);
//        entityMFB.setPackagesToScan(environment.getRequiredProperty("db.entity.packages"));
//        entityMFB.setJpaProperties(getHibernateProperties());
//        return entityMFB;
//    }
//
//    @Bean
//    public JpaTransactionManager getTransactionManager() {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(getEntityManagerFactoryBean().getObject());
//        return transactionManager;
//    }
//
//    private Properties getHibernateProperties(){
//        Properties properties = new Properties();
//        properties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
//        properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
//        properties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
//        return properties;
//    }
}
